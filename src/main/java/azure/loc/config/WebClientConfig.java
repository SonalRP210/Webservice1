package azure.loc.config;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

/*We have configured WebClient as Spring bean:*/

@Log4j2
@Configuration
public class WebClientConfig {
    //private static final Logger log = LoggerFactory.getLogger(WebClientConfig.class);     //either a log variable or annotation

    @Bean
    public WebClient webClient(@Value("${remote.server.host:localhost}") String host,
                               @Value("${wiremock.server.port:8083}") int port,
                               @Value("${global-timeout:5000}") int globalTimeout,
                               @Value("${request-timeout:1000}") int requestTimeout){
        ClientHttpConnector connector = new ReactorClientHttpConnector(
                HttpClient.create()
                          .responseTimeout(Duration.ofMillis(globalTimeout))
                          .doOnRequest((req, conn) -> {
                                log.debug("webclient - {}", req);
                                req.responseTimeout(Duration.ofMillis(requestTimeout));
                          })
        );
        return WebClient.builder()
                .baseUrl("http://"+host+":"+port)
                .clientConnector(connector)
                .build();
    }

    @Bean
    public WebClient webClient1(){
        return WebClient.builder().build();
    }
}
