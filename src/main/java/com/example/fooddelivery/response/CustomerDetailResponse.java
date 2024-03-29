package com.example.fooddelivery.response;

public class CustomerDetailResponse {
    private Integer id;
    private String name;
    private String username;
    private String password;
    private Long mobileNo;
    private String email;
    private String address;

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CustomerDetailResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobileNo=" + mobileNo +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
