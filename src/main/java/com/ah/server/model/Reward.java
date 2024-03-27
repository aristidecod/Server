package com.ah.server.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@Entity
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RewardObject> rewardObjects;

    public Reward(List<RewardObject> rewardObjects) {
        this.rewardObjects = rewardObjects;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<RewardObject> getRewardObjects() {
        return rewardObjects;
    }

    public void setRewardObjects(List<RewardObject> rewardObjects) {
        this.rewardObjects = rewardObjects;
    }
}
