package io.github.deyvidsantos.crud.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "tbl_categoria")
public class Categoria implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "Campo NOME é requerido.")
	@Length(min = 3, max = 100, message = "O campo NOME deve ter entre 3 e 100 caracteres")
	@Column(name = "categoria_nome")
	private String nome;

	@NotEmpty(message = "Campo DESCRIÇÃO é requerido.")
	@Length(min = 3, max = 200, message = "O campo DESCRIÇÃO deve ter entre 3 e 200 caracteres")
	@Column(name = "categoria_descricao")
	private String descricao;
	
	@OneToMany(mappedBy = "categoria")
	private List<Livro> livros = new ArrayList<>();
	
	
	public Categoria() {
		super();
	}

	public Categoria(Integer id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome);
	}
	
	
	

	
	
	
	
	
}