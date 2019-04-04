package com.devmedia.crud_clientes.dao;

import com.devmedia.crud_clientes.model.TipoSexo;
import com.devmedia.crud_clientes.model.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class UsuarioDAOImpl implements UsuarioDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void salvar(Usuario usuario) {
        entityManager.persist(usuario);
    }

    @Override
    public void editar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public void excluir(Long id) {
        entityManager.remove(entityManager.getReference(Usuario.class, id));
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario getId(Long id) {
        String jpql = "from Usuario u where u.id = :id";
        TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> getAll() {
        String jpql = "from Usuario u";
        TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> getBySexo(TipoSexo sexo) {
        String jpql = "from Usuario u where u.sexo = :sexo";
        TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
        query.setParameter("sexo", sexo);
        return query.getResultList();
    }

    @Override
    public List<Usuario> getByNome(String nome) {
        String jpql = "from Usuario u where u.nome like :nome or sobreNome like :sobreNome";
        TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
        query.setParameter("nome", "%" + nome + "%");
        query.setParameter("sobreNome", "%" + nome + "%");
        return query.getResultList();
    }
}
