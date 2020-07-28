package com.bruno.listmusic.listMusic.domain;


<<<<<<< HEAD
import javafx.util.Builder;

=======
>>>>>>> 8e4fc529b4fc91ee6a4db0dec83d3893f5e9d480
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    @Size(min = 2,max = 60)
    @Column(nullable = false, length = 60)
    private String nome;

    @Size(min = 2,max = 60)
    @Column(nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "playlist",cascade = CascadeType.ALL)
    private List<Musica> musicas;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
<<<<<<< HEAD

    @Override
    public String toString() {
        return "City{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + '}';
    }
=======
>>>>>>> 8e4fc529b4fc91ee6a4db0dec83d3893f5e9d480
}
