package design.structure.proxy.aliaspect.module;

import design.structure.proxy.aliaspect.annotation.Persistence;
import design.structure.proxy.aliaspect.repository.Module;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 被代理的对象
 */
@Component("edgeCloudInfModule")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Getter
@Setter
public class EdgeCloudInfModule extends Module {

    /**
     * 新建模块并持久化到档案中心
     * 在该方法操作完以后 执行moduleRepository里的add方法
     */
    @Persistence(repositoryName = "moduleRepository", method = "add")
    public void newModel() {
        setLifeCycle(LifeCycleEnum.CONSTRUCTION.getLifeCycle());
    }

}
