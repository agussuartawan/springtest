package com.domain.models.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class User implements Serializable{

        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Long id;

        @NotEmpty(message = "Name is required.")
        private String name;

        @NotEmpty(message = "Email is required.")
        private String email;

        @NotEmpty(message = "Gender is required.")
        @Column(length = 10)
        private String gender;

        @NotEmpty(message = "Password is required.")
        private String password;

        public Long getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public String getEmail() {
                return email;
        }

        public String getGender() {
                return gender;
        }

        public String getPassword() {
                return password;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public void setName(String name) {
                this.name = name;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public void setGender(String gender) {
                this.gender = gender;
        }

        public void setPassword(String password) {
                this.password = password;
        }
}
