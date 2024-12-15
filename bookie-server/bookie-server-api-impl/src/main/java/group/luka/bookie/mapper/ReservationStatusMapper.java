package group.luka.bookie.mapper;

import group.luka.bookie.entity.ReservationEntity;
import group.luka.bookie.entity.ReservationStatusEntity;
import group.luka.bookie.model.Reservation;
import group.luka.bookie.model.ReservationStatus;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReservationStatusMapper {

    ReservationStatusMapper INSTANCE = Mappers.getMapper(ReservationStatusMapper.class);

    ReservationStatusEntity modelToEntity(ReservationStatus model);

    ReservationStatus entityToModel(ReservationStatusEntity entity);

    List<ReservationStatus> entityToModel(List<ReservationStatusEntity> entities);


}
