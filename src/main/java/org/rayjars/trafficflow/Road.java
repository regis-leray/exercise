package org.rayjars.trafficflow;


import java.util.ArrayList;
import java.util.List;

public class Road {
    private List<Light> ligths = null;

    public Road(Integer[] paramlights){
        ligths = new ArrayList<Light>(paramlights.length);

        for(Integer l : paramlights){
            ligths.add(new Light(l));
        }
    }

    public List<Light> getLigths() {
        return ligths;
    }

    public Road validate(){
       validateNotEnoughLigths();
       validateTooMuchLigths();

       for(Light light : getLigths()){
           light.validate();
       }

        return this;
    }

    protected void validateTooMuchLigths() {
        if(getLigths().size() > 50){
            throw new IllegalArgumentException("Too much lights");
        }
    }

    protected void validateNotEnoughLigths() {
        if(getLigths().size() < 1){
            throw new IllegalArgumentException("Not enough lights");
        }
    }

}
