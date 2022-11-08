import model.JsonMessage;
import model.Topic;
import service.msg.MessageService;
import service.subs.ConsumerService;
import service.topic.TopicService;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        final MessageService messageService = new MessageService();
        final Topic topic1 = messageService.createTopic("topicV1");
        final Topic topic2 = messageService.createTopic("topicV2");

        final ConsumerService sub1 = new ConsumerService( "C1",10000);
        final ConsumerService sub2 = new ConsumerService("C2", 10000);

        messageService.subscribeToTopic(sub1, topic1);
        messageService.subscribeToTopic(sub2, "topicV1");

        try {
            messageService.subscribeToTopic(sub2, "topicV4");

        }catch (Exception e){
            System.err.println(e.getMessage());
            // ignored
        }

        final ConsumerService sub3 = new ConsumerService("C33", 5000);
        messageService.subscribeToTopic(sub3, topic2);

        messageService.publishMessage(topic1, new JsonMessage("{'hello:vipul'}"));
        System.out.println("RETRY MECH");
        messageService.publishMessageRetry(topic1, new JsonMessage(("{'reply:Yesvipul'}")));

        messageService.publishMessage(topic2, new JsonMessage("{'k3':'v3'}"));

        Thread.sleep(15000);
        messageService.publishMessage(topic2, new JsonMessage("{'k4':'v4'}"));
        messageService.publishMessage(topic1, new JsonMessage("{'k5':v45}"));

        messageService.resetOffset(topic1, sub1, 0);

        final Topic topic4 = messageService.createTopic("topicV44");
        messageService.publishMessage(topic4,new JsonMessage("VVV"));

    }
}
