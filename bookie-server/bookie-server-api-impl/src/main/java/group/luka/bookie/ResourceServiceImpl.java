package group.luka.bookie;

import group.luka.bookie.model.ReservationType;
import group.luka.bookie.model.Resource;
import group.luka.bookie.model.ResourceOptionWrapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Override
    public List<ResourceOptionWrapper> findOptionsByWorkingUnitAndType(Integer workingUnit, ReservationType type) {
        List<ResourceOptionWrapper> result = new ArrayList<>();

        ResourceOptionWrapper wrapper = new ResourceOptionWrapper();
        Resource resource = new Resource();
        resource.setName("Marko Dusic");
        resource.setUsername("marko1");

        wrapper.setResource(resource);
        wrapper.setPrice(new BigDecimal("23.5"));
        result.add(wrapper);

        ResourceOptionWrapper wrapper1 = new ResourceOptionWrapper();
        Resource resource2 = new Resource();
        resource2.setName("Vlatko Ilic");
        resource2.setUsername("vlatkoI");
        wrapper1.setResource(resource);
        wrapper1.setPrice(new BigDecimal("21.5"));
        result.add(wrapper1);

        return result;
    }

    @Override
    public String getRawpServiceName() {
        return "ResourceService";
    }
}
