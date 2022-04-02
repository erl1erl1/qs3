package idi.bidata.burritobanden.qs3.controller;

import idi.bidata.burritobanden.qs3.entity.Queue;
import idi.bidata.burritobanden.qs3.service.queue.QueueService;

import java.util.Date;
import java.util.List;
// Importing required classes
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class QueueController {

    @Autowired private QueueService queueService;

    // Save operation
    @PostMapping("/queues")
    public Queue saveQueue(
            @Valid @RequestBody Queue queue)
    {
        queue.setDate(new Date());
        queue.setApproved(false);
        return queueService.saveQueue(queue);
    }

    // Read operation
    @GetMapping("/queues")
    public List<Queue> fetchQueueList()
    {
        return queueService.fetchQueueList();
    }

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
    @DeleteMapping("/queues/{id}")
    public String deleteQueueById(@PathVariable("id")
                                         Long queueId)
    {
        queueService.deleteQueueById(
                queueId);
        return "Deleted Successfully";
    }
}
