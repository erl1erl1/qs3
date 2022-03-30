package idi.bidata.burritobanden.qs3.service;

import idi.bidata.burritobanden.qs3.entity.Queue;
import idi.bidata.burritobanden.qs3.repository.QueueRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class QueueServiceImpl implements QueueService{

    @Autowired
    private QueueRepository queueRepository;

    Logger logger = LoggerFactory.getLogger("LOGGER");

    //Save operation
    @Override
    public Queue saveQueue(Queue queue) {

        return queueRepository.save(queue);
    }

    //Read operation
    @Override
    public List<Queue> fetchQueueList() {

        return (List<Queue>) queueRepository.findAll();
    }

    // Update operation
    @Override
    public Queue updateQueue(Queue queue, Long queueId) {

        Queue quDB = queueRepository.findById(queueId).get();

        try{
            quDB.setPersonId(queue.getPersonId());
            quDB.setSubjectId(queue.getSubjectId());
            quDB.setDate(queue.getDate());
            quDB.setAssignmentId(queue.getAssignmentId());
            quDB.setLocation(queue.getLocation());
        } catch (Exception e) {
            logger.info(e.toString());
        }
        return queueRepository.save(quDB);
    }

    //Delete operation
    @Override
    public void deleteQueueById(Long queueId) {
        queueRepository.deleteById(queueId);
    }
}
