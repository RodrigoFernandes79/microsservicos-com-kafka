package com.microsservices.pedido_ms.exceptions.handlers;

import com.microsservices.pedido_ms.exceptions.ProdutoNaoExisteNoEstoqueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProdutoNaoExisteNoEstoqueException.class)
    public ResponseEntity<HandlerError> produtoNaoExisteNoEstoque(ProdutoNaoExisteNoEstoqueException e) {

        HandlerError error = new HandlerError(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                LocalDate.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    private record HandlerError(
            String message,
            HttpStatus status,
            LocalDate time
    ) {
    }
}
