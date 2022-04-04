package idi.bidata.burritobanden.qs3.controller;

import idi.bidata.burritobanden.qs3.entity.Queue;
import idi.bidata.burritobanden.qs3.person.queue.QueueService;
import java.time.LocalTime;
import java.util.List;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController

public class QueueController {

    @Autowired private QueueService queueService;
    Logger logger = LoggerFactory.getLogger("LOGGER");

    // Save operation
    @PostMapping("/queues")
    public Queue saveQueue(
            @Valid @RequestBody Queue queue)
    {
        queue.setTime(LocalTime.now().toString());
        queue.setBeingHelped(false);
        return queueService.saveQueue(queue);
    }

    // Read operation
    @GetMapping("/queues")
    public List<Queue> fetchQueueList()
    {
        return queueService.fetchQueueList();
    }

    //Get operation. Returns queue object based on subject code.
    @GetMapping("/queues/{subjectCode}")
    public List<Queue> getQueueByCode(@PathVariable String subjectCode){
        return queueService.getQueueByCode(subjectCode);
    }

    // Update operation
    @PutMapping("/queues/{id}")
    public Queue
    updateQueue(@RequestBody Queue queue,
               @PathVariable("id") Long queueId)
    {
        return queueService.updateQueue(
                queue, queueId);
    }

    // Delete operation
    @DeleteMapping("/queues/{subjectCode}/{personId}")
    public String deleteQueueById(@PathVariable("subjectCode") String subjectCode, @PathVariable ("personId") Long personId)
    {
        queueService.deleteQueue(subjectCode, personId);
        return "Deleted Successfully";
    }

    @PostMapping("/queues/{subjectCode}/{personId}")
    public void setGettingHelp(@PathVariable("subjectCode") String subjectCode, @PathVariable("personId") Long personId)
    {
        queueService.setGettingHelp(subjectCode, personId);
    }
}
