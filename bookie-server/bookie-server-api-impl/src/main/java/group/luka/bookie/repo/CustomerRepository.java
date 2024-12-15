package group.luka.bookie.repo;

import group.luka.bookie.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
}
