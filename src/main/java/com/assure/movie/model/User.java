package com.assure.movie.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Israel Yasis
 */
@Entity
@Table(name = "user")
public class User implements Identifiable<Long> {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Member member;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        if (member == null) {
            if (this.member != null) {
                this.member.setUser(null);
            }
        }
        else {
            member.setUser(this);
        }
        this.member = member;
    }
}
