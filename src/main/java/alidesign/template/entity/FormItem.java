package alidesign.template.entity;

import java.util.List;

/**
 * @Author 喻可
 * @Date 2021/10/28 17:44
 */
public class FormItem {
    private FormComponentProps componentProps;
    private List<FormItemRule> rules;
    private String code;
    private String title;
    private String component;
    private boolean fuzzySearch;


    public void setComponentProps(FormComponentProps componentProps) {
        this.componentProps = componentProps;
    }

    public FormComponentProps getComponentProps() {
        return componentProps;
    }

    public void setRules(List<FormItemRule> rules) {
        this.rules = rules;
    }

    public List<FormItemRule> getRules() {
        return rules;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getComponent() {
        return component;
    }

    public void setFuzzySearch(boolean fuzzySearch) {
        this.fuzzySearch = fuzzySearch;
    }

    public boolean getFuzzySearch() {
        return fuzzySearch;
    }
}
