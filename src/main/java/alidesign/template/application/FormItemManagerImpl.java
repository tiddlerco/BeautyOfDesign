package alidesign.template.application;

import alidesign.template.convertor.template.FormItemConverter;
import alidesign.template.entity.FormItem;
import alidesign.template.entity.FormItemConfig;
import alidesign.template.factory.FormItemConverterFactory;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author 喻可
 * @Date 2021/10/28 18:50
 */
@Component
public class FormItemManagerImpl {

    @Autowired
    private FormItemConverterFactory converterFactory;

    public List<FormItem> convertFormItems(JSONArray inputConfigs) {
        return IntStream.range(0, inputConfigs.size())
                .mapToObj(inputConfigs::getJSONObject)
                //.map(item->convertFormItem(item))等价于下面的用法
                .map(this::convertFormItem)
                .collect(Collectors.toList());
    }

    private FormItem convertFormItem(JSONObject inputConfig) {
        FormItemConfig itemConfig = inputConfig.toJavaObject(FormItemConfig.class);
        FormItemConverter converter = converterFactory.getConverter(itemConfig.getType());

        if (converter == null) {
            throw new IllegalArgumentException("不存在转换器：" + itemConfig.getType());
        }

        return converter.convert(itemConfig);
    }
}
