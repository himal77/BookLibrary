package com.mountech.domain.security;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Role {
    @Id
    private int roleId;
    private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserRole> userRole = new HashSet<>();

    public Role(int roleId, String name, Set<UserRole> userRole) {
        this.roleId = roleId;
        this.name = name;
        this.userRole = userRole;
    }

    public Role() {
    }

    public int getRoleId() {
        return roleId;
    }

    public String getName() {
        return name;
    }

    public Set<UserRole> getUserRole() {
        return userRole;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserRole(Set<UserRole> userRole) {
        this.userRole = userRole;
    }
}
