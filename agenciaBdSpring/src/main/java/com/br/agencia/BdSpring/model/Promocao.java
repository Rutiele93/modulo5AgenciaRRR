package com.br.agencia.BdSpring.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat.Style;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Promocao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	

	@Column(nullable = false, length = 80)
    private String nomeDestinoProm;

    @Column(nullable = false, length = 14)
    private String categoriaDestinoProm;

    @Column(nullable = false, length = 15)
    private String condicaoProm;

    @Column(name = "data_ida", nullable = false)
    @DateTimeFormat(iso = ISO.DATE, pattern = "dd-MM-yyyy")
    private LocalDate dataIdaProm;     

    @Column(name = "data_chegada", nullable = false)
    @DateTimeFormat(iso = ISO.DATE, pattern = "dd-MM-yyyy")
    private LocalDate dataChegadaProm;   
    
    @Column(name = "hora_ida", nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime horaIdaProm; 
    
    @Column(name = "hora_chegada", nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime horaChegadaProm;  
    
    @Column(name = "duracao", nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime duracao; 
    
    @Column(nullable = false)
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal precoUnitProm;
    
    @Column(nullable = false)
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal precoAnteriorProm;
    
    @Column(nullable = false, columnDefinition = "Integer")
    private int qtdDisponivelProm;
    
	@Column(columnDefinition = "longblob")
	private byte[] imagem;


	@ManyToMany(mappedBy = "promocao", fetch = FetchType.LAZY)
    private List<Reservas> reservas;

	public List<Reservas> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reservas> reservas) {
		this.reservas = reservas;
	}
//	public void adicionarReserva(Reservas reservas) {   	       
//		this.reservas.add(reservas);
//		   reservas.setPromocao(this);		       
//	 }
//	Promocao promocao = new Promocao();
//	Reservas reserva = new Reservas();	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDestinoProm() {
		return nomeDestinoProm;
	}

	public void setNomeDestinoProm(String nomeDestinoProm) {
		this.nomeDestinoProm = nomeDestinoProm;
	}

	public String getCategoriaDestinoProm() {
		return categoriaDestinoProm;
	}

	public void setCategoriaDestinoProm(String categoriaDestinoProm) {
		this.categoriaDestinoProm = categoriaDestinoProm;
	}

	public String getCondicaoProm() {
		return condicaoProm;
	}

	public void setCondicaoProm(String condicaoProm) {
		this.condicaoProm = condicaoProm;
	}

	public LocalDate getDataIdaProm() {
		return dataIdaProm;
	}

	public void setDataIdaProm(LocalDate dataIdaProm) {
		this.dataIdaProm = dataIdaProm;
	}

	public LocalDate getDataChegadaProm() {
		return dataChegadaProm;
	}

	public void setDataChegadaProm(LocalDate dataChegadaProm) {
		this.dataChegadaProm = dataChegadaProm;
	}

	public LocalTime getHoraIdaProm() {
		return horaIdaProm;
	}

	public void setHoraIdaProm(LocalTime horaIdaProm) {
		this.horaIdaProm = horaIdaProm;
	}

	public LocalTime getHoraChegadaProm() {
		return horaChegadaProm;
	}

	public void setHoraChegadaProm(LocalTime horaChegadaProm) {
		this.horaChegadaProm = horaChegadaProm;
	}

	public BigDecimal getPrecoUnitProm() {
		return precoUnitProm;
	}

	public void setPrecoUnitProm(BigDecimal precoUnitProm) {
		this.precoUnitProm = precoUnitProm;
	}

	public int getQtdDisponivelProm() {
		return qtdDisponivelProm;
	}

	public void setQtdDisponivelProm(int qtdDisponivelProm) {
		this.qtdDisponivelProm = qtdDisponivelProm;
	}


	public LocalTime getDuracao() {
		return duracao;
	}

	public void setDuracao(LocalTime duracao) {
		this.duracao = duracao;
	}

	public BigDecimal getPrecoAnteriorProm() {
		return precoAnteriorProm;
	}

	public void setPrecoAnteriorProm(BigDecimal precoAnteriorProm) {
		this.precoAnteriorProm = precoAnteriorProm;
	}

	
	
	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public Promocao() {
	}

	public Promocao(Long id, String nomeDestinoProm, String categoriaDestinoProm, String condicaoProm,
			LocalDate dataIdaProm, LocalDate dataChegadaProm, LocalTime horaIdaProm, LocalTime horaChegadaProm,
			LocalTime duracao, BigDecimal precoUnitProm, BigDecimal precoAnteriorProm, int qtdDisponivelProm,
			byte[] imagem) {
		super();
		this.id = id;
		this.nomeDestinoProm = nomeDestinoProm;
		this.categoriaDestinoProm = categoriaDestinoProm;
		this.condicaoProm = condicaoProm;
		this.dataIdaProm = dataIdaProm;
		this.dataChegadaProm = dataChegadaProm;
		this.horaIdaProm = horaIdaProm;
		this.horaChegadaProm = horaChegadaProm;
		this.duracao = duracao;
		this.precoUnitProm = precoUnitProm;
		this.precoAnteriorProm = precoAnteriorProm;
		this.qtdDisponivelProm = qtdDisponivelProm;
		this.imagem = imagem;
	}

	@Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((nomeDestinoProm == null) ? 0 : nomeDestinoProm.hashCode());
	        result = prime * result + ((id == null) ? 0 : id.hashCode());
	        result = prime * result + ((categoriaDestinoProm == null) ? 0 : categoriaDestinoProm.hashCode());
	        result = prime * result + ((condicaoProm == null) ? 0 : condicaoProm.hashCode());
	        result = prime * result + ((dataIdaProm == null) ? 0 : dataIdaProm.hashCode());
	        result = prime * result + ((dataChegadaProm == null) ? 0 : dataChegadaProm.hashCode());
	        result = prime * result + ((horaIdaProm == null) ? 0 : horaIdaProm.hashCode());
	        result = prime * result + ((horaChegadaProm == null) ? 0 : horaChegadaProm.hashCode());
	        result = prime * result + ((precoUnitProm == null) ? 0 : precoUnitProm.hashCode());
	        result = prime * result + ((precoAnteriorProm == null) ? 0 : precoAnteriorProm.hashCode());
	        result = prime * result + ((duracao == null) ? 0 : duracao.hashCode());
	        return result;
	    }
	 
	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        Promocao other = (Promocao) obj;
	        if (nomeDestinoProm == null) {
	            if (other.nomeDestinoProm != null)
	                return false;
	        } else if (!nomeDestinoProm.equals(other.nomeDestinoProm))
	            return false;
	        if (id == null) {
	            if (other.id != null)
	                return false;
	        } else if (!id.equals(other.id))
	            return false;
	        if (condicaoProm == null) {
	            if (other.condicaoProm != null)
	                return false;
	        } else if (!condicaoProm.equals(other.condicaoProm))
	            return false;
	        if (categoriaDestinoProm == null) {
	            if (other.categoriaDestinoProm != null)
	                return false;
	        } else if (!categoriaDestinoProm.equals(other.categoriaDestinoProm))
	            return false;
	        if (horaIdaProm == null) {
	            if (other.horaIdaProm != null)
	                return false;
	        } else if (!horaIdaProm.equals(other.horaIdaProm))
	            return false;
	        if (horaChegadaProm == null) {
	            if (other.horaChegadaProm != null)
	                return false;
	        } else if (!horaChegadaProm.equals(other.horaChegadaProm))
	            return false;
	        if (dataChegadaProm == null) {
	            if (other.dataChegadaProm != null)
	                return false;
	        } else if (!dataChegadaProm.equals(other.dataChegadaProm))
	            return false;
	        if (dataIdaProm == null) {
	            if (other.dataIdaProm != null)
	                return false;
	        } else if (!dataIdaProm.equals(other.dataIdaProm))
	            return false;
	        if (precoUnitProm == null) {
	            if (other.precoUnitProm != null)
	                return false;
	        } else if (!precoUnitProm.equals(other.precoUnitProm))
	            return false;
	        if (precoAnteriorProm == null) {
	            if (other.precoAnteriorProm != null)
	                return false;
	        } else if (!precoAnteriorProm.equals(other.precoAnteriorProm))
	            return false;
	        if (duracao == null) {
	            if (other.duracao != null)
	                return false;
	        } else if (!duracao.equals(other.duracao))
	            return false;
	        return true;
	    }

		@Override
		public String toString() {
			return "Promocao [id=" + id + ", nomeDestinoProm=" + nomeDestinoProm + ", categoriaDestinoProm="
					+ categoriaDestinoProm + ", condicaoProm=" + condicaoProm + ", dataIdaProm=" + dataIdaProm
					+ ", dataChegadaProm=" + dataChegadaProm + ", horaIdaProm=" + horaIdaProm + ", horaChegadaProm="
					+ horaChegadaProm + ", duracao=" + duracao + ", precoUnitProm=" + precoUnitProm
					+ ", precoAnteriorProm=" + precoAnteriorProm + ", qtdDisponivelProm=" + qtdDisponivelProm
					+ ", imagem=" + Arrays.toString(imagem) + "]";
		}




	
	
	
}
