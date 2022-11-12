package com.smart.smartcontactmanager.models;

import javax.persistence.*;


    @Entity
    @Table(name="cart_Items")
    public class CartItem {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        @ManyToOne
        @JoinColumn(name="product_id")
        private Product Product;
        @ManyToOne
        @JoinColumn(name="user_id")
        private User User;
        private int quantity;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Product getProduct() {
            return Product;
        }

        public void setProduct(Product product) {
            Product = product;
        }

        public com.smart.smartcontactmanager.models.User getUser() {
            return User;
        }

        public void setUser(com.smart.smartcontactmanager.models.User user) {
            User = user;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }


