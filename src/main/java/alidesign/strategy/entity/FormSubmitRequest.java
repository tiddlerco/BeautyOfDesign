package alidesign.strategy.entity;

/**
 * @title: FormSubmitRequest
 * @Author yuke
 * @Date: 2021/10/29 8:04
 */


import alidesign.strategy.handler.FormSubmitHandler;

import java.util.Map;

/**
 * 表单提交的请求
 */
public class FormSubmitRequest {

    /**
     * 提交类型
     *
     * @see FormSubmitHandler#getSubmitType()
     */
    private String submitType;

    /**
     * 用户 id
     */
    private Long userId;

    /**
     * 表单提交的值
     */
    private Map<String, Object> formInput;

    // 其他属性


    public String getSubmitType() {
        return submitType;
    }

    public void setSubmitType(String submitType) {
        this.submitType = submitType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Map<String, Object> getFormInput() {
        return formInput;
    }

    public void setFormInput(Map<String, Object> formInput) {
        this.formInput = formInput;
    }
}
