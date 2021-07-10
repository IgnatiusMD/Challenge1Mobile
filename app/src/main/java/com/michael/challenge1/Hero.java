package com.michael.challenge1;

public class Hero {

    private String heroName;
    private String heroSource;

    public Hero(String heroName, String heroSource) {
        this.heroName = heroName;
        this.heroSource = heroSource;
    }

    public Hero() {

    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroSource() {
        return heroSource;
    }

    public void setHeroSource(String heroSource) {
        this.heroSource = heroSource;
    }
}
