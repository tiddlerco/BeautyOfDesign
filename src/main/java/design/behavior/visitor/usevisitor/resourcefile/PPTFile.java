package design.behavior.visitor.usevisitor.resourcefile;

import design.behavior.visitor.usevisitor.Visitor;

public class PPTFile extends ResourceFile {

    public PPTFile(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
