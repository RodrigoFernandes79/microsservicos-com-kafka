package com.microsservices.pedido_ms.exceptions;

public class ProdutoNaoExisteNoEstoqueException extends RuntimeException {

    public ProdutoNaoExisteNoEstoqueException(String message) {
        super(message);
    }
}
