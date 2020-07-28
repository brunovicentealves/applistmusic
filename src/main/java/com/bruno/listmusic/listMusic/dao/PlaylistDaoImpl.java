package com.bruno.listmusic.listMusic.dao;

import com.bruno.listmusic.listMusic.domain.Playlist;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PlaylistDaoImpl implements PlaylistDao {
    @PersistenceContext
    private EntityManager em ;

    @Override
    public void salvar(Playlist playlist) {
        em.persist(playlist);
    }

    @Override
    public List<Playlist> recuperar() {
        return em.createQuery("Select p from Playlist p ",Playlist.class).getResultList();
    }

    @Override
    public Playlist recuperarPorID(long id) {
        return em.find(Playlist.class,id);
    }

    @Override
    public void atualizar(Playlist playlist) {
     em.merge(playlist);
    }

    @Override
    public void excluir(Long id) {
        em.remove(em.getReference(Playlist.class,id));
    }
}
