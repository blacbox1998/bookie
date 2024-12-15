package group.luka.bookie.mapper;

import group.luka.bookie.entity.AddressEntity;
import group.luka.bookie.entity.ResourceEntity;
import group.luka.bookie.model.Address;
import group.luka.bookie.model.Resource;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressEntity modelToEntity(Address model);

    Address entityToModel(AddressEntity entity);

    List<Address> entityToModel(List<AddressEntity> entities);


}
