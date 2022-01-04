package br.com.seteideias.springproducer.ampq;

public interface AmqpProducer <T>{
    void produtor(T t);
}
