package group.luka.bookie.repo;

import group.luka.bookie.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Integer> {

    List<ReservationEntity> findByResourceAndDateTimeBetween(Integer resource, Date intervalStart, Date intervalEnd);

}
