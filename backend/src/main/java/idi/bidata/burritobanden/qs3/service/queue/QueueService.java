package idi.bidata.burritobanden.qs3.service.queue;

import idi.bidata.burritobanden.qs3.entity.Queue;
import org.springframework.stereotype.Service;

import java.util.List;

public interface QueueService {
    Queue saveQueue(Queue queue);

    List<Queue> fetchQueueList();

    List<Queue> getQueueByCode(String subjectCode);

    Queue updateQueue(Queue queue, Long queueId);

    void deleteQueueById(Long queueId);
}
