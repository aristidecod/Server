package com.ah.server.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Embeddable;

@Entity
@Table(name = "usercards")
public class UserCards {

    @EmbeddedId
    private UserCardId id = new UserCardId();
    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("cardId")
    @JoinColumn(name = "card_id")
    private Card card;

    private Integer quantity;

    public UserCards(User user, Card card, Integer quantity) {
        this.user = user;
        this.card = card;
        this.quantity = quantity;
        this.id.userId = user.getId();
        this.id.cardId = card.getId();
    }

    public UserCardId getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setId(UserCardId id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Embeddable
    public static class UserCardId implements java.io.Serializable {
        @Column(name = "user_id")
        private Long userId;

        @Column(name = "card_id")
        private Long cardId;

        public UserCardId() {}

        public UserCardId(Long userId, Long cardId) {
            this.userId = userId;
            this.cardId = cardId;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public Long getCardId() {
            return cardId;
        }

        public void setCardId(Long cardId) {
            this.cardId = cardId;
        }
    }
}
