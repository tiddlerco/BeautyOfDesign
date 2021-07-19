package design.behavior.chainresponsibility.wordfilterexample.filter;

import design.behavior.chainresponsibility.wordfilterexample.entity.Content;

/**
 * @Author 喻可
 * @Date 2021/7/19 17:30
 */
public class SexyWordFilter implements SensitiveWordFilter {
    @Override
    public boolean doFilter(Content content) {
        boolean legal = true;
        //...
        return legal;
    }
}
