package group.luka.bookie;

import blacbox.project.rawp.RawpServiceComponent;
import group.luka.bookie.model.Reservation;

public interface ReservationService extends RawpServiceComponent {

    Reservation insert(Reservation reservation);

    @Override
    default String getRawpServiceName(){
        return "ReservationService";
    }
}
