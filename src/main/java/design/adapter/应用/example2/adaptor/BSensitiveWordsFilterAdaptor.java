package design.adapter.应用.example2.adaptor;

import design.adapter.应用.example2.wordsfilter.BSensitiveWordsFilter;
import design.adapter.应用.example2.wordsfilter.ISensitiveWordsFilter;

/**
 * 基于组合
 *
 * @Author 喻可
 * @Date 2021/7/14 11:20
 */
public class BSensitiveWordsFilterAdaptor implements ISensitiveWordsFilter {

    private BSensitiveWordsFilter bFilter;

    public String filter(String text) {
        String maskedText = bFilter.filter(text);
        return maskedText;
    }
}
