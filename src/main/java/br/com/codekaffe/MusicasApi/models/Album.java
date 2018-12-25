package br.com.codekaffe.MusicasApi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "albuns")
public class Album {
    @Id
    private String id;

    private String artista;
    private String estiloMusical;

    private String nomeDoAlbum;
    private List<Musica> musicas = new ArrayList<>();

    public Album(String artista,String nomeDoAlbum,List<Musica> musicas){
        this.artista = artista;
        this.nomeDoAlbum = nomeDoAlbum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getEstiloMusical() {
        return estiloMusical;
    }

    public void setEstiloMusical(String estiloMusical) {
        this.estiloMusical = estiloMusical;
    }

    public String getNomeDoAlbum() {
        return nomeDoAlbum;
    }

    public void setNomeDoAlbum(String nomeDoAlbum) {
        this.nomeDoAlbum = nomeDoAlbum;
    }


    public List<Musica> getMusicas() {
        return musicas;
    }

    public void adicionarMusica(Musica musica){
        this.musicas.add(musica);
    }

}
