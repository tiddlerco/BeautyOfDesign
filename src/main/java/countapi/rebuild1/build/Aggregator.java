package countapi.rebuild1.build;

import countapi.rebuild1.entity.RequestInfo;
import countapi.rebuild1.entity.RequestStat;

import java.util.Comparator;
import java.util.List;

/**
 * @Author 喻可
 * @Date 2021/6/22 10:26
 */
//根据原始数据计算统计数据
//存在的问题:只有一个静态函数,一旦越来越多的统计功能添加进来之后，
//这个函数的代码量会持续增加，可读性、可维护性就变差
public class Aggregator {


    public static RequestStat aggregate(List<RequestInfo> requestInfos, long durationInMillis) {
        double maxRespTime = Double.MAX_VALUE;
        double minRespTime = Double.MIN_VALUE;
        double avgRespTime = -1;
        double p999RespTime = -1;
        double p99RespTime = -1;
        double sumRespTime = 0;
        long count = 0;
        for (RequestInfo requestInfo : requestInfos) {
            ++count;
            double respTime = requestInfo.getResponseTime();
            if (maxRespTime < respTime) {
                maxRespTime = respTime;
            }
            if (minRespTime > respTime) {
                minRespTime = respTime;
            }
            sumRespTime += respTime;
        }
        if (count != 0) {
            avgRespTime = sumRespTime / count;
        }
        long tps = (long) (count / durationInMillis * 1000);
        requestInfos.sort(Comparator.comparingInt(i -> (int) i.getResponseTime()));
        int idx999 = (int) (count * 0.999);
        int idx99 = (int) (count * 0.99);
        if (count != 0) {
            p999RespTime = requestInfos.get(idx999).getResponseTime();
            p99RespTime = requestInfos.get(idx99).getResponseTime();
        }
        RequestStat requestStat = new RequestStat();
        requestStat.setMaxResponseTime(maxRespTime);
        requestStat.setMinResponseTime(minRespTime);
        requestStat.setAvgResponseTime(avgRespTime);
        requestStat.setP999ResponseTime(p999RespTime);
        requestStat.setP99ResponseTime(p99RespTime);
        requestStat.setCount(count);
        requestStat.setTps(tps);
        return requestStat;
    }
}


