package com.ah.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stats")
public class Stats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identifiant unique pour chaque Stats
    private Integer xp;
    private Integer level;
    private Integer coins;
    private Integer gems;
    private Long userId; // Supposons que cela représente la relation avec l'utilisateur

    // Constructeur sans arguments
    public Stats() {}

    // Constructeur avec tous les arguments
    public Stats(Integer xp, Integer level, Integer coins, Integer gems, Long userId) {
        this.xp = xp;
        this.level = level;
        this.coins = coins;
        this.gems = gems;
        this.userId = userId;
    }

    // Getters et setters pour tous les champs
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public Integer getGems() {
        return gems;
    }

    public void setGems(Integer gems) {
        this.gems = gems;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

