package alidesign.template.convertor;

import alidesign.template.convertor.template.FormItemConverter;
import alidesign.template.entity.FormItemConfig;
import alidesign.template.entity.FormItemRule;
import alidesign.template.entity.FormItemTypeEnum;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 此时要加入一种新的表单项 —— 数字选择器（NUMBER_PICKER），它有着特殊的约束条件：
 * 最小值和最大值，输入到 FormItemConfig 时分别为 minNumer 和 maxNumber
 * @Author 喻可
 * @Date 2021/10/29 14:46
 */
@Component
public class NumberPickerConverter extends FormItemConverter {

    @Override
    public FormItemTypeEnum getType() {
        return FormItemTypeEnum.NUMBER_PICKER;
    }

    @Override
    protected void afterRulesCreate(List<FormItemRule> rules, FormItemConfig config) {
        Integer minNumber = config.getMinNumber();
        // 处理最小值
        if (minNumber != null) {
            FormItemRule minNumRule = new FormItemRule();

            minNumRule.setMinimum(minNumber);
            minNumRule.setMessage("输入数字不能小于 " + minNumber);

            rules.add(minNumRule);
        }

        Integer maxNumber = config.getMaxNumber();
        // 处理最大值
        if (maxNumber != null) {
            FormItemRule maxNumRule = new FormItemRule();

            maxNumRule.setMaximum(maxNumber);
            maxNumRule.setMessage("输入数字不能大于 " + maxNumber);

            rules.add(maxNumRule);
        }
    }
}
