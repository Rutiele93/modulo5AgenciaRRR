package com.br.agencia.BdSpring.model;

import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Reservas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
    
	@Column(nullable = false, length = 80)
    private String pagamento;
	
	@Column(nullable = false, length = 80)
    private String statusPedido;
	
	@Column(nullable = false)
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal precoTotal;
    
    @Column(nullable = false, columnDefinition = "Integer")
    private int qtdReservada;
    
    @ManyToOne
    @JoinColumn(name = "clientes_id_fk", nullable = false)
    private Clientes clientes;

    @ManyToOne
    @JoinColumn(name = "destinos_id_fk",  nullable = true)
    private Destinos destinos;
 
    
	public Destinos getDestinos() {
		return destinos;
	}

	public void setDestinos(Destinos destinos) {
		this.destinos = destinos;
	}

	 @ManyToOne
	 @JoinColumn(name = "promocao_id_fk",  nullable = true)
	 private Promocao promocao;
	 

	public Promocao getPromocao() {
		return promocao;
	}

	public void setPromocao(Promocao promocao) {
		this.promocao = promocao;
	}

	public Reservas() {
		
	}

	
	public Reservas(Long id, Clientes clientes, String pagamento, String statusPedido,
			BigDecimal precoTotal, int qtdReservada) {
		super();
		this.id = id;
		this.clientes = clientes;
		this.pagamento = pagamento;
		this.statusPedido = statusPedido;
		this.precoTotal = precoTotal;
		this.qtdReservada = qtdReservada;
	
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPagamento() {
		return pagamento;
	}

	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}

	public String getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(String statusPedido) {
		this.statusPedido = statusPedido;
	}

	public BigDecimal getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(BigDecimal precoTotal) {
		this.precoTotal = precoTotal;
	}

	public int getQtdReservada() {
		return qtdReservada;
	}

	public void setQtdReservada(int qtdReservada) {
		this.qtdReservada = qtdReservada;
	}

	public Clientes getClientes() {
		return clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

}
