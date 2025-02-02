//package com.microsservices.pedido_ms.controller;
//
//import com.microsservices.pedido_ms.repositories.PedidoRepository;
//import com.microsservices.pedido_ms.dtos.PedidoEntradaDto;
//import com.microsservices.pedido_ms.models.Pedido;
//import com.microsservices.pedido_ms.service.PedidoService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/pedidos")
//public class PedidoController {
//
//    private final PedidoService pedidoService;
//
//    public PedidoController(PedidoService pedidoService) {
//        this.pedidoService = pedidoService;
//    }
//
//
//    @PostMapping
//    public ResponseEntity<Pedido> salvaPedido(@RequestBody PedidoEntradaDto pedidoEntradaDto) {
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.criaPedido(pedidoEntradaDto));
//    }
//}
