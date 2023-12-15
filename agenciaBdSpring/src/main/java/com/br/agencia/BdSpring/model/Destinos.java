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
public class Destinos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	

	@Column(nullable = false, length = 80)
    private String nomeDestino;

    @Column(nullable = false, length = 14)
    private String categoriaDestino;

    @Column(nullable = false, length = 15)
    private String condicao;

    @Column(name = "data_ida", nullable = false)
    @DateTimeFormat(iso = ISO.DATE, pattern = "dd-MM-yyyy")
    private LocalDate dataIda;     

    @Column(name = "data_chegada", nullable = false)
    @DateTimeFormat(iso = ISO.DATE, pattern = "dd-MM-yyyy")
    private LocalDate dataChegada;   
    
    @Column(name = "hora_ida", nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime horaIda; 
    
    @Column(name = "hora_chegada", nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime horaChegada;  
    
    @Column(nullable = false)
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal precoUnit;
    
    @Column(nullable = false, columnDefinition = "Integer")
    private int qtdDisponivel;
    
	@Column(columnDefinition = "longblob")
	private byte[] imagemDestino;

	@ManyToMany(mappedBy = "destinos", fetch = FetchType.LAZY)
    private List<Reservas> reservas;
//	@ManyToOne
//	@JoinColumn(name = "reservas_id")	    
//	private Reservas reservas;
	
	public String getNomeDestino() {
		return nomeDestino;
	}

	public void setNomeDestino(String nomeDestino) {
		this.nomeDestino = nomeDestino;
	}

	public String getCategoriaDestino() {
		return categoriaDestino;
	}

	public void setCategoriaDestino(String categoriaDestino) {
		this.categoriaDestino = categoriaDestino;
	}

	public String getCondicao() {
		return condicao;
	}

	public void setCondicao(String condicao) {
		this.condicao = condicao;
	}

	public LocalDate getDataIda() {
		return dataIda;
	}

	public void setDataIda(LocalDate dataIda) {
		this.dataIda = dataIda;
	}

	public LocalDate getDataChegada() {
		return dataChegada;
	}

	public void setDataChegada(LocalDate dataChegada) {
		this.dataChegada = dataChegada;
	}

	public LocalTime getHoraIda() {
		return horaIda;
	}

	public void setHoraIda(LocalTime horaIda) {
		this.horaIda = horaIda;
	}

	public LocalTime getHoraChegada() {
		return horaChegada;
	}

	public void setHoraChegada(LocalTime horaChegada) {
		this.horaChegada = horaChegada;
	}

	public BigDecimal getPrecoUnit() {
		return precoUnit;
	}

	public void setPrecoUnit(BigDecimal precoUnit) {
		this.precoUnit = precoUnit;
	}

	public int getQtdDisponivel() {
		return qtdDisponivel;
	}

	public void setQtdDisponivel(int qtdDisponivel) {
		this.qtdDisponivel = qtdDisponivel;
	}

	public byte[] getImagemDestino() {
		return imagemDestino;
	}

	public void setImagemDestino(byte[] imagemDestino) {
		this.imagemDestino = imagemDestino;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Reservas> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reservas> reservas) {
		this.reservas = reservas;
	}

	public Destinos(Long id, String nomeDestino, String categoriaDestino, String condicao, LocalDate dataIda,
			LocalDate dataChegada, LocalTime horaIda, LocalTime horaChegada, BigDecimal precoUnit, int qtdDisponivel,
			byte[] imagemDestino) {
		super();
		this.id = id;
		this.nomeDestino = nomeDestino;
		this.categoriaDestino = categoriaDestino;
		this.condicao = condicao;
		this.dataIda = dataIda;
		this.dataChegada = dataChegada;
		this.horaIda = horaIda;
		this.horaChegada = horaChegada;
		this.precoUnit = precoUnit;
		this.qtdDisponivel = qtdDisponivel;
		this.imagemDestino = imagemDestino;
	}

	public Destinos() {
		
	}
	
	 @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((nomeDestino == null) ? 0 : nomeDestino.hashCode());
	        result = prime * result + ((id == null) ? 0 : id.hashCode());
	        result = prime * result + ((categoriaDestino == null) ? 0 : categoriaDestino.hashCode());
	        result = prime * result + ((condicao == null) ? 0 : condicao.hashCode());
	        result = prime * result + ((dataIda == null) ? 0 : dataIda.hashCode());
	        result = prime * result + ((dataChegada == null) ? 0 : dataChegada.hashCode());
	        result = prime * result + ((horaIda == null) ? 0 : horaIda.hashCode());
	        result = prime * result + ((horaChegada == null) ? 0 : horaChegada.hashCode());
	        result = prime * result + ((precoUnit == null) ? 0 : precoUnit.hashCode());
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
	        Destinos other = (Destinos) obj;
	        if (nomeDestino == null) {
	            if (other.nomeDestino != null)
	                return false;
	        } else if (!nomeDestino.equals(other.nomeDestino))
	            return false;
	        if (id == null) {
	            if (other.id != null)
	                return false;
	        } else if (!id.equals(other.id))
	            return false;
	        if (condicao == null) {
	            if (other.condicao != null)
	                return false;
	        } else if (!condicao.equals(other.condicao))
	            return false;
	        if (categoriaDestino == null) {
	            if (other.categoriaDestino != null)
	                return false;
	        } else if (!categoriaDestino.equals(other.categoriaDestino))
	            return false;
	        if (horaIda == null) {
	            if (other.horaIda != null)
	                return false;
	        } else if (!horaIda.equals(other.horaIda))
	            return false;
	        if (horaChegada == null) {
	            if (other.horaChegada != null)
	                return false;
	        } else if (!horaChegada.equals(other.horaChegada))
	            return false;
	        if (dataChegada == null) {
	            if (other.dataChegada != null)
	                return false;
	        } else if (!dataChegada.equals(other.dataChegada))
	            return false;
	        if (dataIda == null) {
	            if (other.dataIda != null)
	                return false;
	        } else if (!dataIda.equals(other.dataIda))
	            return false;
	        if (precoUnit == null) {
	            if (other.precoUnit != null)
	                return false;
	        } else if (!precoUnit.equals(other.precoUnit))
	            return false;
	        return true;
	    }


	@Override
	public String toString() {
		return "Destinos [id=" + id + ", nomeDestino=" + nomeDestino + ", categoriaDestino=" + categoriaDestino
				+ ", condicao=" + condicao + ", dataIda=" + dataIda + ", dataChegada=" + dataChegada + ", horaIda="
				+ horaIda + ", horaChegada=" + horaChegada + ", precoUnit=" + precoUnit + ", qtdDisponivel="
				+ qtdDisponivel + ", imagemDestino=" + Arrays.toString(imagemDestino) + "]";
	}
	
	
}
