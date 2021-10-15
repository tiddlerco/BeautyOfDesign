package easyexcel.listener;


import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlanListenter extends AnalysisEventListener<Map<Integer, String>> {

    private List<Map<Integer, String>> datas = new ArrayList<>();

    public List<Map<Integer, String>> getDatas() {
        return datas;
    }

    public List<List<String>> getList() {
        List<List<String>> result = Lists.newArrayList();
        datas.forEach(data->{
            List<String> list = Lists.newArrayList();
            if(data != null && !data.isEmpty()){
                for(int i = 0; i<data.size(); i++){
                    list.add(data.get(i));
                }
            }
            result.add(list);
        });
        return result;
    }


    public List<List<String>> getListWithSpace() {
        List<List<String>> result = Lists.newArrayList();
        datas.forEach(data->{
            List<String> list = Lists.newArrayList();
                for(int i = 0; i<data.size(); i++){
                    list.add(data.get(i));
                }
            result.add(list);
        });
        return result;
    }


    @Override
    public void invoke(Map<Integer, String> data, AnalysisContext analysisContext) {
        datas.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}