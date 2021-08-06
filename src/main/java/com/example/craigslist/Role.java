package com.example.craigslist;

import javax.persistence.*;

@Entity
@Table(name = "role_table")
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long roleId;

    @Column(name = "username")
    private String username;

    @Column(name = "role")
    private String role;

    public Role() {
    }

    public Role(String username, String role) {
        this.username = username;
        this.role = role;
    }


    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public long getRoleId() {
        return roleId;
    }
    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
