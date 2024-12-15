package group.luka.bookie;

import blacbox.project.rawp.RawpServiceComponent;
import group.luka.bookie.model.ReservationType;
import group.luka.bookie.model.ResourceOptionWrapper;

import java.util.List;

public interface ResourceService extends RawpServiceComponent {

    List<ResourceOptionWrapper> findOptionsByWorkingUnitAndType(Integer workingUnit, ReservationType type);

}
