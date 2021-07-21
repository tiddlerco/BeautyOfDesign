package design.behavior.visitor.nousevisitor.resourcefile;

import design.behavior.visitor.nousevisitor.Compressor;
import design.behavior.visitor.nousevisitor.Extractor;

public class WordFile extends ResourceFile {

    public WordFile(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Extractor extractor) {
        extractor.extract2txt(this);
    }

    @Override
    public void accept(Compressor compressor) {
        compressor.compress(this);
    }
}