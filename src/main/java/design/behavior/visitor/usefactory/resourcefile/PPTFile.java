package design.behavior.visitor.usefactory.resourcefile;


import design.behavior.visitor.usefactory.ResourceFileType;

public class PPTFile extends ResourceFile {

    public PPTFile(String filePath) {
        super(filePath);
    }

    @Override
    public ResourceFileType getType() {
        return ResourceFileType.PDF;
    }
}
