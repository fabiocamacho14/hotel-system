package com.oranet.hotelsystem.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

    MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem incompreensível."),
    RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado."),
    ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso."),
    NEGOCIO_EXCEPTION("/erro-de-negocio", "Erro de negócio."),
    PARAMETRO_INVALIDO("/parametro-invalido", "Parâmetro inválido."),
    ERRO_DE_SISTEMA("/erro-de-sistema", "Erro de sistema."),
    DADOS_INVALIDOS("/dados-invalidos", "Dados inválidos.");

    private String title;
    private String uri;

    ProblemType(String path, String title) {
        this.uri = "https://localhost:8080" + path;
        this.title = title;
    }
}
