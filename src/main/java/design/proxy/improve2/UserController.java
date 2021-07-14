package design.proxy.improve2;

import countapi.rebuild1.entity.UserVo;
import design.proxy.improve.IUserController;

/**
 * UserController 类只负责业务功能
 *
 * @Author 喻可
 * @Date 2021/7/12 10:40
 */
public class UserController implements IUserController {


    //...省略其他属性和方法...

    @Override
    public UserVo login(String telephone, String password) {
        //...省略login逻辑...
        //...返回UserVo数据...
        return null;
    }

    @Override
    public UserVo register(String telephone, String password) {
        //...省略register逻辑...
        //...返回UserVo数据...
        return null;
    }
}



