package design.structure.composite.example1.improve;


/**
 * 对文件和目录进行区分设计
 *
 * @Author 喻可
 * @Date 2021/7/15 18:14
 */

public abstract class FileSystemNode {

    protected String path;

    public FileSystemNode(String path) {
        this.path = path;
    }

    public abstract int countNumOfFiles();

    public abstract long countSizeOfFiles();

    public String getPath() {
        return path;
    }
}




