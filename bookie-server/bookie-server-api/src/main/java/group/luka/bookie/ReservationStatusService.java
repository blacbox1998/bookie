package group.luka.bookie;

import blacbox.project.rawp.RawpServiceComponent;
import group.luka.bookie.model.ReservationStatus;

public interface ReservationStatusService extends RawpServiceComponent {

    ReservationStatus findByCode(String code);

}
