import javax.jms.*;
import javax.naming.*;
import java.util.*;

public class FireAlarmConsumerJMS {

    public String await() {
        try {
            Hashtable env = new Hashtable();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
            env.put(Context.PROVIDER_URL, "iiop://localhost:4848");
            Context ctx = new InitialContext(env);
            TopicConnectionFactory topicFactory = (TopicConnectionFactory)ctx.lookup("TopicConnectionFactory");
            Topic topic = (Topic)ctx.lookup("Alarms");

            TopicConnection topicConn = topicFactory.createTopicConnection();
            TopicSession topicSess = topicConn.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            TopicSubscriber topicSub = topicSess.createSubscriber(topic);
            topicConn.start();

            TextMessage msg = (TextMessage)topicSub.receive();
            return msg.getText();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
