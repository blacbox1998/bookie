package group.luka.bookie;

import group.luka.bookie.entity.ReservationTypeEntity;
import group.luka.bookie.mapper.ReservationTypeMapper;
import group.luka.bookie.model.ReservationType;
import group.luka.bookie.repo.ReservationTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationTypeServiceImpl implements ReservationTypeService {

    private static final ReservationTypeMapper mapper = ReservationTypeMapper.INSTANCE;
    private final ReservationTypeRepository reservationTypeRepository;

    public ReservationTypeServiceImpl(ReservationTypeRepository reservationTypeRepository) {
        this.reservationTypeRepository = reservationTypeRepository;
    }

    @Override
    public List<ReservationType> findAll() {
        List<ReservationTypeEntity> all = reservationTypeRepository.findAll();
        return mapper.entityToModel(all);
    }

    @Override
    public String getRawpServiceName() {
        return "ReservationTypeService";
    }
}
