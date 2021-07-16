package design.structure.xiangyuan.texteditexample.improve;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 通过工厂类来“缓存”已经创建好的对象。
 * 这里的“缓存”实际上是“存储”的意思
 *
 * @Author 喻可
 * @Date 2021/7/16 10:04
 */
public class CharacterStyleFactory {

    private static final List<CharacterStyle> styles = new ArrayList<>();

    public static CharacterStyle getStyle(Font font, int size, int colorRGB) {
        CharacterStyle newStyle = new CharacterStyle(font, size, colorRGB);
        for (CharacterStyle style : styles) {
            if (style.equals(newStyle)) {
                return style;
            }
        }
        styles.add(newStyle);
        return newStyle;
    }
}
