package design.behavior.chainresponsibility.filterexample.chain;

/**
 * 检查用户角色
 */
public class RoleCheckMiddle extends MiddlewareChain {

    public boolean check(String email, String password) {
        if (email.equals("admin@example.com")) {
            System.out.println("Hello, admin!");
            return true;
        }
        System.out.println("Hello, user!");
        return checkNext(email, password);
    }
}
