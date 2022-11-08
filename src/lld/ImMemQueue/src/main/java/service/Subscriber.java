package service;

import model.JsonMessage;
import model.Message;

public interface Subscriber {

    String getId();
    void consume(JsonMessage message) throws InterruptedException;
}
