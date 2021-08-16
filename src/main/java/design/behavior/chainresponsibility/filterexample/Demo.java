package design.behavior.chainresponsibility.filterexample;

import design.behavior.chainresponsibility.filterexample.chain.MiddlewareChain;
import design.behavior.chainresponsibility.filterexample.chain.RoleCheckMiddle;
import design.behavior.chainresponsibility.filterexample.chain.ThrottlingMiddle;
import design.behavior.chainresponsibility.filterexample.chain.UserExistsMiddle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 客户端代码
 */
public class Demo {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    private static void init() {
        server = new Server();
        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");

        // All checks are linked. Client can build various chains using the same
        // components.
        MiddlewareChain middlewareChain = new ThrottlingMiddle(2);
        middlewareChain.linkWith(new UserExistsMiddle(server))
                .linkWith(new RoleCheckMiddle());

        // Server gets a chain from client code.
        server.setMiddlewareChain(middlewareChain);
    }

    public static void main(String[] args) throws IOException {
        init();

        boolean success;
        do {
            System.out.print("Enter email: ");
            String email = reader.readLine();
            System.out.print("Input password: ");
            String password = reader.readLine();
            success = server.logIn(email, password);
        } while (!success);
    }
}
