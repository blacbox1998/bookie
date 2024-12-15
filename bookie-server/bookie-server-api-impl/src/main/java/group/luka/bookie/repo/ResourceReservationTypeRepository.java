package group.luka.bookie.repo;

import group.luka.bookie.entity.ResourceReservationTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourceReservationTypeRepository extends JpaRepository<ResourceReservationTypeEntity, Integer> {

    List<ResourceReservationTypeEntity> findByReservationTypeAndResourceWorkingUnit(String type, Integer workingUnit);


}
