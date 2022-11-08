package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import service.Subscriber;

@Getter
@Setter
@NoArgsConstructor
public class TopicSubscriber {
    private  Integer offset=0;
    private  Subscriber subscriber;
    public TopicSubscriber(@NonNull final Subscriber subscriber) {
        this.subscriber = subscriber;
    }


}
