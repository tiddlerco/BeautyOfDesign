package design.behavior.observer.eventbusexample;

import com.google.common.eventbus.Subscribe;
import design.behavior.observer.example.service.PromotionService;

/**
 * @Author 喻可
 * @Date 2021/7/16 16:35
 */
public class RegPromotionObserver {

    private PromotionService promotionService; // 依赖注入

    @Subscribe
    public void handleRegSuccess(Long userId) {
        promotionService.issueNewUserExperienceCash(userId);
    }
}
