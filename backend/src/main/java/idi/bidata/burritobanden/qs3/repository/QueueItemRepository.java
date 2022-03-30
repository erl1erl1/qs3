package idi.bidata.burritobanden.qs3.repository;

import idi.bidata.burritobanden.qs3.entity.QueueItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface QueueItemRepository extends CrudRepository<QueueItem, Long> {
}
