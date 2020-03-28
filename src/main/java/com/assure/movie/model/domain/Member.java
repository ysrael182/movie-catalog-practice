package com.assure.movie.model.domain;

import javax.persistence.*;

/**
 * @author Israel Yasis
 */
@Entity
@Table(name = "member")
public class Member implements Identifiable<Long> {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name", length = 25, nullable = false)
    private String userName;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "telephone", length = 50, nullable = false)
    private String telephone;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private MovieRental member;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MovieRental getMember() {
        return member;
    }

    public void setMember(MovieRental member) {
        this.member = member;
    }

}
