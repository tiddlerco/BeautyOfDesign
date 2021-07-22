package design.behavior.memento.example;

/**
 * 存在问题：
 * 1.在 InputText 类中定义了 setText() 函数，
 * 但这个函数有可能会被其他业务使用，所以，暴露不应该暴露的函数违背了封装原则；
 * 2.第二，快照本身是不可变的，理论上讲，不应该包含任何 set() 等修改内部状态的函数
 */
public class InputText {
    private StringBuilder text = new StringBuilder();

    public String getText() {
        return text.toString();
    }

    public void append(String input) {
        text.append(input);
    }

    public void setText(String text) {
        this.text.replace(0, this.text.length(), text);
    }
}




