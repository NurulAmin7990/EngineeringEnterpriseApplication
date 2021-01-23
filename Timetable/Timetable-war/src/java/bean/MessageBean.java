/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;

/**
 *
 * @author Nurul
 */
@Named(value = "messageBean")
@RequestScoped
public class MessageBean implements Serializable {

    //Constructor
    public MessageBean() {

    }

    //Message driven bean
    @Resource(lookup = "jms/__defaultConnectionFactory")
    private ConnectionFactory connectionFactory;
    @Resource(lookup = "Jms")
    private javax.jms.Queue queue;

    //Attributes
    private String message;

    //Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //Methods
    public String sendMessage() {
        try {
            Connection connection = connectionFactory.createConnection();
            Session session;
            session = connection.createSession(false, Session.DUPS_OK_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue);
            Message convMessage = session.createTextMessage(message);
            messageProducer.send(convMessage);
            messageProducer.close();
            connection.close();
        } catch (JMSException ex) {
            Logger.getLogger(MessageBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "timetabler_index";
    }

//    public String recieveMessage() {
//        try {
//            Connection connection = connectionFactory.createConnection();
//            Session session;
//            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//            MessageConsumer messageConsumer = session.createConsumer(queue);
//            connection.start();
//            Message _message = messageConsumer.receive();
//            messageConsumer.close();
//            connection.close();
//            return _message.getBody(String.class);
//        } catch (JMSException ex) {
//            Logger.getLogger(MessageBean.class.getName()).log(Level.SEVERE, null, ex);
//            return "No messages";
//        }
//    }
}
