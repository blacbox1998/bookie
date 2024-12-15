package group.luka.bookie.repo;

import group.luka.bookie.entity.ReservationTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

public interface ReservationTypeRepository extends JpaRepository<ReservationTypeEntity, String> {
}
