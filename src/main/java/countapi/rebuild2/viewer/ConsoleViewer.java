package countapi.rebuild2.viewer;

import com.google.gson.Gson;

import java.util.Map;

/**
 * @Author 喻可
 * @Date 2021/7/5 14:49
 */
//负责显示
public class ConsoleViewer implements StatViewer {

    @Override
    public void output(Map requestStats, long startTimeInMillis, long endTimeInMills) {
        System.out.println("Time Span: [" + startTimeInMillis + ", " + endTimeInMills + "]");
        Gson gson = new Gson();
        System.out.println(gson.toJson(requestStats));
    }
}
