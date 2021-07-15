package design.structure.composite.example2;


/**
 * 在内存中构建整个公司的人员架构图（部门、子部门、员工的隶属关系），
 * 并且提供接口计算出部门的薪资成本（隶属于这个部门的所有员工的薪资和
 *
 * @Author 喻可
 * @Date 2021/7/15 18:45
 */

public abstract class HumanResource {

    protected long id;
    protected double salary;

    public HumanResource(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public abstract double calculateSalary();
}






