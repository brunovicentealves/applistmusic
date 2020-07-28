package com.bruno.listmusic.listMusic.service;

import com.bruno.listmusic.listMusic.domain.Musica;

import java.util.List;

public interface MusicaService {

    void salvar(Musica musica , long playListId);
    List<Musica>  recuperarPorPlayList(long playListId);
    Musica recuperarPorPlaylistIdEMusicaId (long playListId , long musicaId);
    void atualizar (Musica musica , Long playListId);
    void excluir (long playlistId , long musicaId);


}
