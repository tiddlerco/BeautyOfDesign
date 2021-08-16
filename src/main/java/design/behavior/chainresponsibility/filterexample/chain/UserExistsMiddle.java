package design.behavior.chainresponsibility.filterexample.chain;

import design.behavior.chainresponsibility.filterexample.Server;

/**
 * 检查用户登录信息
 */
public class UserExistsMiddle extends MiddlewareChain {
    private Server server;

    public UserExistsMiddle(Server server) {
        this.server = server;
    }

    public boolean check(String email, String password) {
        if (!server.hasEmail(email)) {
            System.out.println("This email is not registered!");
            return false;
        }
        if (!server.isValidPassword(email, password)) {
            System.out.println("Wrong password!");
            return false;
        }
        return checkNext(email, password);
    }
}
