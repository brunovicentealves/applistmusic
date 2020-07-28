package com.bruno.listmusic.listMusic.domain;


import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "musicas")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;


    @Size(min = 2,max = 50)
    @Column(nullable = false,length = 50)
    private String titulo;

    @Size(min = 2,max = 50)
    @Column(nullable = false,length = 50)
    private  String banda;

    @Range(min = 0,max = 10)
    @Column(nullable = false)
    private int nota;

    @ManyToOne
    @JoinColumn(name = "id_playlist_fk")
    private Playlist playlist;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }
}
