package in.phani.springboot.camel.controller.config;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component
public class CamelBeanComponent {

    public void processRoute(Exchange exchange) {
        System.out.println(exchange.getIn().getBody());
    }
}
