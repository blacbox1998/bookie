package group.luka.bookie;

import group.luka.bookie.mapper.ReservationStatusMapper;
import group.luka.bookie.model.ReservationStatus;
import group.luka.bookie.repo.ReservationStatusRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationStatusServiceImpl implements ReservationStatusService {

    private static final ReservationStatusMapper reservationStatusMapper = ReservationStatusMapper.INSTANCE;
    private final ReservationStatusRepository reservationStatusRepository;

    public ReservationStatusServiceImpl(ReservationStatusRepository reservationStatusRepository) {
        this.reservationStatusRepository = reservationStatusRepository;
    }

    @Override
    public ReservationStatus findByCode(String code) {
        return reservationStatusMapper.entityToModel(reservationStatusRepository.findById(code).get());
    }

    @Override
    public String getRawpServiceName() {
        return "ReservationStatusService";
    }
}
