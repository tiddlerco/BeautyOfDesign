package design.structure.adapter.application.example2.wordsfilter;

/**
 * @Author 喻可
 * @Date 2021/7/14 11:25
 */


// 使用适配器模式进行改造
public interface ISensitiveWordsFilter { // 统一接口定义

    String filter(String text);

}
