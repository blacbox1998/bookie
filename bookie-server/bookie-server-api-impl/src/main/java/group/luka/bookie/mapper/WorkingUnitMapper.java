package group.luka.bookie.mapper;

import group.luka.bookie.entity.WorkingUnitEntity;
import group.luka.bookie.model.WorkingUnit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface WorkingUnitMapper {

    WorkingUnitMapper INSTANCE = Mappers.getMapper(WorkingUnitMapper.class);

    WorkingUnitEntity modelToEntity(WorkingUnit model);

    WorkingUnit entityToModel(WorkingUnitEntity entity);

    List<WorkingUnit> entityToModel(List<WorkingUnitEntity> entities);


}
