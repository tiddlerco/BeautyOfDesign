package design.behavior.visitor.usefactory.extractor;


import design.behavior.visitor.usefactory.resourcefile.ResourceFile;

//负责抽取文本内容
public interface Extractor {
    void extract2txt(ResourceFile resourceFile);
}

