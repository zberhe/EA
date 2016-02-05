/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.blog.service.Impl;

import com.packt.blog.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.packt.blog.dao.IRoleDAO;

/**
 *
 * @author Zehafta M
 */
@Service
@Transactional
public class RoleService {

  
    @Autowired
    private IRoleDAO roleDao;
 
    public Role getRole(int id) {
        return roleDao.getRole(id);
    }
}
