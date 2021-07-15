package design.structure.composite.example2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 喻可
 * @Date 2021/7/15 18:45
 */
public class Department extends HumanResource {

    private List<HumanResource> subNodes = new ArrayList<>();

    //员工构造里面只有id字段
    public Department(long id) {
        super(id);
    }


    @Override
    public double calculateSalary() {
        double totalSalary = 0;
        for (HumanResource hr : subNodes) {
            totalSalary += hr.calculateSalary();
        }
        this.salary = totalSalary;
        return totalSalary;
    }

    public void addSubNode(HumanResource hr) {
        subNodes.add(hr);
    }
}
