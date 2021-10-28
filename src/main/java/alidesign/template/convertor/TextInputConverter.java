package alidesign.template.convertor;

/**
 * @Author 喻可
 * @Date 2021/10/28 18:32
 */

import alidesign.template.entity.FormItemTypeEnum;
import org.springframework.stereotype.Component;

/**
 * 单行文本框的转换器
 */
@Component
public class TextInputConverter extends CommonTextConverter {

    @Override
    public FormItemTypeEnum getType() {
        return FormItemTypeEnum.TEXT_INPUT;
    }
}