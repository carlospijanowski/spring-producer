package br.com.seteideias.springproducer.api;

import br.com.seteideias.springproducer.dto.Message;
import br.com.seteideias.springproducer.service.AmqpService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
public class AmqpAPI {

    @Autowired
    private AmqpService amqpService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/send")
    public void sendToConsumer(@RequestBody Message message) {
        amqpService.enviarAoConsumidor(message);
        log.info("sucesso - mensagem.: {}",message.getText());
    }

    @GetMapping(value = "/set/{mensagem}")
    public String capturarMensagem(@PathVariable(value = "mensagem") String mensagem) {
        Message message = new Message();
        message.setText(mensagem);
        amqpService.enviarAoConsumidor(message);
        return "texto recuperado.: " + message.getText();
    }

}
