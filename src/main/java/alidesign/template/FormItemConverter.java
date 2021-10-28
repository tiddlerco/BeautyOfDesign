package alidesign.template;

import alidesign.template.entity.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 未使用模板方法之前
 * <p>
 * 平台的动态表单在配置表单项的过程中，每新增一个表单项，
 * 都要根据表单项的组件类型（例如 单行文本框、下拉选择框）
 * 和当前输入的各种配置来转换好对应的 Schema 并保存在 DB 中
 *
 * @Author 喻可
 * @Date 2021/10/28 18:37
 */
public class FormItemConverter {
    /**
     * 将输入的配置转变为表单项
     *
     * @param config 前端输入的配置
     * @return 表单项
     */
    public FormItem convert(FormItemConfig config) {
        FormItem formItem = new FormItem();

        // 公共的表单项属性
        formItem.setTitle(config.getTitle());
        formItem.setCode(config.getCode());
        formItem.setComponent(config.getComponent());

        // 创建表单组件的属性
        FormComponentProps props = new FormComponentProps();
        formItem.setComponentProps(props);

        // 公共的组件属性
        if (config.isReadOnly()) {
            props.setReadOnly(true);
        }

        FormItemTypeEnum type = config.getType();

        // 下拉选择框的特殊属性处理
        if (type == FormItemTypeEnum.DROPDOWN_SELECT) {
            props.setAutoWidth(false);

            if (config.isMultiple()) {
                props.setMode("multiple");
            }
        }

        // 模糊搜索框的特殊属性处理
        if (type == FormItemTypeEnum.FUZZY_SEARCH) {
            formItem.setFuzzySearch(true);
            props.setAutoWidth(false);
        }

        // ...  其他组件的特殊处理

        // 创建约束规则
        List<FormItemRule> rules = new ArrayList<>(2);
        formItem.setRules(rules);

        // 每个表单项都可有的约束规则
        if (config.isRequired()) {
            FormItemRule requiredRule = new FormItemRule();
            requiredRule.setRequired(true);
            requiredRule.setMessage("请输入" + config.getTitle());

            rules.add(requiredRule);
        }

        // 文本输入框才有的规则
        if (type == FormItemTypeEnum.TEXT_INPUT || type == FormItemTypeEnum.TEXT_AREA) {
            Integer minLength = config.getMinLength();

            if (minLength != null && minLength > 0) {
                FormItemRule minRule = new FormItemRule();
                minRule.setMin(minLength);
                minRule.setMessage("请至少输入 " + minLength + " 个字");

                rules.add(minRule);
            }

            Integer maxLength = config.getMaxLength();

            if (maxLength != null && maxLength > 0) {
                FormItemRule maxRule = new FormItemRule();
                maxRule.setMax(maxLength);
                maxRule.setMessage("请最多输入 " + maxLength + " 个字");

                rules.add(maxRule);
            }
        }

        // ... 其他约束规则

        return formItem;
    }
}
