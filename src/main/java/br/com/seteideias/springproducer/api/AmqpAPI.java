package br.com.seteideias.springproducer.api;

import br.com.seteideias.springproducer.dto.Message;
import br.com.seteideias.springproducer.dto.MessageResponse;
import br.com.seteideias.springproducer.service.AmqpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class AmqpAPI {

    @Autowired
    private AmqpService amqpService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/send")
    public ResponseEntity<MessageResponse> sendToConsumer(@RequestBody Message message) {
        amqpService.enviarAoConsumidor(message);
        MessageResponse messageResponse = new MessageResponse("deu tudo certo!!",new Date());
        return ResponseEntity.ok(messageResponse);
    }

    @RequestMapping(value = "/set/{mensagem}", method = RequestMethod.GET)
    public String capturarMensagem(@PathVariable(value = "mensagem") String mensagem) {
        Message message = new Message();
        message.setText(mensagem);
        amqpService.enviarAoConsumidor(message);
        return "texto recuperado.: " + message.getText();
    }

}
