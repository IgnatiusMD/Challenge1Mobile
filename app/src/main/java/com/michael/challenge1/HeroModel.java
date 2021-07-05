package com.michael.challenge1;

public class HeroModel {
    private String HeroName;
    private int image;
    private String Source;

    public HeroModel(String HeroName, int image, String Source){
        this.HeroName = HeroName;
        this.image = image;
        this.Source = Source;
    }

    public String getHeroName() {
        return HeroName;
    }

    public void setHeroName(String heroName) {
        HeroName = heroName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }
}
