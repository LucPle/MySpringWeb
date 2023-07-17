package kr.ajousw.myspringweb.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import kr.ajousw.myspringweb.entity.FavoriteMusic;

public interface FavoriteRepository extends
        JpaRepository<FavoriteMusic, String> {
    List<FavoriteMusic> findAll();

    void deleteById(String id);
}