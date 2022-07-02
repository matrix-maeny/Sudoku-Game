package com.matrix_maeny.sudokugame.models;

public class LevelModel {
    int levelStateImage;
    int state;

    public LevelModel(int state,int levelStateImage) {
        this.levelStateImage = levelStateImage;
        this.state = state;
    }

    public int getLevelStateImage() {
        return levelStateImage;
    }

    public void setLevelStateImage(int levelStateImage) {
        this.levelStateImage = levelStateImage;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
