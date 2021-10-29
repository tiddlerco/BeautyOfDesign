package alidesign.strategy.handler;

import alidesign.strategy.entity.CommonPairResponse;
import alidesign.strategy.entity.FormSubmitRequest;
import alidesign.strategy.handler.FormSubmitHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @title: HSF 模式的提交
 * @Author yuke
 * @Date: 2021/10/29 8:14
 */
@Component
public class FormHsfSubmitHandler implements FormSubmitHandler<Serializable> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String getSubmitType() { return "hsf"; }

    @Override
    public CommonPairResponse<String, Serializable> handleSubmit(FormSubmitRequest request) {
        logger.info("HSF 模式提交：userId={}, formInput={}", request.getUserId(), request.getFormInput());

        // 进行 HSF 泛化调用，获得业务方返回的提示信息和业务数据
        CommonPairResponse<String, Serializable> response = hsfSubmitData(request);

        return response;
    }

    private CommonPairResponse<String, Serializable> hsfSubmitData(FormSubmitRequest request) {
        return null;
    }

}
