package br.com.codekaffe.MusicasApi.controllers;


import br.com.codekaffe.MusicasApi.models.Album;
import br.com.codekaffe.MusicasApi.models.Musica;
import br.com.codekaffe.MusicasApi.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MusicaController {

    @Autowired
    private MusicaRepository musicaRepository;

    @RequestMapping(method = RequestMethod.GET,value = "/api/albuns")
    public List<Album> getAll(){
        return musicaRepository.getAllAlbuns();
    }


    @RequestMapping(method = RequestMethod.POST, value = "/api/albuns/newAlbum")
    public String addAlbum(@Valid @RequestBody Album album){
        if(album.getEstiloMusical().equals("Funk") || album.getEstiloMusical().equals("Sertanejo Universitário")){
            return "Estilo Musical Inválido";
        }

        musicaRepository.save(album);
        return "Album Adicionado com sucesso";
    }


    @RequestMapping(method = RequestMethod.GET, value ="/api/albuns/{id}")
    public Album getAlbumById(@PathVariable String id){
        return musicaRepository.getAlbumById(id);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/api/albuns/{id}")
    public String updateAlbum(@PathVariable String id, @Valid @RequestBody Album album){
        if(album.getEstiloMusical().equals("Funk") || album.getEstiloMusical().equals("Sertanejo Universitário")){
            return "Estilo Musical Inválido";
        }

        Album albumVelho = musicaRepository.getAlbumById(id);
        albumVelho.setArtista(album.getArtista());
        albumVelho.setEstiloMusical(album.getEstiloMusical());
        albumVelho.setNomeDoAlbum(album.getNomeDoAlbum());

        musicaRepository.save(albumVelho);

        return "Album Atualizado com sucesso";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/albuns/{id}")
    public String deleteAlbum(@PathVariable String id){
        Album album =  musicaRepository.getAlbumById(id);
        musicaRepository.delete(album);
        return "Album deletado com sucesso";
    }


    @RequestMapping(method = RequestMethod.POST,value = "/api/albuns/{id}/musicas")
    public String adicionarMusicas(@PathVariable String id, @Valid @RequestBody Musica musica){
        Album album = musicaRepository.getAlbumById(id);
        album.adicionarMusica(musica);
        musicaRepository.save(album);
        return "Musica Adicionada com sucesso";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/albuns/search")
    public List<Album> procurarAlbuns(@RequestParam String search){
        if(search.equals("")){
            return new ArrayList<>();
        }

        List<Album> albuns = musicaRepository.getAllAlbuns();
        return albuns.stream().filter(album -> album.getNomeDoAlbum().contains(search)).collect(Collectors.toList());
    }

}
