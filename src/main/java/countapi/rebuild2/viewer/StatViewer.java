package countapi.rebuild2.viewer;

import java.util.Map;

/**
 * @Author 喻可
 * @Date 2021/7/5 14:48
 */
//负责显示
public interface StatViewer {
    void output(Map requestStats, long startTimeInMillis, long endTimeInMills);
}
