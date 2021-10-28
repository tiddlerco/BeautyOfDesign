package alidesign.template.entity;

/**
 * @Author 喻可
 * @Date 2021/10/28 17:44
 */
public class FormComponentProps {
    private boolean readOnly;
    private CharSequence placeholder;
    private boolean autoWidth;
    private String mode;

    public void setReadOnly(boolean readOnly) {

        this.readOnly = readOnly;
    }

    public boolean getReadOnly() {
        return readOnly;
    }

    public void setPlaceholder(CharSequence placeholder) {
        this.placeholder = placeholder;
    }

    public CharSequence getPlaceholder() {
        return placeholder;
    }

    public void setAutoWidth(boolean autoWidth) {
        this.autoWidth = autoWidth;
    }

    public boolean getAutoWidth() {
        return autoWidth;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }
}
