package com.bruno.listmusic.listMusic.dao;

import com.bruno.listmusic.listMusic.domain.Musica;

import java.util.List;

public interface MusicaDao {

    void salvar (Musica musica);
    List<Musica> recuperarPorPlaylist (long playlistId);
    Musica recuperarPorPlaylistIdeMusicaId(long playlistId , long musicaId);
    void atualizar (Musica musica);
    void excluir (Long musicaId);
}
