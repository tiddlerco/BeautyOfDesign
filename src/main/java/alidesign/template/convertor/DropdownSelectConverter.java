package alidesign.template.convertor;

/**
 * 模板的实现
 * 针对不同的表单项，对特殊步骤进行自定义处理
 *
 * @Author 喻可
 * @Date 2021/10/28 18:26
 */

import alidesign.template.convertor.template.FormItemConverter;
import alidesign.template.entity.*;
import org.springframework.stereotype.Component;


/**
 * 下拉选择框的转换器
 */
@Component
public class DropdownSelectConverter extends FormItemConverter {

    @Override
    public FormItemTypeEnum getType() {
        return FormItemTypeEnum.DROPDOWN_SELECT;
    }

    @Override
    protected void afterPropsCreate(FormComponentProps props, FormItemConfig config) {
        props.setAutoWidth(false);

        if (config.isMultiple()) {
            props.setMode("multiple");
        }
    }
}








