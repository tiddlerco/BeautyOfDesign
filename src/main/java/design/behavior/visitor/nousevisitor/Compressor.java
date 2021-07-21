package design.behavior.visitor.nousevisitor;

import design.behavior.visitor.nousevisitor.resourcefile.PPTFile;
import design.behavior.visitor.nousevisitor.resourcefile.PdfFile;
import design.behavior.visitor.nousevisitor.resourcefile.WordFile;

//新增的压缩的方法
public class Compressor {

    public void compress(PPTFile pptFile) {
        System.out.println("compress PPT.");
    }

    public void compress(PdfFile pdfFile) {
        System.out.println("compress PDF.");
    }

    public void compress(WordFile wordFile) {
        System.out.println("compress WORD.");
    }

}
