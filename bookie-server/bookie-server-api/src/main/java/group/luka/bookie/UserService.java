package group.luka.bookie;

import blacbox.project.rawp.RawpServiceComponent;
import group.luka.bookie.model.User;

public interface UserService extends RawpServiceComponent {

    User insert(User user);

    User update(User user);

    User findByUsername(String username);

    User findAll(String username);

    void delete(User user);


}
