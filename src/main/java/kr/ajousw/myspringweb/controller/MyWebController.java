package kr.ajousw.myspringweb.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.ajousw.myspringweb.dto.MusicList;

@RestController
public class MyWebController {

    @GetMapping(value = "/musicSearch/{term}")
    public MusicList musicSearchByPath(@PathVariable String term) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            String url = String.format("https://itunes.apple.com/search?term=%s&entity=album", term);
            System.out.println(url);
            String response = restTemplate.getForObject(url, String.class);
            ObjectMapper mapper = new ObjectMapper();
            MusicList list = mapper.readValue(response, MusicList.class);

            System.out.println(list.getResultCount());
            return list;

        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return null;
    }

    @GetMapping(value = "/musicSearch")
    public MusicList musicSearchByParam(@RequestParam String term) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            String url = String.format("https://itunes.apple.com/search?term=%s&entity=album", term);
            System.out.println(url);
            String response = restTemplate.getForObject(url, String.class);
            ObjectMapper mapper = new ObjectMapper();
            MusicList list = mapper.readValue(response, MusicList.class);

            System.out.println(list.getResultCount());
            return list;

        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return null;
    }
}
