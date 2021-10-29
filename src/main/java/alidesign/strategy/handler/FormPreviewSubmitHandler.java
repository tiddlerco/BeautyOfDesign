package alidesign.strategy.handler;

import alidesign.strategy.entity.CommonPairResponse;
import alidesign.strategy.entity.FormSubmitRequest;
import alidesign.strategy.handler.FormSubmitHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @title: 预览表单时的提交
 * @Author yuke
 * @Date: 2021/10/29 8:06
 */
@Component
public class FormPreviewSubmitHandler implements FormSubmitHandler<Serializable> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String getSubmitType() { return "preview"; }

    @Override
    public CommonPairResponse<String, Serializable> handleSubmit(FormSubmitRequest request) {
        logger.info("预览模式提交：userId={}, formInput={}", request.getUserId(), request.getFormInput());

        return CommonPairResponse.success("预览模式提交数据成功！", null);
    }
}
