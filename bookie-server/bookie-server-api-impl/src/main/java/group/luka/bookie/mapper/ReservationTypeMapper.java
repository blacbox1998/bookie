package group.luka.bookie.mapper;

import group.luka.bookie.entity.ReservationTypeEntity;
import group.luka.bookie.model.ReservationType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReservationTypeMapper {

    ReservationTypeMapper INSTANCE = Mappers.getMapper(ReservationTypeMapper.class);

    ReservationTypeEntity modelToEntity(ReservationType model);

    ReservationType entityToModel(ReservationTypeEntity entity);

    List<ReservationType> entityToModel(List<ReservationTypeEntity> entities);


}
