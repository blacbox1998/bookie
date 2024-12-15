package group.luka.bookie.mapper;

import group.luka.bookie.entity.AddressEntity;
import group.luka.bookie.entity.ReservationEntity;
import group.luka.bookie.model.Address;
import group.luka.bookie.model.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReservationMapper {

    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    ReservationEntity modelToEntity(Reservation model);

    Reservation entityToModel(ReservationEntity entity);

    List<Reservation> entityToModel(List<ReservationEntity> entities);


}
