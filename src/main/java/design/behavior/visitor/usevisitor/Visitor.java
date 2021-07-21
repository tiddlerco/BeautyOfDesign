package design.behavior.visitor.usevisitor;

import design.behavior.visitor.usevisitor.resourcefile.PPTFile;
import design.behavior.visitor.usevisitor.resourcefile.PdfFile;
import design.behavior.visitor.usevisitor.resourcefile.WordFile;


/**
 * 上面代码还存在一些问题，添加一个新的业务，
 * 还是需要修改每个资源文件类，违反了开闭原则。
 * 针对这个问题，我们抽象出来一个 Visitor 接口，
 * 包含是三个命名非常通用的 visit() 重载函数，
 * 分别处理三种不同类型的资源文件。
 *
 * 抽象出来一个 Visitor 接口，
 * 包含是三个命名非常通用的 visit() 重载函数，
 * 分别处理三种不同类型的资源文件
 */
public interface Visitor {
    void visit(PdfFile pdfFile);
    void visit(PPTFile pdfFile);
    void visit(WordFile pdfFile);
}