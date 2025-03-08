package group.luka.bookie;

import blacbox.project.rawp.RawpServiceComponent;
import group.luka.bookie.model.ReservationType;
import group.luka.bookie.model.Resource;
import group.luka.bookie.model.ResourceReservationType;

import java.math.BigDecimal;
import java.util.List;

public interface ResourceService extends RawpServiceComponent {

    List<ResourceReservationType> findOptionsByWorkingUnitAndType(Integer workingUnit, ReservationType type);

    Resource save(Resource resource);

    ResourceReservationType saveResourceReservationType(Resource resource, String reservationType, BigDecimal price);

    @Override
    default String getRawpServiceName() {
        return "ResourceService";
    }
}
