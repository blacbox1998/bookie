package group.luka.bookie.mapper;

import group.luka.bookie.entity.AddressEntity;
import group.luka.bookie.entity.ReservationAllocationEntity;
import group.luka.bookie.model.Address;
import group.luka.bookie.model.ReservationAllocation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReservationAllocationMapper {

    ReservationAllocationMapper INSTANCE = Mappers.getMapper(ReservationAllocationMapper.class);

    ReservationAllocationEntity modelToEntity(ReservationAllocation model);

    ReservationAllocation entityToModel(ReservationAllocationEntity entity);

    List<ReservationAllocation> entityToModel(List<ReservationAllocationEntity> entities);


}
