package br.com.codekaffe.MusicasApi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "musicas")
public class Musica {

    @Id
    private String id;
    private String nomeMusica;

    private String duracao;

    private List<String> compositores;


    public String getId() {
        return id;
    }


    public String getNomeMusica() {
        return nomeMusica;
    }

    public void setNomeMusica(String nomeMusica) {
        this.nomeMusica = nomeMusica;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public List<String> getCompositores() {
        return compositores;
    }

    public void setCompositores(List<String> compositores) {
        this.compositores = compositores;
    }
}
