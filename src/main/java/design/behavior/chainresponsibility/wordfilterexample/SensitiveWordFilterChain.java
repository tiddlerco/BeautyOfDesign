package design.behavior.chainresponsibility.wordfilterexample;

import design.behavior.chainresponsibility.wordfilterexample.entity.Content;
import design.behavior.chainresponsibility.wordfilterexample.filter.SensitiveWordFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 喻可
 * @Date 2021/7/19 17:29
 */

public class SensitiveWordFilterChain {

    private List<SensitiveWordFilter> filters = new ArrayList<>();

    public void addFilter(SensitiveWordFilter filter) {
        this.filters.add(filter);
    }

    // return true if content doesn't contain sensitive words.
    public boolean filter(Content content) {
        for (SensitiveWordFilter filter : filters) {
            if (!filter.doFilter(content)) {
                return false;
            }
        }
        return true;
    }
}
