package group.luka.bookie.mapper;

import group.luka.bookie.entity.ResourceEntity;
import group.luka.bookie.entity.ResourceReservationTypeEntity;
import group.luka.bookie.model.Resource;
import group.luka.bookie.model.ResourceReservationType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ResourceReservationTypeMapper {

    ResourceReservationTypeMapper INSTANCE = Mappers.getMapper(ResourceReservationTypeMapper.class);

    ResourceReservationTypeEntity modelToEntity(ResourceReservationType model);

    ResourceReservationType entityToModel(ResourceReservationTypeEntity entity);

    List<ResourceReservationType> entityToModel(List<ResourceReservationTypeEntity> entities);


}
