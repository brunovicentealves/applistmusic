package com.bruno.listmusic.listMusic.service;

import com.bruno.listmusic.listMusic.dao.MusicaDao;
import com.bruno.listmusic.listMusic.domain.Musica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class MusicaServiceImpl implements MusicaService {

    @Autowired
    private MusicaDao musicaDao ;
    @Autowired
    private PlayListService playListService;

    @Override
    public void salvar(Musica musica, long playListId) {
        musica.setPlaylist(playListService.recuperarPorId(playListId));
        musicaDao.salvar(musica);
    }

    @Override
    public List<Musica> recuperarPorPlayList(long playListId) {
        return musicaDao.recuperarPorPlaylist(playListId);    }

    @Override
    public Musica recuperarPorPlaylistIdEMusicaId(long playListId, long musicaId) {
        return musicaDao.recuperarPorPlaylistIdeMusicaId(playListId,musicaId);
    }


    @Override
    public void atualizar(Musica musica, Long playListId) {
        musica.setPlaylist(playListService.recuperarPorId(playListId));
        musicaDao.atualizar(musica);
    }

    @Override
    public void excluir(long playlistId, long musicaId) {
        musicaDao.excluir(recuperarPorPlaylistIdEMusicaId(playlistId,musicaId).getId());
    }
}
