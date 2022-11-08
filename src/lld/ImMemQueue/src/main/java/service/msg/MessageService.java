package service.msg;

import lombok.NonNull;
import model.JsonMessage;
import model.Topic;
import model.TopicSubscriber;
import service.Subscriber;
import exception.InvalidTopicException;
import service.subs.ConsumerService;
import service.topic.TopicService;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MessageService {
    private final Map<String, TopicService> topicMap = new HashMap<>();
    private final Map<String, Topic> topicList = new HashMap<>();



    public Topic createTopic(@NonNull final String topicName) {
        final Topic topic = new Topic(topicName, UUID.randomUUID().toString());
        TopicService topicService = new TopicService(topic);
        topicMap.put(topic.getTopicId(), topicService);
        topicList.put(topicName,topic);
        System.out.println("Created topic: " + topic.getTopicName());
        return topic;
    }

    public void subscribeToTopic(@NonNull final Subscriber subscriber, @NonNull final Topic topic) {
        topic.addSubscriber(new TopicSubscriber(subscriber));
        System.out.printf( " %s subscribed to topic: %s \n",subscriber.getId() ,  topic.getTopicName());
    }

    public void subscribeToTopic(ConsumerService sub2, String topicV1) {
       Topic topic= topicList.get(topicV1);
       if (null==topic){
           throw new InvalidTopicException("Topic does not exist");
       }
       subscribeToTopic(sub2,topic);

    }

    public void publishMessage(@NonNull final Topic topic, @NonNull final JsonMessage message) {
        topic.addMessage(message);
        System.out.printf( " %s published to topic: %s \n" ,message.getMessage() , topic.getTopicName());
        new Thread(() -> topicMap.get(topic.getTopicId()).publish()).start();
    }

    public void publishMessage(@NonNull final Topic topic, @NonNull final JsonMessage message,int step) {
        if(i==0) {
            i++;
            throw new RuntimeException(" try again");
        }
        topic.addMessage(message);
        System.out.printf( " %s published to topic: %s \n" ,message.getMessage() , topic.getTopicName());
        new Thread(() -> topicMap.get(topic.getTopicId()).publish()).start();
    }
    public void resetOffset(@NonNull final Topic topic, @NonNull final Subscriber subscriber, @NonNull final Integer newOffset) {
        for (TopicSubscriber topicSubscriber : topic.getSubscribers()) {
            if (topicSubscriber.getSubscriber().equals(subscriber)) {
            topicSubscriber.setOffset(newOffset);
                System.out.printf(  " %s offset reset to: %s \n ", topicSubscriber.getSubscriber().getId(), newOffset);
                new Thread(() -> topicMap.get(topic.getTopicId()).startSubscriberWorker(topicSubscriber)).start();
                break;
            }
        }
    }

    int i=0;
    int retry =2;
    public void publishMessageRetry(Topic topic, JsonMessage jsonMessage) {
        try {
                publishMessage(topic, jsonMessage,i);
            System.out.println("SUCCESS"+Thread.currentThread().getName());
        }catch (RuntimeException e){
            System.err.println(e.getMessage());
            System.err.println("Failed to send .. Retrying "+retry);

                if (i<retry) {

                    publishMessageRetry(topic, jsonMessage);
                    retry++;
                }else {
                    retry=0;
                }
        }
    }
}
