package alidesign.template.factory;

import alidesign.template.convertor.template.FormItemConverter;
import alidesign.template.entity.FormItemTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;

/**
 * @Author 喻可
 * @Date 2021/10/28 18:41
 */
@Component
public class FormItemConverterFactory {

    private static final
    EnumMap<FormItemTypeEnum, FormItemConverter> CONVERTER_MAP = new EnumMap<>(FormItemTypeEnum.class);

    /**
     * 根据表单项类型获得对应的转换器
     *
     * @param type 表单项类型
     * @return 表单项转换器
     */
    public FormItemConverter getConverter(FormItemTypeEnum type) {
        return CONVERTER_MAP.get(type);
    }

    @Autowired
    public void setConverters(List<FormItemConverter> converters) {
        for (final FormItemConverter converter : converters) {
            CONVERTER_MAP.put(converter.getType(), converter);
        }
    }
}
