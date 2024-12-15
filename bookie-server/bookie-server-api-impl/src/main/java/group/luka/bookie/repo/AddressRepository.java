package group.luka.bookie.repo;

import group.luka.bookie.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
}
