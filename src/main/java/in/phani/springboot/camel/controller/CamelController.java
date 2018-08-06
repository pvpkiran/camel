package in.phani.springboot.camel.controller;

import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CamelController {

    @EndpointInject(uri = "direct:abc")
    private ProducerTemplate producerTemplate;

    @GetMapping("/hello")
    public String test() {
        return "Hello Camel";
    }

    @GetMapping("/trigger")
    public void triggerRoute() {
        producerTemplate.sendBody("{\"name\" : \"camel\"}");
    }
}
