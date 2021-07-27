package principle.isp.inter_face;

import java.util.Map;

/**
 * @Author 喻可
 * @Date 2021/7/27 10:12
 */
public interface Viewer {
    String outputInPlainText();

    Map<String, String> output();
}
