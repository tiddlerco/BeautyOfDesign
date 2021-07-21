package design.behavior.visitor.usevisitor;

import design.behavior.visitor.usevisitor.resourcefile.PPTFile;
import design.behavior.visitor.usevisitor.resourcefile.PdfFile;
import design.behavior.visitor.usevisitor.resourcefile.WordFile;

/**
 * 当我们新添加一个业务功能的时候，资源文件类不需要做任何修改，
 * 只需要修改 ToolApplication 的代码就可以了
 */

//新增的负责压缩方法
public class Compressor implements Visitor {

    @Override
    public void visit(PPTFile pptFile) {
        //...
        System.out.println("Compress PPT.");
    }

    @Override
    public void visit(PdfFile pdfFile) {
        //...
        System.out.println("Compress PDF.");
    }

    @Override
    public void visit(WordFile wordFile) {
        //...
        System.out.println("Compress WORD.");
    }

}
