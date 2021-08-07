package design.structure.proxy.aliaspect;

import design.structure.proxy.aliaspect.repository.Module;
import design.structure.proxy.aliaspect.repository.ModuleRepository;
import org.springframework.stereotype.Service;

@Service("moduleRepository")
public class ModuleRepositoryimpl implements ModuleRepository {

    @Override
    public void add(Module module) throws Exception {

    }


    @Override
    public void update(Module module) throws Exception {

    }

    @Override
    public void remove(Module module) {

    }
}
