package br.com.seteideias.springproducer.service;

import br.com.seteideias.springproducer.dto.Message;

public interface AmqpService {
    void sendToConsumer(Message message);
}
