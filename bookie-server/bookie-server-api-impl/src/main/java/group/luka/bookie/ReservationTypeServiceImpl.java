package group.luka.bookie;

import group.luka.bookie.model.ReservationType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationTypeServiceImpl implements ReservationTypeService {
    @Override
    public List<ReservationType> findAll() {
        List<ReservationType> all = new ArrayList<>();

        ReservationType type1 = new ReservationType();
        type1.setCode("code1");
        type1.setName("Feniranje");
        all.add(type1);

        ReservationType type2 = new ReservationType();
        type2.setCode("code2");
        type2.setName("Sisanje");
        all.add(type2);

        ReservationType type3 = new ReservationType();
        type3.setCode("code3");
        type3.setName("Brijanje");
        all.add(type3);

        return all;
    }

    @Override
    public String getRawpServiceName() {
        return "ReservationTypeService";
    }
}
