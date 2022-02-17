package alidesign.callback.example1;

import work.SpringContextUtil;


public class LoginFilter {


    public void doFilter() {

        Filter filter = SpringContextUtil.getBean(Filter.class);
        //Filter对象bean中给实现回调接口
        filter.setCallback(new InterfaceCallback() {
            @Override
            public String getEncoding() {
                return "UTF-8";
            }

            @Override
            public String getSsoLoginUrl() {
                return "www.google.com";
            }
        });

    }
}
