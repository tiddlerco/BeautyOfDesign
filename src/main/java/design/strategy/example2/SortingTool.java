package design.strategy.example2;

/**
 * @Author 喻可
 * @Date 2021/7/13 15:28
 */
public class SortingTool {
    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        sorter.sortFile(args[0]);
    }
}