package com.assure.movie.dto;

import javax.validation.constraints.Email;

/**
 * @author Israel Yasis
 */
public class MemberDTO implements DTO {
    private Long id;
    @Email(message = "Email should be valid")
    private String userName;
    private String name;
    private String telephone;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
