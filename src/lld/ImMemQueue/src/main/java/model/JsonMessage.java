package model;

import lombok.Getter;


@Getter
public class JsonMessage extends lld.ImMemQueue.src.main.java.model.Message {
    private final String message;

    public JsonMessage(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return "JsonMessage{" +
                "message='" + message + '\'' +
                '}';
    }
}
