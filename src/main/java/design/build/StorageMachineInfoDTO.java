package design.build;

/**
 * lombok中@bulid注解编译后的对象
 *
 * @Author 喻可
 * @Date 2021/7/9 14:42
 */
public class StorageMachineInfoDTO {

    private String secondClassify;
    private String thirdClassify;
    private String factory;
    private String type;
    private String standardModel;
    private String model;
    private int count;

    StorageMachineInfoDTO(String secondClassify, String thirdClassify, String factory, String type, String standardModel, String model, int count) {
        this.secondClassify = secondClassify;
        this.thirdClassify = thirdClassify;
        this.factory = factory;
        this.type = type;
        this.standardModel = standardModel;
        this.model = model;
        this.count = count;
    }

    public static StorageMachineInfoDTO.StorageMachineInfoDTOBuilder builder() {
        return new StorageMachineInfoDTO.StorageMachineInfoDTOBuilder();
    }

    public static class StorageMachineInfoDTOBuilder {
        private String secondClassify;
        private String thirdClassify;
        private String factory;
        private String type;
        private String standardModel;
        private String model;
        private int count;

        StorageMachineInfoDTOBuilder() {
        }

        public StorageMachineInfoDTO.StorageMachineInfoDTOBuilder secondClassify(String secondClassify) {
            this.secondClassify = secondClassify;
            return this;
        }

        public StorageMachineInfoDTO.StorageMachineInfoDTOBuilder thirdClassify(String thirdClassify) {
            this.thirdClassify = thirdClassify;
            return this;
        }

        public StorageMachineInfoDTO.StorageMachineInfoDTOBuilder factory(String factory) {
            this.factory = factory;
            return this;
        }

        public StorageMachineInfoDTO.StorageMachineInfoDTOBuilder type(String type) {
            this.type = type;
            return this;
        }

        public StorageMachineInfoDTO.StorageMachineInfoDTOBuilder standardModel(String standardModel) {
            this.standardModel = standardModel;
            return this;
        }

        public StorageMachineInfoDTO.StorageMachineInfoDTOBuilder model(String model) {
            this.model = model;
            return this;
        }

        public StorageMachineInfoDTO.StorageMachineInfoDTOBuilder count(int count) {
            this.count = count;
            return this;
        }
        //这里因为StorageMachineInfoDTO里面是无参构造，所以传递的是所有的字段
        public StorageMachineInfoDTO build() {
            return new StorageMachineInfoDTO(this.secondClassify, this.thirdClassify, this.factory, this.type, this.standardModel, this.model, this.count);
        }

        public String toString() {
            return "StorageMachineInfoDTO.StorageMachineInfoDTOBuilder(secondClassify=" + this.secondClassify + ", thirdClassify=" + this.thirdClassify + ", factory=" + this.factory + ", type=" + this.type + ", standardModel=" + this.standardModel + ", model=" + this.model + ", count=" + this.count + ")";
        }
    }
}
