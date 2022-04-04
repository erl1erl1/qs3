package idi.bidata.burritobanden.qs3.person.queue;

import idi.bidata.burritobanden.qs3.entity.Queue;
import idi.bidata.burritobanden.qs3.repository.QueueRepository;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service implementation for Queue. The service is used for business functionalities.
 * The @Service tag lets Spring context autodetect the class.
 */
@Service
public class QueueServiceImpl implements QueueService{

    @Autowired
    private QueueRepository queueRepository;

    Logger logger = LoggerFactory.getLogger("LOGGER");

    // Creates a Queue entity.
    @Override
    public Queue saveQueue(Queue queue) {

        return queueRepository.save(queue);
    }

    @Override
    public void setGettingHelp(String subjectCode, Long personId) {
        Queue queue = queueRepository.findBySubjectCodeAndPersonId(subjectCode, personId);
        queue.setBeingHelped(!queue.isBeingHelped());
        queueRepository.save(queue);
    }

    // Fetches list of Queues.
    @Override
    public List<Queue> fetchQueueList() {

        return queueRepository.findAll();
    }

    // Get que entity by subject code.
    @Override
    public List<Queue> getQueueByCode(String subjectCode) {
        List<Queue> queues = new ArrayList<>();
        queues = queueRepository.findAllBySubjectCode(subjectCode);
        for (Queue queue : queues) {
            LocalTime time = LocalTime.parse(queue.getTime());
            LocalTime now = LocalTime.now();
            Duration duration = Duration.between(time, now);
            queue.setTime(String.valueOf(duration.toMinutes()));
        }
        return queues;
    }

    // Updates Queue entity by ID.
    @Override
    public Queue updateQueue(Queue queue, Long queueId) {

        Queue quDB = queueRepository.findById(queueId).get();

        try{
            quDB.setPersonId(queue.getPersonId());
            quDB.setSubjectCode(queue.getSubjectCode());
            quDB.setTime(queue.getTime());
            quDB.setAssignmentId(queue.getAssignmentId());
            quDB.setLocation(queue.getLocation());
        } catch (Exception e) {
            logger.info(e.toString());
        }
        return queueRepository.save(quDB);
    }

    //Deletes queue entity by ID.
    @Override
    public void deleteQueue(String subjectCode, Long personId) {
        queueRepository.deleteBySubjectCodeAndPersonId(subjectCode, personId);
    }
}
