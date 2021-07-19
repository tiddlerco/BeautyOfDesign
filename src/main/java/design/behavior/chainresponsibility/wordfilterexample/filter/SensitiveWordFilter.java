package design.behavior.chainresponsibility.wordfilterexample.filter;

import design.behavior.chainresponsibility.wordfilterexample.entity.Content;

/**
 * @Author 喻可
 * @Date 2021/7/19 17:28
 */

public interface SensitiveWordFilter {

    boolean doFilter(Content content);

}






