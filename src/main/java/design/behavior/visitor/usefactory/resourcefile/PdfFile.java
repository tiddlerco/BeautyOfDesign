package design.behavior.visitor.usefactory.resourcefile;

import design.behavior.visitor.usefactory.ResourceFileType;

public class PdfFile extends ResourceFile {

    public PdfFile(String filePath) {
        super(filePath);
    }

    @Override
    public ResourceFileType getType() {
        return ResourceFileType.PDF;
    }

}
