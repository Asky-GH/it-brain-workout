package kz.abishev.askhat.itbrainworkout.models.repositories;

import kz.abishev.askhat.itbrainworkout.models.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends CrudRepository<Subject, Integer> {
    Subject findByTitle(String title);
}
