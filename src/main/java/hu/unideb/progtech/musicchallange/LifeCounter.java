/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.progtech.musicchallange;

/**
 *
 * @author Krisz
 */
public class LifeCounter {
    private int lifecounter;

    public LifeCounter(int lifecounter) {
        this.lifecounter = lifecounter;
    }

    public int getLifecounter() {
        return lifecounter;
    }

    public void setLifecounter(int lifecounter) {
        this.lifecounter = lifecounter;
    }
    
    public void noRemLife(){
        //nincs tobb elet
        //talan GameManager
    }

    @Override
    public String toString() {
        return "LifeCounter{" + "lifecounter=" + lifecounter + '}';
    }
    
    
    
    
}
