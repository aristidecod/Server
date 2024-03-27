package com.ah.server.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "session_id")
    private List<Game> games; // Les parties jouées pendant cette session

    @Temporal(TemporalType.TIMESTAMP)
    private Date heureDebut; // Quand la session a commencé

    @Temporal(TemporalType.TIMESTAMP)
    private Date heureFin; // Quand la session s'est terminée

    public Session() {
    }

    // Constructeur avec des paramètres
    public Session( Date heureDebut, Date heureFin) {
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.games = new ArrayList<>();
    }

    // Getters
    public Long getId() {
        return id;
    }

    public List<Game> getGames() {
        return games;
    }

    public Date getHeureDebut() {
        return heureDebut;
    }

    public Date getHeureFin() {
        return heureFin;
    }

    public void addGame(Game game) {
        games.add(game);
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public void setHeureDebut(Date heureDebut) {
        this.heureDebut = heureDebut;
    }

    public void setHeureFin(Date heureFin) {
        this.heureFin = heureFin;
    }

    public void removeGame(Game game) {
        games.remove(game);
    }
}
