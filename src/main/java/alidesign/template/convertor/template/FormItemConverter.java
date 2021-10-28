package alidesign.template.convertor.template;

import alidesign.template.entity.*;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义出模板
 * 即首先定义出表单项转换的操作流程，即如下的 convert 方法（使用 final 修饰，确保子类不可修改操作流程
 *
 * @Author 喻可
 * @Date 2021/10/28 17:42
 */
public abstract class FormItemConverter {

    /**
     * 子类可处理的表单项类型
     */
    public abstract FormItemTypeEnum getType();

    /**
     * 将输入的配置转变为表单项的操作流程
     *
     * @param config 前端输入的配置
     * @return 表单项
     */
    public final FormItem convert(FormItemConfig config) {
        FormItem item = createItem(config);
        // 表单项创建完成之后，子类如果需要特殊处理，可覆写该方法
        afterItemCreate(item, config);

        FormComponentProps props = createComponentProps(config);
        item.setComponentProps(props);
        // 组件属性创建完成之后，子类如果需要特殊处理，可覆写该方法
        afterPropsCreate(props, config);

        List<FormItemRule> rules = createRules(config);
        item.setRules(rules);
        // 约束规则创建完成之后，子类如果需要特殊处理，可覆写该方法
        afterRulesCreate(rules, config);

        return item;
    }

    /**
     * 共用逻辑：创建表单项、设置通用的表单项属性
     */
    private FormItem createItem(FormItemConfig config) {
        FormItem formItem = new FormItem();

        formItem.setCode(config.getCode());
        formItem.setTitle(config.getTitle());
        formItem.setComponent(config.getComponent());

        return formItem;
    }

    /**
     * 表单项创建完成之后，子类如果需要特殊处理，可覆写该方法
     */
    protected void afterItemCreate(FormItem item, FormItemConfig config) {
    }

    /**
     * 共用逻辑：创建组件属性、设置通用的组件属性
     */
    private FormComponentProps createComponentProps(FormItemConfig config) {
        FormComponentProps props = new FormComponentProps();

        if (config.isReadOnly()) {
            props.setReadOnly(true);
        }

        if (StringUtils.isNotBlank(config.getPlaceholder())) {
            props.setPlaceholder(config.getPlaceholder());
        }

        return props;
    }

    /**
     * 组件属性创建完成之后，子类如果需要特殊处理，可覆写该方法
     */
    protected void afterPropsCreate(FormComponentProps props, FormItemConfig config) {
    }

    /**
     * 共用逻辑：创建约束规则、设置通用的约束规则
     */
    private List<FormItemRule> createRules(FormItemConfig config) {
        List<FormItemRule> rules = new ArrayList<>(4);

        if (config.isRequired()) {
            FormItemRule requiredRule = new FormItemRule();
            requiredRule.setRequired(true);
            requiredRule.setMessage("请输入" + config.getTitle());

            rules.add(requiredRule);
        }

        return rules;
    }

    /**
     * 约束规则创建完成之后，子类如果需要特殊处理，可覆写该方法
     */
    protected void afterRulesCreate(List<FormItemRule> rules, FormItemConfig config) {
    }
}
