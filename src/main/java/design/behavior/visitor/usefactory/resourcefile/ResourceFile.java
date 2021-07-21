package design.behavior.visitor.usefactory.resourcefile;


import design.behavior.visitor.usefactory.ResourceFileType;

/**
 * @Author 喻可
 * @Date 2021/7/21 10:28
 */

public abstract class ResourceFile {
    protected String filePath;
    public ResourceFile(String filePath) {
        this.filePath = filePath;
    }
    public abstract ResourceFileType getType();
}



