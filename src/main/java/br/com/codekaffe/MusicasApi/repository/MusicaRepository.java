package br.com.codekaffe.MusicasApi.repository;

import br.com.codekaffe.MusicasApi.models.Album;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MusicaRepository extends MongoRepository<Album, String> {
    @Query("{}")
    List<Album> getAllAlbuns();

    Album getAlbumById(String id);

}
