package alidesign.pipeline.executor;

/**
 * @Author 喻可
 * @Date 2021/10/27 17:21
 */

import alidesign.pipeline.handler.CommonHeadHandler;
import alidesign.pipeline.handler.CommonTailHandler;
import alidesign.pipeline.handler.ContextHandler;
import alidesign.pipeline.pipeline.PipelineContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.BiConsumer;

/**
 * 管道执行器
 */
@Component
public class PipelineExecutor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 管道线程池
     */
    @Resource
    private ThreadPoolTaskExecutor pipelineThreadPool;

    @Autowired
    private CommonHeadHandler commonHeadHandler;

    @Autowired
    private CommonTailHandler commonTailHandler;

    /**
     * 引用 PipelineRouteConfig 中的 pipelineRouteMap
     * 这里为什么是super的解释在下面
     */
    @Resource
    private Map<Class<? extends PipelineContext>,
                List<? extends ContextHandler<? super PipelineContext>>> pipelineRouteMap;

    /**
     * 同步处理输入的上下文数据<br/>
     * 如果处理时上下文数据流通到最后一个处理器且最后一个处理器返回 true，则返回 true，否则返回 false
     *
     * @param context 输入的上下文数据
     * @return 处理过程中管道是否畅通，畅通返回 true，不畅通返回 false
     */
    public boolean acceptSync(PipelineContext context) {
        Objects.requireNonNull(context, "上下文数据不能为 null");
        // 拿到数据类型
        Class<? extends PipelineContext> dataType = context.getClass();
        List<? extends ContextHandler<? super PipelineContext>> pipeline = pipelineRouteMap.get(dataType);

        if (CollectionUtils.isEmpty(pipeline)) {
            logger.error("{} 的管道为空", dataType.getSimpleName());
            return false;
        }

        // 【通用头处理器】处理
        commonHeadHandler.handle(context);

        // 管道是否畅通
        boolean lastSuccess = true;

        for (ContextHandler<? super PipelineContext> handler : pipeline) {
            try {
                // 当前处理器处理数据，并返回是否继续向下处理
                lastSuccess = handler.handle(context);
            } catch (Throwable ex) {
                lastSuccess = false;
                logger.error("[{}] 处理异常，handler={}", context.getName(), handler.getClass().getSimpleName(), ex);
            }

            // 不再向下处理
            if (!lastSuccess) { break; }
        }

        // 【通用尾处理器】处理
        commonTailHandler.handle(context);

        return lastSuccess;
    }

    /**
     * 异步处理输入的上下文数据
     * 参考AsyncConfig的使用  配置ThreadPoolTaskExecutor然后使用@Async实现异步
     * @param context  上下文数据
     * @param callback 处理完成的回调
     */
    public boolean acceptAsync(PipelineContext context, BiConsumer<PipelineContext, Boolean> callback) throws ExecutionException, InterruptedException {
        Future<Boolean> submit = pipelineThreadPool.submit(() -> {
            boolean success = acceptSync(context);

            if (callback != null) {
                callback.accept(context, success);
            }
            return success;
        });
        return submit.get();
    }

    /**
     * 关于容器中注入的是extends，为什么能取出是super chatgpt回答
     *
     * 在Spring容器中注入的类型是Map<Class<? extends PipelineContext>, List<? extends ContextHandler<? extends PipelineContext>>>，
     * 这是因为Spring框架对泛型类型的处理有一些限制。
     *
     * 在Spring中，当注入一个泛型类型的Bean时，框架会进行类型擦除，即在运行时无法获取到具体的泛型类型参数。
     * 因此，Spring将泛型类型的参数限定为上界通配符<? extends T>，这样可以保证在获取Bean时不会出现类型不匹配的问题。
     *
     * 但是，在实际使用pipelineRouteMap时，由于Java的类型推断机制和泛型的协变性，
     * 我们可以将pipelineRouteMap赋给一个类型为Map<Class<? extends PipelineContext>, List<? extends ContextHandler<? super PipelineContext>>>的变量，
     * 并且能够正常使用。这是因为<? extends T>的通配符上界包括了T以及其子类，而<? super T>的通配符下界包括了T以及其父类。
     * 因此，我们可以安全地将? extends ContextHandler<? extends PipelineContext>赋给? super ContextHandler<? super PipelineContext>。
     *
     * 综上所述，尽管在注入到Spring容器时使用的是Map<Class<? extends PipelineContext>, List<? extends ContextHandler<? extends PipelineContext>>>，
     * 但在实际使用时可以将其赋给Map<Class<? extends PipelineContext>, List<? extends ContextHandler<? super PipelineContext>>>类型的变量，并且能够正常使用。
     * 这是由于Java的类型推断和泛型的协变性机制。
     */


    /**
     * 关于为什么不能直接使用extends，chatgpt的两种回答
     */
//回答1
//    在这种情况下，使用private Map<Class<? extends PipelineContext>, List<? extends ContextHandler<? super PipelineContext>>> pipelineRouteMap 是为了更好地支持协变性。
//
//    考虑以下情况：假设我们有两个类，PipelineContext和SpecialPipelineContext，其中SpecialPipelineContext是PipelineContext的子类。同时，我们有两个类，ContextHandler<PipelineContext>和ContextHandler<SpecialPipelineContext>，其中ContextHandler<SpecialPipelineContext>是ContextHandler<PipelineContext>的子类。
//
//    如果我们使用private Map<Class<? extends PipelineContext>, List<? extends ContextHandler<? extends PipelineContext>>> pipelineRouteMap，则对于特定的PipelineContext类型，只能存储相应类型的ContextHandler<PipelineContext>，而无法存储其子类型的ContextHandler<SpecialPipelineContext>。这是因为List<? extends ContextHandler<? extends PipelineContext>>不能保证能够接受ContextHandler<SpecialPipelineContext>类型的列表。
//
//    但是，如果我们使用private Map<Class<? extends PipelineContext>, List<? extends ContextHandler<? super PipelineContext>>> pipelineRouteMap，则对于特定的PipelineContext类型，我们可以存储其父类型的ContextHandler<PipelineContext>以及任何其他适用于父类型的子类型的ContextHandler。这是因为List<? extends ContextHandler<? super PipelineContext>>可以接受ContextHandler<PipelineContext>及其父类型的列表。
//
//    因此，通过使用super关键字，我们可以更灵活地定义泛型类型的上界，使得pipelineRouteMap可以接受更广泛的ContextHandler类型，从而支持更多的协变性场景。


//回答2
//    在这种情况下，使用Map<Class<? extends PipelineContext>, List<? extends ContextHandler<? extends PipelineContext>>>会导致类型不匹配的问题。
//
//    首先，让我们回顾一下extends和super在泛型中的含义。在泛型中，extends用于指定上界，表示类型参数必须是指定类型或其子类型；而super用于指定下界，表示类型参数必须是指定类型或其父类型。
//
//    现在考虑一下 pipelineRouteMap 的用途。它是一个映射，将 PipelineContext 的子类作为键，将处理 PipelineContext 或其父类的处理器列表作为值。如果我们将其声明为Map<Class<? extends PipelineContext>, List<? extends ContextHandler<? extends PipelineContext>>>，那么在添加处理器时会出现类型不匹配的问题。
//
//    假设我们有一个具体的 PipelineContext 类型为 MyContext，并且有一个处理 PipelineContext 或其父类的处理器 MyHandler。如果我们尝试将 MyHandler 添加到 pipelineRouteMap.get(MyContext.class) 返回的列表中，编译器会报错，因为 List<? extends ContextHandler<? extends PipelineContext>> 不允许添加 MyHandler。这是因为 List<? extends ContextHandler<? extends PipelineContext>> 的元素类型是不确定的，可能是 ContextHandler<PipelineContext>、ContextHandler<SubContext> 或其他子类型，而编译器无法确定是否允许添加 MyHandler。
//
//    为了解决这个问题，我们需要使用 super 关键字。通过声明为 Map<Class<? extends PipelineContext>, List<? extends ContextHandler<? super PipelineContext>>>，我们将上界从 PipelineContext 扩展到 super PipelineContext。这意味着值列表的元素类型可以是 ContextHandler<PipelineContext> 或其父类型，而不仅仅是 PipelineContext 的子类型。因此，我们可以安全地将 MyHandler 添加到 pipelineRouteMap.get(MyContext.class) 返回的列表中。
//
//    综上所述，为了保持类型的匹配并允许添加处理器，我们需要使用 super 关键字来声明 pipelineRouteMap 的类型为 Map<Class<? extends PipelineContext>, List<? extends ContextHandler<? super PipelineContext>>>。

}