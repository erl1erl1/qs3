package idi.bidata.burritobanden.qs3.person.queue;

import idi.bidata.burritobanden.qs3.entity.Queue;
import java.util.List;

/**
 * Service interface for Queue.
 */
public interface QueueService {
    Queue saveQueue(Queue queue);

    void setGettingHelp(String subjectCode, Long personId);

    List<Queue> fetchQueueList();

    List<Queue> getQueueByCode(String subjectCode);

    Queue updateQueue(Queue queue, Long queueId);

    void deleteQueue(String subjectCode, Long personId);
}
