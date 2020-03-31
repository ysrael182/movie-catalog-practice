package com.assure.movie.common.response;
/**
 * @author Israel Yasis
 */
public class CreatedResponse {
    private String status;
    private Long id;
    public CreatedResponse(String status, Long id) {
        this.status = status;
        this.id = id;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
