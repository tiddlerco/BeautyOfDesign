package design.structure.xiangyuan.chessexample;

import java.util.HashMap;
import java.util.Map;

/**
 * 利用工厂类来缓存 ChessPieceUnit 信息（也就是 id、text、color）。
 * 通过工厂类获取到的 ChessPieceUnit 就是享元。
 * 所有的 ChessBoard 对象共享这 30 个 ChessPieceUnit 对象（因为象棋中只有 30 个棋子）
 */
public class ChessPieceUnitFactory {

    private static final Map<Integer, ChessPieceUnit> pieces = new HashMap<>();

    static {
        pieces.put(1, new ChessPieceUnit(1, "車", ChessPieceUnit.Color.BLACK));
        pieces.put(2, new ChessPieceUnit(2, "馬", ChessPieceUnit.Color.BLACK));
        //...省略摆放其他棋子的代码...
    }

    public static ChessPieceUnit getChessPiece(int chessPieceId) {
        return pieces.get(chessPieceId);
    }
}
