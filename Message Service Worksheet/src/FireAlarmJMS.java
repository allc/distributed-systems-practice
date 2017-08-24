import java.util.*;
import javax.jms.*;
import javax.naming.*;

public class FireAlarmJMS {

    public void raise() {
        try {
            Hashtable env = new Hashtable();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
            env.put(Context.PROVIDER_URL, "iiop://localhost:4848");
            Context ctx = new InitialContext(env);

            TopicConnectionFactory topicFactory = (TopicConnectionFactory)ctx.lookup("TopicConnectionFactory");
            Topic topic = (Topic)ctx.lookup("Alarms");
            TopicConnection topicConn = topicFactory.createTopicConnection();
            TopicSession topicSess = topicConn.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

            TopicPublisher topicPub = topicSess.createPublisher(topic);
            TextMessage msg = topicSess.createTextMessage();
            msg.setText("Fire!");
            topicPub.publish(msg);
            System.out.println("published: " + msg.getText());
            topicConn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
