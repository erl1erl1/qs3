package idi.bidata.burritobanden.qs3.controller;

import idi.bidata.burritobanden.qs3.entity.QueueItem;
import idi.bidata.burritobanden.qs3.service.QueueItemService;
import java.util.List;
// Importing required classes
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class QueueItemController {

    @Autowired private QueueItemService queueItemService;

    // Save operation
    @PostMapping("/queueItems")
    public QueueItem saveQueueItem(
            @Valid @RequestBody QueueItem queueItem)
    {
        return queueItemService.saveQueueItem(queueItem);
    }

    // Read operation
    @GetMapping("/queueItems")
    public List<QueueItem> fetchUserList()
    {
        return queueItemService.fetchQueueItemList();
    }


    // Update operation
    @PutMapping("/queueItems/{id}")
    public QueueItem
    updateUser(@RequestBody QueueItem queueItem,
               @PathVariable("id") Long queueItemId)
    {
        return queueItemService.updateQueueItem(
                queueItem, queueItemId);
    }

    // Delete operation
    @DeleteMapping("/queueItem/{id}")
    public String deleteUserById(@PathVariable("id")
                                         Long queueItemId)
    {
        queueItemService.deleteQueueItemById(
                queueItemId);
        return "Deleted Successfully";
    }
}
