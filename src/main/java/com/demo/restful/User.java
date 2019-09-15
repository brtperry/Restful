package com.demo.restful;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private float id;
    private String first_name;
    private String last_name;
    private String email;
    private String ip_address;
    private float latitude;
    private float longitude;

    public User() {
    }

    public float getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getIp_address() {
        return ip_address;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Float.compare(user.id, id) == 0 &&
                Float.compare(user.latitude, latitude) == 0 &&
                Float.compare(user.longitude, longitude) == 0 &&
                first_name.equals(user.first_name) &&
                last_name.equals(user.last_name) &&
                email.equals(user.email) &&
                ip_address.equals(user.ip_address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, email, ip_address, latitude, longitude);
    }

    @Override
    public String toString() {
        return first_name + last_name;
    }
}
