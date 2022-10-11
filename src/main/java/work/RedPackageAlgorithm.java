package work;

import lombok.Data;

import java.util.Random;

/**
 * @Author yuke
 * @Date 2022/10/11 9:50
 * @Description: 抢红包算法
 */
public class RedPackageAlgorithm {

    public static double getRandomMoney(RedPackage redPackage) {
        // remainSize 剩余的红包数量
        // remainMoney 剩余的钱
        if (redPackage.remainSize == 1) {
            redPackage.remainSize--;
            return (double) Math.round(redPackage.remainMoney * 100) / 100;
        }
        Random random = new Random();
        double min = 0.01;
        double max = redPackage.remainMoney / redPackage.remainSize * 2;
        double money = random.nextDouble() * max;
        money = money <= min ? 0.01 : money;
        money = Math.floor(money * 100) / 100;
        redPackage.remainSize--;
        redPackage.remainMoney -= money;
        return money;
    }


    public static void main(String[] args) {

        RedPackage redPackage = new RedPackage(5,1000);

        for (int i = 0; i < 5; i++) {

            double randomMoney = getRandomMoney(redPackage);

            System.out.println(randomMoney);

        }


    }

    @Data
    public static class RedPackage {
        private int remainSize;
        private double remainMoney;

        public RedPackage(int remainSize, double remainMoney) {
            this.remainSize = remainSize;
            this.remainMoney = remainMoney;
        }
    }


}
