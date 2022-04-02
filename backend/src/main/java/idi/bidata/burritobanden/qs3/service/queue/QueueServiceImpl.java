package idi.bidata.burritobanden.qs3.service.queue;

import idi.bidata.burritobanden.qs3.entity.Queue;
import idi.bidata.burritobanden.qs3.repository.QueueRepository;

import java.util.ArrayList;
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

        return queueRepository.findAll();
    }

    @Override
    public List<Queue> getQueueByCode(String subjectCode) {
        List<Queue> queues = new ArrayList<>();
        queues = queueRepository.findAllBySubjectCode(subjectCode);
        for(int i = 0; i < queues.size(); i++){
            queues.get(i).setDate(Math.abs(queues.get(i).getDate()));
        }
        return queues;
    }

    // Update operation
    @Override
    public Queue updateQueue(Queue queue, Long queueId) {

        Queue quDB = queueRepository.findById(queueId).get();

        try{
            quDB.setPersonId(queue.getPersonId());
            quDB.setSubjectCode(queue.getSubjectCode());
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
