/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.otheatre.entities;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Marius Herta <marius.herta@gmail.com>
 */
@Entity
@Table(name = "user_profile")
public class UserProfile{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userProfileId;
    
    @OneToOne
    private User user;
    
    private String bio;
    
    private String email;
    
    private String firstName;
    
    private String lastName;
    
    private LocalDate birthday;
    
    private String linkToProfilePicture;
    
    @ManyToMany(mappedBy = "participants")
    private List<Event> eventsAttended;
    
    @OneToMany
    private List<Review>reviews;
    
    @OneToMany
    private List<Comment>comments;

    public UserProfile() {
    }

    public UserProfile(User user, String bio, String email, String firstName, String lastName, LocalDate birthday, String linkToProfilePicture, List<Event> eventsAttended, List<Review> reviews, List<Comment> comments) {
        this.user = user;
        this.bio = bio;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.linkToProfilePicture = linkToProfilePicture;
        this.eventsAttended = eventsAttended;
        this.reviews = reviews;
        this.comments = comments;
    }

    public Integer getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(Integer userProfileId) {
        this.userProfileId = userProfileId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getLinkToProfilePicture() {
        return linkToProfilePicture;
    }

    public void setLinkToProfilePicture(String linkToProfilePicture) {
        this.linkToProfilePicture = linkToProfilePicture;
    }

    public List<Event> getEventsAttended() {
        return eventsAttended;
    }

    public void setEventsAttended(List<Event> eventsAttended) {
        this.eventsAttended = eventsAttended;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return firstName;
    }
}
