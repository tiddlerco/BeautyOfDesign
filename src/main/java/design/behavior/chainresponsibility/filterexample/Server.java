package design.behavior.chainresponsibility.filterexample;

import design.behavior.chainresponsibility.filterexample.chain.MiddlewareChain;

import java.util.HashMap;
import java.util.Map;

/**
 * 授权目标
 */
public class Server {

    private Map<String, String> users = new HashMap<>();

    private MiddlewareChain middlewareChain;

    /**
     * Client passes a chain of object to server. This improves flexibility and
     * makes testing the server class easier.
     */
    public void setMiddlewareChain(MiddlewareChain middlewareChain) {
        this.middlewareChain = middlewareChain;
    }

    /**
     * Server gets email and password from client and sends the authorization
     * request to the chain.
     */
    public boolean logIn(String email, String password) {
        if (middlewareChain.check(email, password)) {
            System.out.println("Authorization have been successful!");

            // Do something useful here for authorized users.

            return true;
        }
        return false;
    }

    public void register(String email, String password) {
        users.put(email, password);
    }

    public boolean hasEmail(String email) {
        return users.containsKey(email);
    }

    public boolean isValidPassword(String email, String password) {
        return users.get(email).equals(password);
    }
}
