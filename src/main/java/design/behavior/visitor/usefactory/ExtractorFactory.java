package design.behavior.visitor.usefactory;

import design.behavior.visitor.usefactory.extractor.Extractor;
import design.behavior.visitor.usefactory.extractor.PPTExtractor;
import design.behavior.visitor.usefactory.extractor.PdfExtractor;
import design.behavior.visitor.usefactory.extractor.WordExtractor;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 喻可
 * @Date 2021/7/21 10:31
 */
public class ExtractorFactory {

    private static final Map<ResourceFileType, Extractor> extractors = new HashMap<>();

    static {
        extractors.put(ResourceFileType.PDF, new PdfExtractor());
        extractors.put(ResourceFileType.PPT, new PPTExtractor());
        extractors.put(ResourceFileType.WORD, new WordExtractor());
    }

    public static Extractor getExtractor(ResourceFileType type) {
        return extractors.get(type);
    }
}
