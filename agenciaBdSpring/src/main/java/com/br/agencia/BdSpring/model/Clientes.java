package com.br.agencia.BdSpring.model;

import java.time.LocalDate;
import java.util.List;



import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.br.agencia.BdSpring.model.Clientes;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeCliente;

    @Column(nullable = false, name = "data_nascimento")
    @DateTimeFormat(iso = ISO.DATE, pattern = "dd-MM-yyyy")
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String cpf;
    
    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String senha;

    
    @OneToMany(mappedBy = "clientes", fetch = FetchType.LAZY)
    private List<Reservas> reservas;   
    
    
    public List<Reservas> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reservas> reservas) {
		this.reservas = reservas;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getNomeCliente() {
		return nomeCliente;
	}


	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}


	public LocalDate getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Clientes() {
    }

 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nomeCliente == null) ? 0 : nomeCliente.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((senha == null) ? 0 : senha.hashCode());
        result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
        Clientes other = (Clientes) obj;
        if (dataNascimento == null) {
            if (other.dataNascimento != null)
                return false;
        } else if (!dataNascimento.equals(other.dataNascimento))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nomeCliente == null) {
            if (other.nomeCliente != null)
                return false;
        } else if (!nomeCliente.equals(other.nomeCliente))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (senha == null) {
            if (other.senha != null)
                return false;
        } else if (!senha.equals(other.senha))
            return false;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        if (telefone == null) {
            if (other.telefone != null)
                return false;
        } else if (!telefone.equals(other.telefone))
            return false;
        
        return true;
    }

	public Clientes(Long id, String nomeCliente, LocalDate dataNascimento, String email, String cpf, String telefone,
			String senha) {
		super();
		this.id = id;
		this.nomeCliente = nomeCliente;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Clientes [id=" + id + ", nomeCliente=" + nomeCliente + ", dataNascimento=" + dataNascimento + ", email="
				+ email + ", cpf=" + cpf + ", telefone=" + telefone + ", senha=" + senha + "]";
	}


    
}
