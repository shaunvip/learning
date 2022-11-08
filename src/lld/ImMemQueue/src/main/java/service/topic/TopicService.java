package service.topic;

import lombok.NonNull;
import model.Topic;
import model.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;

public class TopicService {
    private final Topic topic;
    private final Map<String, SubscriberService> subscriberWorkers;
    private final Map<String, ExpirationService> expirationWorkers;

    public TopicService(@NonNull final Topic topic) {
        this.topic = topic;
        subscriberWorkers = new HashMap<>();
        expirationWorkers = new HashMap<>();
    }

    public void publish() {
        for (TopicSubscriber topicSubscriber:topic.getSubscribers()) {
            startSubscriberWorker(topicSubscriber);
            startExpirationWorker(topicSubscriber); // TODO FIX
        }
    }

    public void startSubscriberWorker(@NonNull final TopicSubscriber topicSubscriber) {
        final String subscriberId = topicSubscriber.getSubscriber().getId();
        if (!subscriberWorkers.containsKey(subscriberId)) {
            final SubscriberService subscriberService = new SubscriberService(topic, topicSubscriber);
            subscriberWorkers.put(subscriberId, subscriberService);
            new Thread(subscriberService).start();
        }
        final SubscriberService subscriberService = subscriberWorkers.get(subscriberId);
        subscriberService.wakeUpIfNeeded();
    }
    public void startExpirationWorker(@NonNull final TopicSubscriber topicSubscriber) {
        final String subscriberId = topicSubscriber.getSubscriber().getId();
        if (!expirationWorkers.containsKey(subscriberId)) {
            final ExpirationService expirationService = new ExpirationService(topic, topicSubscriber);
            expirationWorkers.put(subscriberId, expirationService);
            new Thread(expirationService).start();
        }
    }
}
