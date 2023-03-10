package io.github.deyvidsantos.crud.dto;

import io.github.deyvidsantos.crud.domain.Livro;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

public class LivroDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Campo NOME é requerido")
    @Length(min = 3, max = 100, message = "O campo NOME deve ter entre 3 e 100 caracteres")
    private String nome;

    public LivroDTO() {
        super();
    }

    public LivroDTO(Livro obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
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
}
