package alidesign.callback.example1;

import org.springframework.stereotype.Service;

@Service("Filter")
public class Filter {

    private InterfaceCallback callback;

    //interface在spring中通过set注入
    public void setCallback(InterfaceCallback callback) {
        this.callback = callback;
    }

    public void doFilter() {
        //回调
        if (callback != null) {
            String encoding = callback.getEncoding();
            String ssoLoginUrl = callback.getSsoLoginUrl();
        }
    }
}
