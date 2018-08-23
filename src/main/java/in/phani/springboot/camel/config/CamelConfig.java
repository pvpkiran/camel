package in.phani.springboot.camel.config;

import in.phani.springboot.camel.pojo.Product;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;

import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class CamelConfig {

    @Bean
    public RoutesBuilder routes(){
        return new RouteBuilder() {
            @Override
            public void configure() {

                from("direct:abc").to("bean:camelBeanComponent?method=processRoute");

                restConfiguration()
                        .component("netty4-http")
                        .host("localhost")
                        /*.bindingMode(RestBindingMode.json)*/
                        .port(8070);
                rest()
                        .post("/addproduct")
                        .consumes("application/json")
                        .produces("application/json")
                        .type(Product.class)
                        .to("direct:addproduct");
                from("direct:addproduct")
                        .log("request body : ${body}")
                        .setHeader(Exchange.CONTENT_TYPE, simple(MediaType.APPLICATION_JSON_VALUE) )
                        .to("netty4-http:http://localhost:8090/product/add?bridgeEndpoint=true")
                        .end();
            }
        };
    }
}
