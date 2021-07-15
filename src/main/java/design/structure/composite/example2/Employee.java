package design.structure.composite.example2;


/**
 * @Author 喻可
 * @Date 2021/7/15 18:45
 */
public class Employee extends HumanResource {

    //员工构造器才有id和薪水字段
    public Employee(long id, double salary) {
        super(id);
        this.salary = salary;
    }

    @Override
    public double calculateSalary() {
        return salary;
    }
}
