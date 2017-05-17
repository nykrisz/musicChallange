/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.progtech.musicchallange;

import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.control.Label;

/**
 *
 * @author Krisz
 */
public class TimeCounter {
    private int counter;
    private Timer timer;
    private Label label;
    
    public TimeCounter(int counter, Timer timer, Label label) {
        this.counter = counter;
        this.timer = timer;
        this.label = label;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
    
    public void noRemTime(){
        //nincs tobb ido
        //talan GameManager
    }
    
    public void countTime(){
        counter = 10;
        TimerTask task = new TimerTask(){
            public void run(){
                //settext
                label.setText(Integer.toString(counter));
                counter--;
                if(counter == -1){
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    @Override
    public String toString() {
        return "TimeCounter{" + "counter=" + counter + '}';
    }
    
    
}
