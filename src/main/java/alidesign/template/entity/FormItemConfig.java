package alidesign.template.entity;

/**
 * @Author 喻可
 * @Date 2021/10/28 17:44
 */
public class FormItemConfig {
    private String code;
    private String title;
    private String component;
    private boolean readOnly;
    private CharSequence placeholder;
    private boolean required;
    private boolean multiple;
    private Integer minLength;
    private Integer maxLength;
    private FormItemTypeEnum type;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public CharSequence getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(CharSequence placeholder) {
        this.placeholder = placeholder;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean isMultiple() {
        return multiple;
    }

    public void setMultiple(boolean multiple) {
        this.multiple = multiple;
    }

    public Integer getMinLength() {
        return minLength;
    }

    public void setMinLength(Integer minLength) {
        this.minLength = minLength;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public FormItemTypeEnum getType() {
        return type;
    }

    public void setType(FormItemTypeEnum type) {
        this.type = type;
    }
}
