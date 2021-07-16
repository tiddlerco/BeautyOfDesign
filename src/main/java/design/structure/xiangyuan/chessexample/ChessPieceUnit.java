package design.structure.xiangyuan.chessexample;


/**
 * 相似对象的 id、text、color 都是相同的，唯独 positionX、positionY 不同
 * 可以将棋子的 id、text、color 属性拆分出来，设计成独立的类
 * 作为享元供多个棋盘复用
 */

// 享元类
public class ChessPieceUnit {
    private int id;
    private String text;
    private Color color;

    public ChessPieceUnit(int id, String text, Color color) {
        this.id = id;
        this.text = text;
        this.color = color;
    }

    public static enum Color {
        RED, BLACK
    }

    // ...省略其他属性和getter方法...
}






