package kr.ajousw.myspringweb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "favoriteMusic")
@Getter
@Setter
@ToString

public class FavoriteMusic {
    @Id
    @Column(length = 32)
    private String collectionId;
    @Column
    private String collectionType;
    @Column
    private String artistId;
    @Column
    private String artistName;
    @Column
    private String artistViewUrl;
    @Column
    private String collectionName;
    @Column
    private String collectionViewUrl;
}
