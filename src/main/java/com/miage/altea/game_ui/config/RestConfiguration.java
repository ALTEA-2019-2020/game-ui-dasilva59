package com.miage.altea.game_ui.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class RestConfiguration {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /*
    @Autowired
    public void configureLocalInterceptor (RestTemplate rt){
        rt.setInterceptors(List.of((httpRequest, bytes, clientHttpRequestExecution) -> {
            httpRequest.getHeaders().add(HttpHeaders.ACCEPT_LANGUAGE, LocaleContextHolder.getLocale().toLanguageTag());
            return clientHttpRequestExecution.execute(httpRequest,bytes);
        }));
    }
*/
    @Bean
    RestTemplate trainerApiRestTemplate() {
        RestTemplate r = this.restTemplate();
        r.setInterceptors(List.of(new BasicAuthenticationInterceptor("${username}","${password}")));
        return r;
    }

}