package model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Message {
    private final String message;
    private final LocalDateTime sentOn=LocalDateTime.now();


    public Message(String message) {
        this.message = message;
    }
}
