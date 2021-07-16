package design.structure.xiangyuan.texteditexample.improve;

import java.awt.*;

/**
 * 在一个文本文件中，用到的字体格式不会太多
 * 可以将它设计成享元，让不同的文字共享使用
 *
 * @Author 喻可
 * @Date 2021/7/16 10:03
 */

public class CharacterStyle {

    private Font font;
    private int size;
    private int colorRGB;

    public CharacterStyle(Font font, int size, int colorRGB) {
        this.font = font;
        this.size = size;
        this.colorRGB = colorRGB;
    }

    @Override
    public boolean equals(Object o) {
        CharacterStyle otherStyle = (CharacterStyle) o;
        return font.equals(otherStyle.font)
                && size == otherStyle.size
                && colorRGB == otherStyle.colorRGB;
    }
}






