package design.structure.proxy.aliaspect.repository;


public interface ModuleRepository extends BaseRepository<Module, String> {

    /**
     * 入参为该方法的父类对象
     * @param module
     * @throws Exception
     */
    @Override
    void add(Module module) throws Exception;

}
