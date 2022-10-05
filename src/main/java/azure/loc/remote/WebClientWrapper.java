package azure.loc.remote;

import azure.loc.exception.TechnicalException;
import azure.loc.utilities.UriBuilderFunctionalInterface;
import azure.loc.utilities.Utility;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;
import java.io.Serializable;

/*
Wrapper of WebClient interface, represents main entry point for performing web requests
 */
@Component
public class WebClientWrapper implements Serializable {

    public <T> T get(String contentTypeHeader, MediaType acceptHeader, UriBuilderFunctionalInterface uriBuilderFunctionalInterface, Class<T> objectToReturn) throws Exception {
          return getWebClient(contentTypeHeader)
                .get()
                .uri(uriBuilderFunctionalInterface.buildUri())
                .accept(acceptHeader)
                .retrieve()
                .bodyToMono(objectToReturn)
                .block();
    }

    /*
    this method will return a webclient object with authorization token injected
     */
    private WebClient getWebClient(String contentTypeHeader) throws Exception {
        HttpClient httpConnector = null;
        try{
            final SslContext sslContext = SslContextBuilder.forClient().trustManager(InsecureTrustManagerFactory.INSTANCE).build();
            httpConnector = HttpClient.create().secure(t -> t.sslContext(sslContext));
            HttpClient.create().secure(t -> t.sslContext(sslContext));
        } catch (SSLException e) {
            String message = "Error calling remote API";
            throw new TechnicalException(message + e.getMessage());
        }
        return WebClient.builder()
                        .defaultHeader(HttpHeaders.AUTHORIZATION, Utility.getAuthorizationToken())
                        .defaultHeader(HttpHeaders.CONTENT_TYPE, contentTypeHeader)
                        .clientConnector(new ReactorClientHttpConnector(httpConnector))
                        .build();
    }
}
