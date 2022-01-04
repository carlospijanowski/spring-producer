package br.com.seteideias.springproducer.service;

import br.com.seteideias.springproducer.ampq.AmqpProducer;
import br.com.seteideias.springproducer.dto.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQServiceImpl implements AmqpService {

    @Autowired
    private AmqpProducer<Message> amqp;

    @Override
    public void enviarAoConsumidor(Message message) {
        amqp.produtor(message);
    }
}
