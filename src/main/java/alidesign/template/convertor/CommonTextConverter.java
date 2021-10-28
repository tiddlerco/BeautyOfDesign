package alidesign.template.convertor;

/**
 * @Author 喻可
 * @Date 2021/10/28 18:31
 */

import alidesign.template.convertor.template.FormItemConverter;
import alidesign.template.entity.FormItemConfig;
import alidesign.template.entity.FormItemRule;

import java.util.List;

/**
 * 通用文本类转换器
 */
public abstract class CommonTextConverter extends FormItemConverter {

    @Override
    protected void afterRulesCreate(List<FormItemRule> rules, FormItemConfig config) {
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
}