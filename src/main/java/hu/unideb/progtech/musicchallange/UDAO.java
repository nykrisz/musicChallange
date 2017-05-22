/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.progtech.musicchallange;

import java.util.List;

/**
 *
 * @author Krisz
 */
public interface UDAO {
    public List<User> getUsers();
    
    public void persistUsers(List<User> users);
}
