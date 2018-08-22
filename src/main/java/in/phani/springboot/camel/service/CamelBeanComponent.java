package in.phani.springboot.camel.service;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component
public class CamelBeanComponent {

    public void processRoute(Exchange exchange) {
        System.out.println(exchange.getIn().getBody());
    }
}
