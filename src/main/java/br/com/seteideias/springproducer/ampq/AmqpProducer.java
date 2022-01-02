package br.com.seteideias.springproducer.ampq;

public interface AmqpProducer <T>{
    void producer(T t);
}
