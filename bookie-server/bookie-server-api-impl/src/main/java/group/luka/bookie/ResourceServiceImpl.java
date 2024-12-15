package group.luka.bookie;

import group.luka.bookie.mapper.ResourceMapper;
import group.luka.bookie.mapper.ResourceReservationTypeMapper;
import group.luka.bookie.model.ReservationType;
import group.luka.bookie.model.ResourceReservationType;
import group.luka.bookie.repo.ResourceRepository;
import group.luka.bookie.repo.ResourceReservationTypeRepository;
import org.springframework.stereotype.Service;

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
    public String getRawpServiceName() {
        return "ResourceService";
    }
}
