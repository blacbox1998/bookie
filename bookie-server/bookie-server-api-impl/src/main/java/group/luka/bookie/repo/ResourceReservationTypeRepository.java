package group.luka.bookie.repo;

import group.luka.bookie.entity.ResourceReservationTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ResourceReservationTypeRepository extends JpaRepository<ResourceReservationTypeEntity, Integer> {
}
