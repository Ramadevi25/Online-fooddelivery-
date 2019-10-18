package com.example.fooddelivery.model;


import javax.persistence.*;

@Entity
@Table(name="restraurants")

public class Restraurants {
    @Id
    private Integer r_id;
    @Column(name="")
    private String r_name;
    private String f_id;

    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public String getF_id() {
        return f_id;
    }

    public void setF_id(String f_id) {
        this.f_id = f_id;
    }

    public Restraurants()
    {

    }

}
