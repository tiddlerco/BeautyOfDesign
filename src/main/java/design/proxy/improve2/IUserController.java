package design.proxy.improve2;

import countapi.rebuild1.entity.UserVo;

/**
 * @Author 喻可
 * @Date 2021/7/12 10:39
 */
public interface IUserController {
    UserVo login(String telephone, String password);

    UserVo register(String telephone, String password);
}
