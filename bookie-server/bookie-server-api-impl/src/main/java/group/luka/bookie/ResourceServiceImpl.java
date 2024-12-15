package group.luka.bookie;

import group.luka.bookie.mapper.ResourceMapper;
import group.luka.bookie.model.ReservationType;
import group.luka.bookie.model.Resource;
import group.luka.bookie.model.ResourceOptionWrapper;
import group.luka.bookie.repo.ResourceRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    private static final ResourceMapper mapper = ResourceMapper.INSTANCE;
    private final ResourceRepository repository;

    public ResourceServiceImpl(ResourceRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ResourceOptionWrapper> findOptionsByWorkingUnitAndType(Integer workingUnit, ReservationType type) {
        List<ResourceOptionWrapper> resourceOptionWrappers = new ArrayList<>();

        List<Resource> resources = mapper.entityToModel(repository.findAll());
        for (Resource resource : resources) {
            ResourceOptionWrapper wrapper = new ResourceOptionWrapper();
            wrapper.setResource(resource);
            wrapper.setPrice(new BigDecimal("21"));
            resourceOptionWrappers.add(wrapper);
        }

        return resourceOptionWrappers;
    }

    @Override
    public String getRawpServiceName() {
        return "ResourceService";
    }
}
