package design.behavior.observer.example.observer;

import design.behavior.observer.example.service.PromotionService;

/**
 * 观察者
 *
 * @Author 喻可
 * @Date 2021/7/16 14:41
 */
public class RegPromotionObserver implements RegObserver {

    private PromotionService promotionService; // 依赖注入

    @Override
    public void handleRegSuccess(long userId) {
        promotionService.issueNewUserExperienceCash(userId);
    }
}
