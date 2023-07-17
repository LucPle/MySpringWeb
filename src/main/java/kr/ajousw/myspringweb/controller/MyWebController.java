package kr.ajousw.myspringweb.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;
import kr.ajousw.myspringweb.dto.FavoriteMusicRequestDto;
import kr.ajousw.myspringweb.dto.MusicList;
import kr.ajousw.myspringweb.entity.FavoriteMusic;
import kr.ajousw.myspringweb.repository.FavoriteRepository;
import kr.ajousw.myspringweb.service.MusicService;

@RestController

public class MyWebController {

    @Autowired
    MusicService service;

    @GetMapping(value = "/musicSearch/{name}")

    public MusicList musicSearchByPath(@PathVariable String name) {
        return service.searchMusic(name);
    }

    @GetMapping(value = "/musicSearch")
    public MusicList musicSearchByParam(@RequestParam(value = "term") String name) {
        return service.searchMusic(name);
    }

    @GetMapping(value = "/likes") // Get Favorite Music list from Database
    public List<FavoriteMusic> getLikes() {
        return service.getLikes();
    }

    @PostMapping(value = "/likes")
    public int postLikes(@RequestBody FavoriteMusicRequestDto favorite) {
        return service.saveFavorite(favorite);
    }

    @DeleteMapping(value = "/likes/{id}")
    public void deleteLikes(@PathVariable String id) {
        service.deleteFavorite(id);
    }
}

/*
 * curl -X POST http://localhost:8098/likes -d '@postSong.json' -H
 * "Content-Type:application/json"
 * Invoke-WebRequest -Uri "http://localhost:8098/likes" -Method POST -InFile
 * 'postSong.json' -ContentType "application/json"
 */

// @RestController
// public class MyWebController {

// @GetMapping(value = "/musicSearch/{term}")
// public MusicList musicSearchByPath(@PathVariable String term) {
// RestTemplate restTemplate = new RestTemplate();
// try {
// String url =
// String.format("https://itunes.apple.com/search?term=%s&entity=album", term);
// System.out.println(url);
// String response = restTemplate.getForObject(url, String.class);
// ObjectMapper mapper = new ObjectMapper();
// MusicList list = mapper.readValue(response, MusicList.class);

// System.out.println(list.getResultCount());
// return list;

// } catch (IOException e) {
// System.out.println(e.toString());
// }
// return null;
// }

// @GetMapping(value = "/musicSearch")
// public MusicList musicSearchByParam(@RequestParam String term) {
// RestTemplate restTemplate = new RestTemplate();
// try {
// String url =
// String.format("https://itunes.apple.com/search?term=%s&entity=album", term);
// System.out.println(url);
// String response = restTemplate.getForObject(url, String.class);
// ObjectMapper mapper = new ObjectMapper();
// MusicList list = mapper.readValue(response, MusicList.class);

// System.out.println(list.getResultCount());
// return list;

// } catch (IOException e) {
// System.out.println(e.toString());
// }
// return null;
// }

// @Autowired
// FavoriteRepository albumsRepo;

// @GetMapping(value = "/likes")
// public List<FavoriteMusic> getLikes() {
// try {
// return albumsRepo.findAll();
// } catch (Exception e) {
// System.out.println(e.toString());
// return null;
// }

// }

// @PostMapping(value = "/likes")
// @Transactional
// public int postLikes(@RequestBody FavoriteMusicRequestDto favorite) {
// FavoriteMusic music = albumsRepo.save(favorite.toEntity());
// if (music != null) {
// return 1;
// } else {
// return 0;
// }
// }
// }
