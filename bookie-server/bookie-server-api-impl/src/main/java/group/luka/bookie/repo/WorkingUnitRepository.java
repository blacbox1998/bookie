package group.luka.bookie.repo;

import group.luka.bookie.entity.WorkingUnitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface WorkingUnitRepository extends JpaRepository<WorkingUnitEntity, Integer> {
}
