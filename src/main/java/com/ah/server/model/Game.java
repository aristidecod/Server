package com.ah.server.model;

import java.util.Date;
import javax.persistence.*;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user1;

    @ManyToOne
    private User user2;

    @Temporal(TemporalType.TIMESTAMP)
    private Date heureDebut;

    @Temporal(TemporalType.TIMESTAMP)
    private Date heureFin;

    private String resultat;

    public Game() {
    }

    public Game(User user1, User user2, Date heureDebut, Date heureFin, String resultat) {
        this.user1 = user1;
        this.user2 = user2;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.resultat = resultat;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public User getUser1() {
        return user1;
    }

    public User getUser2() {
        return user2;
    }

    public Date getHeureDebut() {
        return heureDebut;
    }

    public Date getHeureFin() {
        return heureFin;
    }

    public String getResultat() {
        return resultat;
    }

    public void setHeureDebut(Date heureDebut) {
        this.heureDebut = heureDebut;
    }

    public void setHeureFin(Date heureFin) {
        this.heureFin = heureFin;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }
}

