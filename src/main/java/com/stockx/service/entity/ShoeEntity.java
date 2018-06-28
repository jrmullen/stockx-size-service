package com.stockx.service.entity;

import javax.persistence.*;

@Entity
@Table(name = "shoe")
public class ShoeEntity {
    private int id;
    private String display;
    private String key;
    private Integer trueToSizeScore;

    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Basic
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Basic
    @Column(name = "true_to_size_score")
    public Integer getTrueToSizeScore() {
        return trueToSizeScore;
    }

    public void setTrueToSizeScore(Integer trueToSizeScore) {
        this.trueToSizeScore = trueToSizeScore;
    }
}
