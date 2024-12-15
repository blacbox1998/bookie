package group.luka.bookie.repo;

import group.luka.bookie.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ReservationRepository extends JpaRepository<ReservationEntity, Integer> {
}
