package kz.abishev.askhat.itbrainworkout.models.repositories;

import kz.abishev.askhat.itbrainworkout.models.Status;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<Status, Byte> {
}
