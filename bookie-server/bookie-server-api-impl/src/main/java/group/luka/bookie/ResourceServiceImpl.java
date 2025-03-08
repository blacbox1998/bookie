package group.luka.bookie;

import group.luka.bookie.entity.ResourceEntity;
import group.luka.bookie.entity.ResourceReservationTypeEntity;
import group.luka.bookie.mapper.ResourceMapper;
import group.luka.bookie.mapper.ResourceReservationTypeMapper;
import group.luka.bookie.model.ReservationType;
import group.luka.bookie.model.Resource;
import group.luka.bookie.model.ResourceReservationType;
import group.luka.bookie.repo.ResourceRepository;
import group.luka.bookie.repo.ResourceReservationTypeRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    private static final ResourceMapper mapper = ResourceMapper.INSTANCE;
    private static final ResourceReservationTypeMapper resourceReservationTypeMapper = ResourceReservationTypeMapper.INSTANCE;
    private final ResourceRepository repository;
    private final ResourceReservationTypeRepository resourceReservationTypeRepository;

    public ResourceServiceImpl(ResourceRepository repository, ResourceReservationTypeRepository resourceReservationTypeRepository) {
        this.repository = repository;
        this.resourceReservationTypeRepository = resourceReservationTypeRepository;
    }

    @Override
    public List<ResourceReservationType> findOptionsByWorkingUnitAndType(Integer workingUnit, ReservationType type) {
        return resourceReservationTypeMapper.entityToModel(resourceReservationTypeRepository.findByReservationTypeAndResourceWorkingUnit(type.getCode(), workingUnit));
    }

    @Override
    public Resource save(Resource resource) {
        ResourceEntity resourceEntity = mapper.modelToEntity(resource);
        repository.save(resourceEntity);
        return mapper.entityToModel(resourceEntity);
    }

    @Override
    public ResourceReservationType saveResourceReservationType(Resource resource, String reservationType, BigDecimal price) {
        ResourceReservationTypeEntity resourceReservationTypeEntity = new ResourceReservationTypeEntity();
        return null;
    }

}
