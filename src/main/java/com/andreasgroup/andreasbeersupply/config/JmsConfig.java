package com.andreasgroup.andreasbeersupply.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

/**
 * Created on 12/Nov/2020 to andreas-beer-supply
 */
@Configuration
public class JmsConfig {

    @Bean
    public MessageConverter messageConverter(){
//        Serialization of the message to JSON using the TextMessage in JMS
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

}
