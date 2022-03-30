package idi.bidata.burritobanden.qs3.service;

import idi.bidata.burritobanden.qs3.entity.Queue;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QueueServiceImpl implements QueueService{
    @Override
    public Queue saveQueue(Queue queue) {
        return null;
    }

    @Override
    public List<Queue> fetchQueueList() {
        return null;
    }

    @Override
    public Queue updateQueue(Queue queue, Long queueId) {
        return null;
    }

    @Override
    public void deleteQueueById(Long queueId) {

    }
}
