package ie.tudublin;

import processing.data.TableRow;
import processing.core.PApplet;

public class Nematode {

    private String name;
    private Float length;
    private int limbs;
    private String gender;
    private String eyes;
    private float xG;
    private float yG;
    

    @Override
    public String toString() {
        return "Nematode [name=" + name + ", length=" + length + ", limbs=" + limbs
                + ", gender=" + gender + ", eyes=" + eyes +"]";
    }


    public Nematode(TableRow tr) {
        this(
            tr.getString("name"),
            tr.getFloat("length"),
            tr.getInt("limbs"),
            tr.getString("gender"),
            tr.getString("eyes")
        );
    }



    public Nematode(String name, float length, int limbs, String gender, String eyes) {
        this.name = name;
        this.length = length;
        this.limbs = limbs;
        this.gender = gender;
        this.eyes = eyes;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public float setLength(){
        return length;
    }
    public void setLength(Float length){
        this.length = length;
    }
    public int getLimbs(){
        return limbs;
    }
    public void setLimbs(int limbs){
        this.limbs = limbs;
    }
    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public String getEyes(){
        return eyes;
    }
    public void setEyes(String eyes){
        this.eyes = eyes;
    }

    public void render(NematodeVisualiser pa){
        pa.fill(255);
        pa.textSize(50);
        pa.textAlign(PApplet.CENTER, PApplet.CENTER);
    }
}
