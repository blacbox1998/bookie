package group.luka.bookie.repo;

import group.luka.bookie.entity.ReservationAllocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ReservationAllocationRepository extends JpaRepository<ReservationAllocationEntity, Integer> {
}
