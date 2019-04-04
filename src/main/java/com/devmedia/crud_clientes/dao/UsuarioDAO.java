package com.devmedia.crud_clientes.dao;

import com.devmedia.crud_clientes.model.TipoSexo;
import com.devmedia.crud_clientes.model.Usuario;

import java.util.List;

public interface UsuarioDAO {

    void salvar(Usuario usuario);
    void editar(Usuario usuario);
    void excluir(Long id);
    Usuario getId(Long id);
    List<Usuario> getAll();
    List<Usuario> getBySexo(TipoSexo sexo);
    List<Usuario> getByNome(String nome);
}
