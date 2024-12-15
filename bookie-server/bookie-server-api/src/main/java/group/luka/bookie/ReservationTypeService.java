package group.luka.bookie;

import blacbox.project.rawp.RawpServiceComponent;
import group.luka.bookie.model.ReservationType;

import java.util.List;

public interface ReservationTypeService extends RawpServiceComponent {

    List<ReservationType> findAll();

}
