package design.behavior.visitor.usefactory;

import design.behavior.visitor.usefactory.extractor.Extractor;
import design.behavior.visitor.usefactory.resourcefile.PPTFile;
import design.behavior.visitor.usefactory.resourcefile.PdfFile;
import design.behavior.visitor.usefactory.resourcefile.ResourceFile;
import design.behavior.visitor.usefactory.resourcefile.WordFile;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {

        List<ResourceFile> resourceFiles = listAllResourceFiles(args[0]);

        for (ResourceFile resourceFile : resourceFiles) {
            Extractor extractor = ExtractorFactory.getExtractor(resourceFile.getType());
            extractor.extract2txt(resourceFile);
        }
    }

    private static List<ResourceFile> listAllResourceFiles(String resourceDirectory) {

        List<ResourceFile> resourceFiles = new ArrayList<>();
        //...根据后缀(pdf/ppt/word)由工厂方法创建不同的类对象(PdfFile/PPTFile/WordFile)
        resourceFiles.add(new PdfFile("a.pdf"));
        resourceFiles.add(new WordFile("b.word"));
        resourceFiles.add(new PPTFile("c.ppt"));
        return resourceFiles;
    }
}

