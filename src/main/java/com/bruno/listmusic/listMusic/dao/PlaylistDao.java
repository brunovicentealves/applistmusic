package com.bruno.listmusic.listMusic.dao;

import com.bruno.listmusic.listMusic.domain.Playlist;

import java.util.List;

public interface PlaylistDao {

    void salvar (Playlist playlist);
    List<Playlist> recuperar();
    Playlist recuperarPorID (long id);
    void atualizar (Playlist playlist);
    void excluir (Long id);

}
