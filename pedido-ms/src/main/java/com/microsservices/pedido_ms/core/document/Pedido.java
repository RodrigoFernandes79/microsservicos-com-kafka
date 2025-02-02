//package com.microsservices.pedido_ms.models;
//
//import com.microsservices.pedido_ms.dtos.PedidoEntradaDto;
//import com.microsservices.pedido_ms.enums.StatusPedido;
//import jakarta.persistence.*;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.util.List;
//
////@Entity
//@Table(name = "TB_PEDIDOS")
//public class Pedido {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
//    private List<ItensDePedido> itensDePedido;
//    private LocalDateTime dataDoPedido;
//    @Enumerated(EnumType.STRING)
//    private StatusPedido statusPedido;
//    private Long userId;
//    private BigDecimal valorTotalPedido;
//
//    public Pedido() {
//    }
//
//    public Pedido(Long userId, List<ItensDePedido> itensDePedido) {
//        this.userId = userId;
//        this.itensDePedido = itensDePedido;
//        this.dataDoPedido = LocalDateTime.now();
//
//    }
//
//    public Pedido(PedidoEntradaDto pedidoEntradaDto) {
//        this.userId = pedidoEntradaDto.userId();
//        this.itensDePedido = pedidoEntradaDto.itensDePedido();
//        this.dataDoPedido = LocalDateTime.now();
//        this.statusPedido = StatusPedido.AGUARDANDO_PAGAMENTO;
//    }
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public List<ItensDePedido> getItensDePedido() {
//        return itensDePedido;
//    }
//
//    public void setItensDePedido(List<ItensDePedido> itensDePedido) {
//        this.itensDePedido = itensDePedido;
//    }
//
//    public LocalDateTime getDataDoPedido() {
//        return dataDoPedido;
//    }
//
//    public void setDataDoPedido(LocalDateTime dataDoPedido) {
//        this.dataDoPedido = dataDoPedido;
//    }
//
//    public StatusPedido getStatusPedido() {
//        return statusPedido;
//    }
//
//    public void setStatusPedido(StatusPedido statusPedido) {
//        this.statusPedido = statusPedido;
//    }
//
//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public BigDecimal getValorTotalPedido() {
//        return valorTotalPedido;
//    }
//
//    public void calculaValorTotalPedido(List<ItensDePedido> itensDePedido) {
//        BigDecimal valorTotalPedido = BigDecimal.valueOf(0.00);
//        for (ItensDePedido itens : itensDePedido) {
//            valorTotalPedido = itens.getValorTotalParcial().add(valorTotalPedido);
//
//        }
//        this.valorTotalPedido =  valorTotalPedido;
//    }
//}
