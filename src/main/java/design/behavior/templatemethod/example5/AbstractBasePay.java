package design.behavior.templatemethod.example5;

/**
 * @title: AbstractBasePay
 * @Author yuke
 * @Date: 2022/6/1 21:30
 */
public abstract class AbstractBasePay implements BasePay {

    @Override
    public final void mobilePay() {
        // 钩子函数
        if (isCheckAuth()) {
            checkAuth();
        }
        checkParam();
        chenckRisk();
        channlPay();
    }

    private void checkParam() {
        System.out.println("检查参数");
    }

    private void checkAuth() {
        System.out.println("支付权限校验");
    }

    private void chenckRisk() {
        System.out.println("风控校验");
    }

    //渠道支付
    abstract void channlPay();

    //钩子函数，子类可以覆写，来选择手开启支付权限校验  默认不开启
    boolean isCheckAuth() {
        return true;
    }
}

