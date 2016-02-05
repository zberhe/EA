/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.blog.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Zehafta M
 */
@Entity
public class Privilege {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    private String name;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Privilege [name=");
        builder.append(name);
        builder.append("]");
        return builder.toString();

    }
}
