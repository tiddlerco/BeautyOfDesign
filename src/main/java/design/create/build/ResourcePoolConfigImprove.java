package design.create.build;

import lombok.Builder;
import org.apache.commons.lang3.StringUtils;

/**
 * lombok中的@bulid注解改进版
 * 可以使用这种模式完美替换建造者模式
 *
 * @Author 喻可
 * @Date 2021/7/9 14:58
 */
@Builder
public class ResourcePoolConfigImprove {
    private String name;
    private int maxTotal;
    private int maxIdle;
    private int minIdle;

    //ResourcePoolConfigImproveBuilder是ResourcePoolConfigImprove在进行编译后
    //target里ResourcePoolConfigImprove会有ResourcePoolConfigImproveBuilder静态内部类
    //这里对ResourcePoolConfigImproveBuilder里的判断逻辑进行了重写
    public static class ResourcePoolConfigImproveBuilder {
        public ResourcePoolConfigImprove build() {
            // 校验逻辑放到这里来做，包括必填项校验、依赖关系校验、约束条件校验等
            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("...");
            }

            if (minIdle > maxTotal) {
                throw new IllegalArgumentException("minIdle 不能大于 maxTotal");
            }
            if (minIdle > maxIdle) {
                throw new IllegalArgumentException("minIdle 不能大于 maxIdle");
            }
            return new ResourcePoolConfigImprove(this.name, this.maxTotal, this.maxIdle, this.minIdle);
        }
    }

    // 这段代码会抛出IllegalArgumentException，因为minIdle>maxIdle
    public static void main(String[] args) {

        ResourcePoolConfigImprove config2 = ResourcePoolConfigImprove.builder()
                .name("dbconnectionpool")
                .maxTotal(16)
                .maxIdle(10)
                .minIdle(12)
                .build();
        System.out.println(config2);
    }

}
