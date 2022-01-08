package br.com.seteideias.springproducer.service;

import br.com.seteideias.springproducer.dto.Message;

public interface AmqpService {
    void enviarAoConsumidor (Message message);

}
