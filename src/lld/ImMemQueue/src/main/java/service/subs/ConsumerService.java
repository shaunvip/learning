package service.subs;

import model.JsonMessage;
import service.Subscriber;

import java.util.UUID;

public class ConsumerService implements Subscriber {
    private final UUID id;
    private final String name;
    private final int sleepTimeInMillis;

    public ConsumerService(String name, int sleepTimeInMillis) {
        this.id = java.util.UUID.randomUUID();
        this.name=name;
        this.sleepTimeInMillis = sleepTimeInMillis;
    }

    @Override
    public String getId() {
        return this.name+" "+this.id;
    }

    @Override
    public void consume(JsonMessage message) throws InterruptedException {
        System.out.println("Subscriber: " + id + " started consuming: " + message.getMessage());
        Thread.sleep(sleepTimeInMillis);
        System.out.println("Subscriber: " + id + " done consuming: " + message.getMessage());


    }
}
