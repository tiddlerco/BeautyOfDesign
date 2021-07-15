package design.structure.composite.example2.dao;

import java.util.List;

/**
 * @Author 喻可
 * @Date 2021/7/15 18:48
 */
public class EmployeeRepo {

    /**
     * 查询部分下的所有员工id
     *
     * @param id
     * @return
     */
    public List<Long> getDepartmentEmployeeIds(long id) {
        return null;
    }

    /**
     * 根据员工id查询员工薪水
     *
     * @param employeeId
     * @return
     */
    public double getEmployeeSalary(Long employeeId) {
        return 0;
    }
}
