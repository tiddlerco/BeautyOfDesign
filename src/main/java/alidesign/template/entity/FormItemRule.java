package alidesign.template.entity;

/**
 * @Author 喻可
 * @Date 2021/10/28 17:45
 */
public class FormItemRule {
    private boolean required;
    private String message;
    private Integer min;
    private Integer max;

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean getRequired() {
        return required;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMin() {
        return min;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getMax() {
        return max;
    }
}
