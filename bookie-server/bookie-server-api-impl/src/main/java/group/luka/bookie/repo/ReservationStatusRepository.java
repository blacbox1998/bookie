package group.luka.bookie.repo;

import group.luka.bookie.entity.ReservationStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationStatusRepository extends JpaRepository<ReservationStatusEntity, String> {
}
