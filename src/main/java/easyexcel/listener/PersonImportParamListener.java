package easyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import easyexcel.param.PersonImportParam;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class PersonImportParamListener extends AnalysisEventListener<PersonImportParam> {

    private List<PersonImportParam> list = new ArrayList<>();

    public List<PersonImportParam> getDatas() {
        return list;
    }
    @Override
    public void invoke(PersonImportParam personImportParam, AnalysisContext analysisContext) {
        list.add(personImportParam);

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

//    private void saveDate() {
//        //业务调用，保存数据
//        List<PersonMsg> personMsgList = list.stream().map(personImportParam -> {
//            PersonMsg personMsg = new PersonMsg();
//            BeanUtils.copyProperties(personImportParam, personMsg);
//            if (PersonSignEnums.GUANLI.getDesc().equals(personImportParam.getPersonType())) {
//                personMsg.setPersonType(PersonSignEnums.GUANLI.getValue());
//            }
//            if (PersonSignEnums.LAOWU.getDesc().equals(personImportParam.getPersonType())) {
//                personMsg.setPersonType(PersonSignEnums.LAOWU.getValue());
//            }
//            return personMsg;
//        }).collect(Collectors.toList());
//        EntityTool.insertEntity(personMsgList);
//    }
}