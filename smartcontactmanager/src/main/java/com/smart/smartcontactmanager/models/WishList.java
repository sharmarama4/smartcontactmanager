package com.smart.smartcontactmanager.models;

import javax.persistence.*;
import java.util.Date;


    @Entity
    @Table(name = "wishlist")
    public class WishList {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
        @JoinColumn(name = "user_id")
        private User user;

        @Column(name = "created_date")
        private Date createdDate;

        @OneToOne
        @JoinColumn(name = "product_id")
        private Product product;

        public WishList() {
        }

        public WishList(Integer id, User user, Date createdDate, Product product) {
            this.id = id;
            this.user = user;
            this.createdDate = createdDate;
            this.product = product;
        }

        public WishList(User user, Product product) {
            this.user = user;
            this.product = product;
            this.createdDate = new Date();
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

    }
