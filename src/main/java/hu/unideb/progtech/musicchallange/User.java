/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.progtech.musicchallange;

import java.util.Objects;

/**
 *
 * @author Krisz
 */
public class User {
    
    private String name;
    private int point;

    public User(String name, int score) {
        this.name = name;
        this.point = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return point;
    }

    public void setScore(int score) {
        this.point = score;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.point != other.point) {
            return false;
        }
        return true;
    }

}
