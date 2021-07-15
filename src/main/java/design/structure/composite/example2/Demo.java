package design.structure.composite.example2;

import design.structure.composite.example2.dao.DepartmentRepo;
import design.structure.composite.example2.dao.EmployeeRepo;

import java.util.List;

/**
 * @Author 喻可
 * @Date 2021/7/15 18:47
 */
// 构建组织架构的代码
public class Demo {

    private static final long ORGANIZATION_ROOT_ID = 1001;
    private DepartmentRepo departmentRepo; // 依赖注入
    private EmployeeRepo employeeRepo; // 依赖注入

    public void buildOrganization() {
        Department rootDepartment = new Department(ORGANIZATION_ROOT_ID);
        buildOrganization(rootDepartment);
    }

    private void buildOrganization(Department department) {

        //查询部门下的所有子部门id
        List<Long> subDepartmentIds = departmentRepo.getSubDepartmentIds(department.getId());

        for (Long subDepartmentId : subDepartmentIds) {
            Department subDepartment = new Department(subDepartmentId);
            department.addSubNode(subDepartment);
            buildOrganization(subDepartment);
        }

        //上面的递归完成后才会执行下面的代码
        //递归是一个出入栈的过程，先进后出
        //查询部分下的所有员工id
        List<Long> employeeIds = employeeRepo.getDepartmentEmployeeIds(department.getId());

        for (Long employeeId : employeeIds) {

            double salary = employeeRepo.getEmployeeSalary(employeeId);

            department.addSubNode(new Employee(employeeId, salary));
        }
    }
}
