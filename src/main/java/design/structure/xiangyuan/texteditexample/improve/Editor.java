package design.structure.xiangyuan.texteditexample.improve;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 喻可
 * @Date 2021/7/16 10:04
 */
public class Editor {

    private List<Character> chars = new ArrayList<>();

    public void appendCharacter(char c, Font font, int size, int colorRGB) {
        Character character = new Character(c, CharacterStyleFactory.getStyle(font, size, colorRGB));
        chars.add(character);
    }
}
