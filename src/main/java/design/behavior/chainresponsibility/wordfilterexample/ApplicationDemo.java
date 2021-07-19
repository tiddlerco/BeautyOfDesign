package design.behavior.chainresponsibility.wordfilterexample;

import design.behavior.chainresponsibility.wordfilterexample.entity.Content;
import design.behavior.chainresponsibility.wordfilterexample.filter.AdsWordFilter;
import design.behavior.chainresponsibility.wordfilterexample.filter.PoliticalWordFilter;
import design.behavior.chainresponsibility.wordfilterexample.filter.SexyWordFilter;

/**
 * @Author 喻可
 * @Date 2021/7/19 17:29
 */
public class ApplicationDemo {
    public static void main(String[] args) {
        SensitiveWordFilterChain filterChain = new SensitiveWordFilterChain();
        filterChain.addFilter(new AdsWordFilter());
        filterChain.addFilter(new SexyWordFilter());
        filterChain.addFilter(new PoliticalWordFilter());

        boolean legal = filterChain.filter(new Content());
        if (!legal) {
            // 不发表
        } else {
            // 发表
        }
    }
}
