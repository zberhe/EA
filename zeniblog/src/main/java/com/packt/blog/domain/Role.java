/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.blog.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority {
 
    @Id
    @GeneratedValue
   private  int id;
    private String name;
// @OneToMany
//    private List<Privilege> privileges;
// 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    @Override
    public String getAuthority() {
        return this.name;
    }
 
//    public List<Privilege> getPrivileges() {
//        return privileges;
//    }
// 
//    public void setPrivileges(List<Privilege> privileges) {
//        this.privileges = privileges;
//    }
 
//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("Role [name=");
//        builder.append(name);
//        builder.append(", privileges=");
//        builder.append(privileges);
//        builder.append("]");
//        return builder.toString();
//    }
}
