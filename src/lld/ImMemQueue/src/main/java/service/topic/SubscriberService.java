package service.topic;

import lombok.NonNull;
import model.JsonMessage;
import model.Topic;
import model.TopicSubscriber;

public class SubscriberService implements Runnable {

    private final Topic topic;
    private final TopicSubscriber topicSubscriber;

    public SubscriberService(@NonNull final Topic topic, @NonNull final TopicSubscriber topicSubscriber) {
        this.topic = topic;
        this.topicSubscriber = topicSubscriber;
    }

   // Sub 1 t2 t3
    // Node topic active --> Node topic a

    @Override
    public void run() {
        synchronized (topicSubscriber) {
            do {
                int curOffset = topicSubscriber.getOffset();
                try {

                    while (curOffset >= topic.getMessages().size()) {
                        topicSubscriber.wait();
                    }
                    JsonMessage message = topic.getMessages().get(curOffset);
                    topicSubscriber.getSubscriber().consume(message);

                    topicSubscriber.setOffset(curOffset + 1);
                }catch (InterruptedException e){
                    System.out.printf("Interrupted ex %s",e.getMessage());
                }
            } while (true);
        }


    }



    synchronized public void wakeUpIfNeeded() {
        synchronized (topicSubscriber) {
            topicSubscriber.notify();
        }
    }
}