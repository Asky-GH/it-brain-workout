package kz.abishev.askhat.itbrainworkout.models.repositories;

import kz.abishev.askhat.itbrainworkout.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
