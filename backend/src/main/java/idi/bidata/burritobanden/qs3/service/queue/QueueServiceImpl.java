package idi.bidata.burritobanden.qs3.service.queue;

import idi.bidata.burritobanden.qs3.entity.Queue;
import idi.bidata.burritobanden.qs3.repository.QueueRepository;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
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
        for (Queue queue : queues) {
            LocalTime time = LocalTime.parse(queue.getTime());
            LocalTime now = LocalTime.now();
            Duration duration = Duration.between(time, now);
            queue.setTime(String.valueOf(duration.toMinutes()));
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
            quDB.setTime(queue.getTime());
            quDB.setAssignmentId(queue.getAssignmentId());
            quDB.setLocation(queue.getLocation());
        } catch (Exception e) {
            logger.info(e.toString());
        }
        return queueRepository.save(quDB);
    }

    //Delete operation
    @Override
    public void deleteQueue(String subjectCode, Long personId) {
        queueRepository.deleteBySubjectCodeAndPersonId(subjectCode, personId);
    }
}
