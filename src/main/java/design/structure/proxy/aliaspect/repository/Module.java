package design.structure.proxy.aliaspect.repository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Module  {
    /**
     * 模块名称
     */
    private String name;

    /**
     * 模块类型
     */
    private String moduleType;

    /**
     * 生命周期
     * 建设construction->生产production->裁撤abolition
     * */
    private String lifeCycle;

    public enum ModuleTypeEnum {
        EDGE_CLOUD_INF_MODULE("edgeCloudInfModule"),
        ;

        private String moduleType;

        ModuleTypeEnum(String moduleType){
            this.moduleType = moduleType;
        }

        public String getModuleType() {
            return moduleType;
        }
    }

    public enum LifeCycleEnum {
        CONSTRUCTION("construction"),
        PRODUCTION("production"),
        ABOLITION("abolition"),
        ;

        private String lifeCycle;

        LifeCycleEnum(String lifeCycle){
            this.lifeCycle = lifeCycle;
        }

        public String getLifeCycle() {
            return lifeCycle;
        }
    }
}
