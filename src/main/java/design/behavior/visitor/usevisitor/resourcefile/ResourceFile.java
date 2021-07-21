package design.behavior.visitor.usevisitor.resourcefile;


import design.behavior.visitor.usevisitor.Visitor;

public abstract class ResourceFile {

    protected String filePath;

    public ResourceFile(String filePath) {
        this.filePath = filePath;
    }

    abstract public void accept(Visitor vistor);
}









