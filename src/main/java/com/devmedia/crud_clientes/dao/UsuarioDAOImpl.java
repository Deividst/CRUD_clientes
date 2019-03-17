package com.devmedia.crud_clientes.dao;

import com.devmedia.crud_clientes.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

    private static List<Usuario> us;

    public UsuarioDAOImpl() {
        createUserToList();
    }

    private List<Usuario> createUserToList() {
        if (us == null){
            us = new LinkedList<>();
            us.add(new Usuario(System.currentTimeMillis()+1L, "Ana", "da Silva"));
            us.add(new Usuario(System.currentTimeMillis()+2L, "Luiz", "dos Santos"));
            us.add(new Usuario(System.currentTimeMillis()+3L, "Mariana", "Mello"));
            us.add(new Usuario(System.currentTimeMillis()+4L, "Caren", "Pereira"));
            us.add(new Usuario(System.currentTimeMillis()+5L, "Sonia", "Fagundes"));
            us.add(new Usuario(System.currentTimeMillis()+6L, "Norberto", "de Souza"));
        }

        return us;
    }

    @Override
    public void salvar(Usuario usuario) {
        usuario.setId(System.currentTimeMillis());
        us.add(usuario);
    }

    @Override
    public void editar(Usuario usuario) {
        us.stream()
                .filter(u -> u.getId().equals(usuario.getId()))
                .forEach( u -> {
                    u.setNome(usuario.getNome());
                    u.setSobreNome(usuario.getSobreNome());
                });
    }

    @Override
    public void excluir(Long id) {
        us.removeIf(u -> u.getId().equals(id));
    }

    @Override
    public Usuario getId(Long id) {
        return us.stream()
                .filter( u -> u.getId().equals(id))
                .collect(Collectors.toList()).get(0);
    }

    @Override
    public List<Usuario> getAll() {
        return us;
    }
}
