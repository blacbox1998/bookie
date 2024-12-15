package group.luka.bookie.mapper;

import group.luka.bookie.entity.AddressEntity;
import group.luka.bookie.entity.CustomerEntity;
import group.luka.bookie.model.Address;
import group.luka.bookie.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerEntity modelToEntity(Customer model);

    Customer entityToModel(CustomerEntity entity);

    List<Customer> entityToModel(List<CustomerEntity> entities);


}
