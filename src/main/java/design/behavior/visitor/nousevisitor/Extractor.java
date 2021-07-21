package design.behavior.visitor.nousevisitor;


import design.behavior.visitor.nousevisitor.resourcefile.PPTFile;
import design.behavior.visitor.nousevisitor.resourcefile.PdfFile;
import design.behavior.visitor.nousevisitor.resourcefile.WordFile;

//转成txt的方法
public class Extractor {

    public void extract2txt(PPTFile pptFile) {
        System.out.println("Extract PPT.");
    }

    public void extract2txt(PdfFile pdfFile) {
        System.out.println("Extract PDF.");
    }

    public void extract2txt(WordFile wordFile) {
        System.out.println("Extract WORD.");
    }
}
