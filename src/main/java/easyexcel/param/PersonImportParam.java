package easyexcel.param;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author zhang_yb
 * @date 2021-10-11 9:04
 **/
@Data
public class PersonImportParam {
    @ExcelProperty("姓名")
    private String personName;
    @ExcelProperty("性别")
    private String personSex;
    @ExcelProperty("所属公司")
    private String personCompany;
    @ExcelProperty("职务")
    private String personPost;
    @ExcelProperty("工种")
    private String personWorkType;
    @ExcelProperty("年龄")
    private Integer personAge;
    @ExcelProperty("民族")
    private String personRace;
    @ExcelProperty("地址")
    private String personRetreat;
    @ExcelProperty("电话号码")
    private String personPhone;
    @ExcelProperty("身份证号")
    private String personAgentCard;
    @ExcelProperty("人员类别")
    private String personType;
    @ExcelProperty("部门")
    private String personDept;
    @ExcelProperty("班组")
    private String personTeam;
    @ExcelProperty("员工状态")
    private String personStatus;
    @ExcelProperty("照片")
    private String personPhoto;
    @ExcelProperty("籍贯")
    private String personPlace;
    @ExcelProperty("进场时间")
    private Date workStartDate;
    @ExcelProperty("退场时间")
    private Date workEndDate;

}
