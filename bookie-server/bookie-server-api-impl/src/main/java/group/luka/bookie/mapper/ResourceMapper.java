package group.luka.bookie.mapper;

import group.luka.bookie.entity.ResourceEntity;
import group.luka.bookie.model.Resource;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ResourceMapper {

    ResourceMapper INSTANCE = Mappers.getMapper(ResourceMapper.class);

    ResourceEntity modelToEntity(Resource model);

    Resource entityToModel(ResourceEntity entity);

    List<Resource> entityToModel(List<ResourceEntity> entities);


}
