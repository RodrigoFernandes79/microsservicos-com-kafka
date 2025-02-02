package com.microsservices.pedido_ms.config.exception;

public class ProdutoNaoExisteNoEstoqueException extends RuntimeException {

    public ProdutoNaoExisteNoEstoqueException(String message) {
        super(message);
    }
}
