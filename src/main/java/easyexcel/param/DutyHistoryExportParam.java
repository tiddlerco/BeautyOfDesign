package easyexcel.param;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author zhang_yb
 * @date 2021-10-12 10:50
 **/
@Data
public class DutyHistoryExportParam {
    @ExcelProperty({"履职统计表", "子工程"})
    private String parentNode;
    @ExcelProperty({"履职统计表", "单元工程"})
    private String node;
    @ExcelProperty({"履职统计表", "工地"})
    private String siteName;
    @ExcelProperty({"履职统计表", "工程技术管理人员"})
    private String technologyList;
    @ExcelProperty({"履职统计表", "安全管理人员"})
    private String superviseList;
    @ExcelProperty({"履职统计表", "质量管理人员"})
    private String qualityList;
    @ExcelProperty({"履职统计表", "监理"})
    private String dangerList;
    @DateTimeFormat("yyyy/MM/dd")
    @ExcelProperty({"履职统计表", "日期"})
    private Date dutyDate;

}
