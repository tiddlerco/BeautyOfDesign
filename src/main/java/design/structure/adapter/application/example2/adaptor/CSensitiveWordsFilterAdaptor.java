package design.structure.adapter.application.example2.adaptor;

import design.structure.adapter.application.example2.wordsfilter.CSensitiveWordsFilter;
import design.structure.adapter.application.example2.wordsfilter.ISensitiveWordsFilter;

/**
 * 基于组合
 *
 * @Author 喻可
 * @Date 2021/7/14 11:20
 */
public class CSensitiveWordsFilterAdaptor implements ISensitiveWordsFilter {

    private CSensitiveWordsFilter cFilter;

    @Override
    public String filter(String text) {
        String maskedText = cFilter.filter(text, "***");
        return maskedText;
    }
}