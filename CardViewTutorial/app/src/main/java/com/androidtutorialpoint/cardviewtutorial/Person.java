package com.androidtutorialpoint.cardviewtutorial;


public class Person
{
    private String name;
    private String imageUrl;
    private int isFavor;
    private int isTurned;
    private int imageResourceId;

    public Person(){

    }

    public void setName(String name){
        this.name = name;
    }

    public Person withName(String name){
        this.name = name;
        return this;
    }

    public Person withImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
        return this;
    }

    public Person withIsFavor(int isFavor){
        this.isFavor = isFavor;
        return this;
    }

    public Person withIsTurned(int isTurned){
        this.isTurned = isTurned;
        return this;
    }

    public Person withImageResourceId(int imageResourceId){
        this.imageResourceId = imageResourceId;
        return this;
    }

    public String getName(){
        return name;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public int getIsFavor(){
        return isFavor;
    }

    public int getIsTurned(){
        return isTurned;
    }

    public int getImageResourceId(){
        return imageResourceId;
    }

}
