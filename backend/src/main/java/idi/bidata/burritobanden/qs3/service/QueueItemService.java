package idi.bidata.burritobanden.qs3.service;

import idi.bidata.burritobanden.qs3.entity.QueueItem;

import java.util.List;

public interface QueueItemService {
    QueueItem saveQueueItem(QueueItem queueItem);

    List<QueueItem> fetchQueueItemList();

    QueueItem updateQueueItem(QueueItem queueItem, Long queueItemId);

    void deleteQueueItemById(Long queueItemId);
}
