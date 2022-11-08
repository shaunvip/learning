package service.topic;

import lombok.NonNull;
import model.JsonMessage;
import model.Topic;
import model.TopicSubscriber;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;

public class ExpirationService implements Runnable {


    private final Topic topic;

    public ExpirationService(@NonNull final Topic topic, @NonNull final TopicSubscriber topicSubscriber) {
        this.topic = topic;
    }


    @Override
    public void run() {

        do {
            int curOffset = 0;

            JsonMessage message = topic.getMessages().get(curOffset);

            if (message.getSentOn().until(LocalDateTime.now(), ChronoUnit.MINUTES) > 1) {
                System.err.printf("REMOVING EXPIRED MESSAGE %s", message);
                topic.getMessages().remove(message);
            }

        } while (true);
    }
}