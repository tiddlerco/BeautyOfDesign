package alidesign.strategy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * @title: SimpleController
 * @Author yuke
 * @Date: 2021/10/29 8:20
 */
@RestController
public class SimpleController {

    @Autowired
    private FormServiceImpl formService;

    @PostMapping("/form/submit")
    public CommonPairResponse<String, Serializable> submitForm(@RequestParam String submitType,
                                                               @RequestParam String formInputJson) {
        JSONObject formInput = JSON.parseObject(formInputJson);

        FormSubmitRequest request = new FormSubmitRequest();
        request.setUserId(123456L);
        request.setSubmitType(submitType);
        request.setFormInput(formInput);

        return formService.submitForm(request);
    }
}
