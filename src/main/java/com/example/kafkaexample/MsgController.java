package com.example.kafkaexample;

import com.example.kafkaexample.dto.UserDto;
import com.example.kafkaexample.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;


@RestController
@RequestMapping("msg")
public class MsgController {

    @Autowired
    private KafkaTemplate<Long,UserDto> kafkaTemplate;

    @PostMapping("/{msgId}")
    public void sendOrder(@PathParam("msgId") Long msgId,@RequestBody UserDto msg) {

        msg.setAddress(new Address("By", "Brest", "GOBK", 1L, 1L));

        ListenableFuture<SendResult<Long,UserDto>> future = kafkaTemplate.send("msg",msgId,msg);
        future.addCallback(System.out::println, System.err::println);
        kafkaTemplate.flush();
    }
}
