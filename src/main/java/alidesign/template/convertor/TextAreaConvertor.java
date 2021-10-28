package alidesign.template.convertor;

/**
 * @Author 喻可
 * @Date 2021/10/28 18:32
 */

import alidesign.template.convertor.template.FormItemConverter;
import alidesign.template.entity.FormItemTypeEnum;
import org.springframework.stereotype.Component;

/**
 * 多行文本框的转换器
 */
@Component
public class TextAreaConvertor extends FormItemConverter {

    @Override
    public FormItemTypeEnum getType() {
        return FormItemTypeEnum.TEXT_AREA;
    }
}
