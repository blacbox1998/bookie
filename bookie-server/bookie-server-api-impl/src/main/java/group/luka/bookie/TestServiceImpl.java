package group.luka.bookie;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public String getRawpServiceName() {
        return "TestService";
    }

    @Override
    public void print(String message) {
        System.err.println(message);
    }
}
