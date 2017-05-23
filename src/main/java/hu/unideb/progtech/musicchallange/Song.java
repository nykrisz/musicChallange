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
public class Song {
    private String path;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String correctAns;
    private String weight;

    public Song(String path, String answerA, String answerB, String answerC, String answerD, String correctAns, String weight) {
        this.path = path;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correctAns = correctAns;
        this.weight = weight;
    }
    
    public Song(String weight){
        this.weight = weight;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Song other = (Song) obj;
        if (!Objects.equals(this.path, other.path)) {
            return false;
        }
        if (!Objects.equals(this.answerA, other.answerA)) {
            return false;
        }
        if (!Objects.equals(this.answerB, other.answerB)) {
            return false;
        }
        if (!Objects.equals(this.answerC, other.answerC)) {
            return false;
        }
        if (!Objects.equals(this.answerD, other.answerD)) {
            return false;
        }
        if (!Objects.equals(this.correctAns, other.correctAns)) {
            return false;
        }
        if (!Objects.equals(this.weight, other.weight)) {
            return false;
        }
        return true;
    }
    
}    