package alidesign.strategy;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @title: 使用 & 测试
 * @Author yuke
 * @Date: 2021/10/29 8:18
 */
@Service
public class FormServiceImpl {

    @Autowired
    private FormSubmitHandlerFactory submitHandlerFactory;

    public CommonPairResponse<String, Serializable> submitForm(@NonNull FormSubmitRequest request) {
        String submitType = request.getSubmitType();

        // 根据 submitType 找到对应的提交处理器
        FormSubmitHandler<Serializable> submitHandler = submitHandlerFactory.getHandler(submitType);

        // 判断 submitType 对应的 handler 是否存在
        if (submitHandler == null) {
            return CommonPairResponse.failure("非法的提交类型: " + submitType);
        }

        // 处理提交
        return submitHandler.handleSubmit(request);
    }
}
