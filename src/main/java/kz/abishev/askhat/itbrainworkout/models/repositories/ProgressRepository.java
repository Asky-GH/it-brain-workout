package kz.abishev.askhat.itbrainworkout.models.repositories;

import kz.abishev.askhat.itbrainworkout.models.Progress;
import org.springframework.data.repository.CrudRepository;

public interface ProgressRepository extends CrudRepository<Progress, Long> {
}
