package design.behavior.visitor.usevisitor;


import design.behavior.visitor.usevisitor.resourcefile.PPTFile;
import design.behavior.visitor.usevisitor.resourcefile.PdfFile;
import design.behavior.visitor.usevisitor.resourcefile.WordFile;

//负责抽取文本内容
public class Extractor implements Visitor {

    @Override
    public void visit(PPTFile pptFile) {
        //...
        System.out.println("Extract PPT.");
    }

    @Override
    public void visit(PdfFile pdfFile) {
        //...
        System.out.println("Extract PDF.");
    }

    @Override
    public void visit(WordFile wordFile) {
        //...
        System.out.println("Extract WORD.");
    }
}
