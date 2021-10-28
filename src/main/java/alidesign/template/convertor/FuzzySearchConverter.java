package alidesign.template.convertor;

/**
 * @Author 喻可
 * @Date 2021/10/28 18:31
 */

import alidesign.template.convertor.template.FormItemConverter;
import alidesign.template.entity.FormComponentProps;
import alidesign.template.entity.FormItem;
import alidesign.template.entity.FormItemConfig;
import alidesign.template.entity.FormItemTypeEnum;
import org.springframework.stereotype.Component;

/**
 * 模糊搜索框的转换器
 */
@Component
public class FuzzySearchConverter extends FormItemConverter {

    @Override
    public FormItemTypeEnum getType() {
        return FormItemTypeEnum.FUZZY_SEARCH;
    }

    @Override
    protected void afterItemCreate(FormItem item, FormItemConfig config) {
        item.setFuzzySearch(true);
    }

    @Override
    protected void afterPropsCreate(FormComponentProps props, FormItemConfig config) {
        props.setAutoWidth(false);
    }
}
