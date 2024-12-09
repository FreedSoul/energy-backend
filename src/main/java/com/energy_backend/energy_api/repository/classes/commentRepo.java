package com.energy_backend.energy_api.repository.classes;

public class commentRepo {
    private String body;
    private Integer user_id;

    public commentRepo(String body, Integer user_id) {
        this.body = body;
        this.user_id = user_id;
    }

    public String getBody() {
        return body;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }


}
