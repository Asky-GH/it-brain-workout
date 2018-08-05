package kz.abishev.askhat.itbrainworkout.models.repositories;

import kz.abishev.askhat.itbrainworkout.models.Progress;
import kz.abishev.askhat.itbrainworkout.models.Subject;
import kz.abishev.askhat.itbrainworkout.models.User;
import org.springframework.data.repository.CrudRepository;

public interface ProgressRepository extends CrudRepository<Progress, Long> {
    Iterable<Progress> findByUserAndSubject(User user, Subject subject);
}
