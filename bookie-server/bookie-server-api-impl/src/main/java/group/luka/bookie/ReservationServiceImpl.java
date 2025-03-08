package group.luka.bookie;

import group.luka.bookie.entity.ReservationEntity;
import group.luka.bookie.mapper.ReservationMapper;
import group.luka.bookie.mapper.ReservationStatusMapper;
import group.luka.bookie.model.Reservation;
import group.luka.bookie.repo.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository repository;
    private final ReservationStatusService reservationStatusService;
    ReservationMapper reservationMapper = ReservationMapper.INSTANCE;
    ReservationStatusMapper reservationStatusMapper = ReservationStatusMapper.INSTANCE;

    public ReservationServiceImpl(ReservationRepository repository, ReservationStatusService reservationStatusService) {
        this.repository = repository;
        this.reservationStatusService = reservationStatusService;
    }

    @Override
    public Reservation insert(Reservation reservation) {
        ReservationEntity entity = reservationMapper.modelToEntity(reservation);

        entity.setStatus(reservationStatusMapper.modelToEntity(reservationStatusService.findByCode("o")));
        entity.setStatusModifiedBy("admin");
        entity.setStatusModifiedAt(new Date());
        repository.save(entity);
        return reservationMapper.entityToModel(entity);
    }

}
