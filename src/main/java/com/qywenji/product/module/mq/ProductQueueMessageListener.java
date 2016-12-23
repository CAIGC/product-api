package com.qywenji.product.module.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by CAI_GC on 2016/12/22.
 */
@Component
public class ProductQueueMessageListener implements MessageListener {

    private static Logger logger = LoggerFactory.getLogger(ProductQueueMessageListener.class);
    /**
     * 接收消息
     */
    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                TextMessage mes = (TextMessage) message;
                String text = mes.getText();
                this.handleMes(text);
            } else {
                logger.info("*******此消息有问题！消息类型不是text数据*********");
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void handleMes(String mes) {

    }
}
