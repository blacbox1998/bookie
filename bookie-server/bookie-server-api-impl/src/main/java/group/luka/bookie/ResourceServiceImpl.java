package group.luka.bookie;

import group.luka.bookie.model.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Override
    public List<Resource> findByWorkingUnit(Integer workingUnit) {
        List<Resource> result = new ArrayList<>();
        Resource resource = new Resource();
        resource.setName("Marko Dusic");
        resource.setUsername("marko1");
        result.add(resource);

        Resource resource2 = new Resource();
        resource2.setName("Vlatko Ilic");
        resource2.setUsername("vlatkoI");
        result.add(resource2);
        return result;
    }

    @Override
    public String getRawpServiceName() {
        return "ResourceService";
    }
}
