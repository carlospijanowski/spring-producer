package br.com.seteideias.springproducer.dto;

import lombok.Data;

import java.util.Date;

public class MessageResponse {

    private String resposta;
    private Date date;

    public MessageResponse(String resposta, Date date) {
        this.resposta = resposta;
        this.date = date;
    }
}
