package com.bruno.listmusic.listMusic.service;

import com.bruno.listmusic.listMusic.dao.PlaylistDao;
import com.bruno.listmusic.listMusic.domain.Playlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;
@Service
@Transactional
public class PlayListServiceImpl implements PlayListService {
    @Autowired
    private PlaylistDao playlistDao;

    @Override
    public void salvar(Playlist playlist) {
    playlistDao.salvar(playlist);
    }

    @Override
    public List<Playlist> recuperar() {
        return playlistDao.recuperar();
    }

    @Override
    public Playlist recuperarPorId(long id) {
        return playlistDao.recuperarPorID(id);
    }

    @Override
    public void atualizar(Playlist playlist) {
        playlistDao.atualizar(playlist);
    }

    @Override
    public void excluir(long id) {
        playlistDao.excluir(id);
    }
}
