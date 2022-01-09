package br.com.seteideias.springproducer.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class MessageResponse {

    private String resposta;
    private Date date;

}
