package com.tuyo.tuyofood.notificacao;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* 1. @Retention: informa quanto tempo o Qualifier será utilizado.
* 2. RUNTIME: significa que Retention pode ser lida em tempo de execução.
* 3. Tempo de execução: significa que em todos os lugares que foi anotado não tivesse sido anotado */

@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface NotificadorTipo {

    NotificadorUrgencia value();
}
