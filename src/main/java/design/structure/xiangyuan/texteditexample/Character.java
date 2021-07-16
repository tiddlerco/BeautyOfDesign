package design.structure.xiangyuan.texteditexample;

import java.awt.*;

/**
 * 每个文字都当作一个独立的对象来看待，并且在其中包含它的格式信息
 * 问题：如果一个文本文件中，有上万、十几万、几十万的文字，那我们就要在内存中存储这么多 Character 对象
 *
 * @Author 喻可
 * @Date 2021/7/16 9:52
 */

public class Character {//文字
    private char c;

    private Font font;
    private int size;
    private int colorRGB;

    public Character(char c, Font font, int size, int colorRGB) {
        this.c = c;
        this.font = font;
        this.size = size;
        this.colorRGB = colorRGB;
    }
}


