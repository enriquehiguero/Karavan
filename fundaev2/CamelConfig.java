package org.camel.karavan.demo.fundaev2;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.component.activemq.ActiveMQComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelConfig {

    @Bean(name = "activemq")
    public ActiveMQComponent activeMQComponent() {
        ActiveMQComponent component = new ActiveMQComponent();
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL("tcp://192.168.1.166:61616"); // IP de la máquina virtual
        component.setConnectionFactory(connectionFactory);
        return component;
    }
}