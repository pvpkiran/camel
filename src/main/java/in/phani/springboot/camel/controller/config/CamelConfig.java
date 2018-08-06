package in.phani.springboot.camel.controller.config;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CamelConfig {

    @Bean
    public RoutesBuilder routes(){
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:abc").to("bean:camelBeanComponent?method=processRoute");
            }
        };
    }
}
