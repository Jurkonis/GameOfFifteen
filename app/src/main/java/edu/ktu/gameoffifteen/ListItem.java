package edu.ktu.gameoffifteen;

import java.io.Serializable;

public class ListItem implements Serializable {
    private String name;
    private int imageID;
    private String time;

    public ListItem(){

    }
    public ListItem(String name, int imageID, String time){
        this.name = name;
        this.imageID=imageID;
        this.time = time;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getImageID(){
        return imageID;
    }
    public void setImageID(int imageID){
        this.imageID=imageID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
