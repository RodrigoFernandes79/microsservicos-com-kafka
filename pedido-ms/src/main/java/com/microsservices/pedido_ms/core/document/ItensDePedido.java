//package com.microsservices.pedido_ms.models;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//
//import java.math.BigDecimal;
//
//@Entity
//@Table(name = "TB_ITENS-PEDIDO")
//public class ItensDePedido {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @ManyToOne
//    @JoinColumn(name = "pedido_id")
//    @JsonIgnore
//    private Pedido pedido;
//    private String nomeDoProduto;
//    private int quantidade;
//    private BigDecimal valorDoProduto;
//    private BigDecimal valorTotalParcial;
//    private Boolean produtoExisteNoEstoque = true;
//
//    public ItensDePedido() {
//    }
//
//    public ItensDePedido(Pedido pedido, String nomeDoProduto, int quantidade, BigDecimal valorDoProduto,
//                         BigDecimal valorTotalParcial, Boolean produtoExisteNoEstoque) {
//        this.pedido = pedido;
//        this.nomeDoProduto = nomeDoProduto;
//        this.quantidade = quantidade;
//        this.valorDoProduto = valorDoProduto;
//        this.valorTotalParcial = valorTotalParcial;
//        this.produtoExisteNoEstoque = produtoExisteNoEstoque;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Pedido getPedido() {
//        return pedido;
//    }
//
//    public void setPedido(Pedido pedido) {
//        this.pedido = pedido;
//    }
//
//    public String getNomeDoProduto() {
//        return nomeDoProduto;
//    }
//
//    public void setNomeDoProduto(String nomeDoProduto) {
//        this.nomeDoProduto = nomeDoProduto;
//    }
//
//    public int getQuantidade() {
//        return quantidade;
//    }
//
//    public void setQuantidade(int quantidade) {
//        this.quantidade = quantidade;
//    }
//
//    public BigDecimal getValorDoProduto() {
//        return valorDoProduto;
//    }
//
//    public void setValorDoProduto(BigDecimal valorDoProduto) {
//        this.valorDoProduto = valorDoProduto;
//    }
//
//    public BigDecimal getValorTotalParcial() {
//        return BigDecimal.valueOf(quantidade).multiply(valorDoProduto);
//    }
//
//    public Boolean getProdutoExisteNoEstoque() {
//        return produtoExisteNoEstoque;
//    }
//
//    public void setProdutoExisteNoEstoque(Boolean produtoExisteNoEstoque) {
//        this.produtoExisteNoEstoque = produtoExisteNoEstoque;
//    }
//}
