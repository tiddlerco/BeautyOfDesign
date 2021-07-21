package design.behavior.visitor.nousevisitor.resourcefile;

import design.behavior.visitor.nousevisitor.Compressor;
import design.behavior.visitor.nousevisitor.Extractor;

public class PdfFile extends ResourceFile {
    public PdfFile(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Extractor extractor) {
        //注意这里的this使用，真是一绝
        extractor.extract2txt(this);
    }

    //新增的压缩方法
    @Override
    public void accept(Compressor compressor) {
        compressor.compress(this);
    }

}
