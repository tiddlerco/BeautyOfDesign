package design.adapter.应用.example2;

import design.adapter.应用.example2.wordsfilter.ASensitiveWordsFilter;
import design.adapter.应用.example2.wordsfilter.BSensitiveWordsFilter;
import design.adapter.应用.example2.wordsfilter.CSensitiveWordsFilter;

/**
 * @Author 喻可
 * @Date 2021/7/14 11:22
 */


// 未使用适配器模式之前的代码：代码的可测试性、扩展性不好
public class RiskManagement {

    private ASensitiveWordsFilter aFilter = new ASensitiveWordsFilter();
    private BSensitiveWordsFilter bFilter = new BSensitiveWordsFilter();
    private CSensitiveWordsFilter cFilter = new CSensitiveWordsFilter();

    public String filterSensitiveWords(String text) {
        String maskedText = aFilter.filterSexyWords(text);
        maskedText = aFilter.filterPoliticalWords(maskedText);
        maskedText = bFilter.filter(maskedText);
        maskedText = cFilter.filter(maskedText, "***");
        return maskedText;
    }

}