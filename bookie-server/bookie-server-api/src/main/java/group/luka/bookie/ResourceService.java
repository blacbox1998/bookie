package group.luka.bookie;

import blacbox.project.rawp.RawpServiceComponent;
import group.luka.bookie.model.Resource;

import java.util.List;

public interface ResourceService extends RawpServiceComponent {

    List<Resource> findByWorkingUnit(Integer workingUnit);

}
