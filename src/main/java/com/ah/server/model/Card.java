package com.ah.server.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import com.ah.server.model.Rarete;
import com.ah.server.model.Type;


@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    private String description;

    @Enumerated(EnumType.STRING)
        private Rarete rarete;

    @Enumerated(EnumType.STRING)
    private Type type;

    private Integer degats;

    @Column(name = "points_de_vie")
    private Integer pointsDeVie;

    @Column(name = "cout_en_elixir")
    private Integer coutEnElixir;

    public Card(String nom, String description, Rarete rarete, Type type, Integer degats, Integer pointsDeVie, Integer coutEnElixir) {
        this.nom = nom;
        this.description = description;
        this.rarete = rarete;
        this.type = type;
        this.degats = degats;
        this.pointsDeVie = pointsDeVie;
        this.coutEnElixir = coutEnElixir;
    }

    public Card(){
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public Rarete getRarete() {
        return rarete;
    }

    public Type getType() {
        return type;
    }

    public Integer getDegats() {
        return degats;
    }

    public Integer getPointsDeVie() {
        return pointsDeVie;
    }

    public Integer getCoutEnElixir() {
        return coutEnElixir;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRarete(Rarete rarete) {
        this.rarete = rarete;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setDegats(Integer degats) {
        this.degats = degats;
    }

    public void setPointsDeVie(Integer pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    public void setCoutEnElixir(Integer coutEnElixir) {
        this.coutEnElixir = coutEnElixir;
    }
}

