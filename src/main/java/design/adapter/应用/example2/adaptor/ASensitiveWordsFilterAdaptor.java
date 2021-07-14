package design.adapter.应用.example2.adaptor;

import design.adapter.应用.example2.wordsfilter.ASensitiveWordsFilter;
import design.adapter.应用.example2.wordsfilter.ISensitiveWordsFilter;

/**
 * 基于组合
 *
 * @Author 喻可
 * @Date 2021/7/14 11:20
 */
public class ASensitiveWordsFilterAdaptor implements ISensitiveWordsFilter {

    private ASensitiveWordsFilter aFilter;

    public String filter(String text) {
        String maskedText = aFilter.filterSexyWords(text);
        maskedText = aFilter.filterPoliticalWords(maskedText);
        return maskedText;
    }
}