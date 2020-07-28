package com.bruno.listmusic.listMusic.service;

import com.bruno.listmusic.listMusic.domain.Playlist;

import java.util.List;

public interface PlayListService {

    void salvar(Playlist playlist);
    List<Playlist> recuperar();
    Playlist recuperarPorId(long id);
    void atualizar (Playlist playlist);
    void excluir(long id);



}
