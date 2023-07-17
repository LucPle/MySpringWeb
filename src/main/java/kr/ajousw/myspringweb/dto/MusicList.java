package kr.ajousw.myspringweb.dto;

import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class MusicList {
    private Integer resultCount;
    private List<Map<String, Object>> results;
}