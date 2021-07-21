package design.behavior.visitor.usefactory.resourcefile;


import design.behavior.visitor.usefactory.ResourceFileType;

public class WordFile extends ResourceFile {

    public WordFile(String filePath) {
        super(filePath);
    }

    @Override
    public ResourceFileType getType() {
        return ResourceFileType.PDF;
    }
}