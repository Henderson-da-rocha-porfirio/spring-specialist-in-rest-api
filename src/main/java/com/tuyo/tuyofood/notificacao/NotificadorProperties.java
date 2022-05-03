package com.tuyo.tuyofood.notificacao;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("notificador.email")
public class NotificadorProperties {

    /**
     * Host do servidor de e-mail
     */
    private String hostServidor;

    /**
     * Porta do servidor de e-mail
     */
    private Integer portaServidor = 25;

    /**
     * Criando Getters e Setters
     */
    public String getHostServidor() {
        return hostServidor;
    }

    public void setHostServidor(String hostServidor) {
        this.hostServidor = hostServidor;
    }

    public Integer getPortaServidor() {
        return portaServidor;
    }

    public void setPortaServidor(Integer portaServidor) {
        this.portaServidor = portaServidor;
    }

}
