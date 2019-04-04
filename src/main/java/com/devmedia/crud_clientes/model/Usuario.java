package com.devmedia.crud_clientes.model;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 2220746960113930799L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    @NotBlank
    @Size(min = 3, max = 50)
    private String nome;

    @Column(nullable = false, length = 50)
    @NotBlank
    @Size(min = 3, max = 50, message = "Campo Requerido entre {min} e {max} caracteres.")
    private String sobreNome;

    @Column(name = "data_nascimento", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "O campo data de nascimento é requerido.")
    private LocalDate dtNascimento;

    @Column(name = "tipo_sexo", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoSexo sexo;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public TipoSexo getSexo() {
        return sexo;
    }

    public void setSexo(TipoSexo sexo) {
        this.sexo = sexo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
