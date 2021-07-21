package design.behavior.visitor.nousevisitor.resourcefile;


import design.behavior.visitor.nousevisitor.Compressor;
import design.behavior.visitor.nousevisitor.Extractor;

/**
 * 存在一些问题，添加一个新的业务，
 * 还是需要修改每个资源文件类，违反了开闭原则
 */
public abstract class ResourceFile {

    protected String filePath;

    public ResourceFile(String filePath) {
        this.filePath = filePath;
    }

    abstract public void accept(Extractor extractor);

    //新添加的拓展方法
    abstract public void accept(Compressor compressor);

}
