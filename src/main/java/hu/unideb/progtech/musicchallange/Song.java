
package hu.unideb.progtech.musicchallange;

import java.util.Objects;


/**
 * Egy zenével kapcsolatos információkat
 * bemutató osztály.
 * 
 */
public class Song {
    private String path;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String correctAns;
    private String weight;
    
    /**
     * Song objektumot létrehozó konstruktor.
     * 
     * @param path zene elérési útvonala
     * @param answerA zenéhez tartozó A válasz
     * @param answerB zenéhez tartozó B válasz
     * @param answerC zenéhez tartozó C válasz
     * @param answerD zenéhez tartozó D válasz
     * @param correctAns zenéhez tartozó helyes válasz
     * @param weight zenéhez tartozó súly
     */
    
    public Song(String path, String answerA, String answerB, String answerC, String answerD, String correctAns, String weight) {
        this.path = path;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correctAns = correctAns;
        this.weight = weight;
    }
    
    /**
     * Visszaadja a zene elérési útvonalát.
     * 
     * @return zene elérési útvonala 
     */
    public String getPath() {
        return path;
    }

    /**
     * Beállítja a zene elérési útvonalát.
     * 
     * @param path zene elérési útvonala 
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Visszaadja a zenéhez tartozó A választ.
     * 
     * @return zenéhez tartozó A válasz 
     */
    public String getAnswerA() {
        return answerA;
    }

    /**
     * Beállítja a zenéhez tartozó A választ.
     * 
     * @param answerA zenéhez tartozó A válasz
     */
    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    /**
     * Visszaadja a zenéhez tartozó B választ.
     * 
     * @return zenéhez tartozó B válasz 
     */
    public String getAnswerB() {
        return answerB;
    }

    /**
     * Beállítja a zenéhez tartozó B választ.
     * 
     * @param answerB zenéhez tartozó B válasz
     */
    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    /**
     * Visszaadja a zenéhez tartozó C választ.
     * 
     * @return zenéhez tartozó C válasz 
     */
    public String getAnswerC() {
        return answerC;
    }

    /**
     * Beállítja a zenéhez tartozó C választ.
     * 
     * @param answerC zenéhez tartozó C válasz
     */
    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    /**
     * Visszaadja a zenéhez tartozó D választ.
     * 
     * @return zenéhez tartozó D válasz 
     */
    public String getAnswerD() {
        return answerD;
    }

    /**
     * Beállítja a zenéhez tartozó D választ.
     * 
     * @param answerD zenéhez tartozó D válasz
     */
    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    /**
     * Visszaadja a zenéhez tartozó helyes választ.
     * 
     * @return zenéhez tartozó helyes válasz 
     */
    public String getCorrectAns() {
        return correctAns;
    }

    /**
     * Beállítja a zenéhez tartozó helyes választ.
     * 
     * @param correctAns zenéhez tartozó helyes válasz
     */
    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

    /**
     * Visszaadja a zenéhez tartozó súlyt.
     * 
     * @return zenéhez tartozó súly
     */
    public String getWeight() {
        return weight;
    }

    /**
     * Beállítja a zenéhez tartozó súlyt.
     * 
     * @param weight zenéhez tartozó súly
     */
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