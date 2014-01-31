package org.rayjars.trafficflow;


public class Car {

    private Integer speed = 0;

    private Float timer = 0f;


    public Car(Integer speed){
        setSpeed(speed);
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Car validate(){
          validateModulo5();
          validateHighSpeed();
          validateSlowSpeed();
          return this;
    }

    public void validateHighSpeed(){
        if(getSpeed() > 30){
            throw new IllegalArgumentException("The car is going too fast");
        }
    }

    public void validateSlowSpeed(){
        if(getSpeed() < 5){
            throw new IllegalArgumentException("The car is going too slow");
        }
    }

    public void validateModulo5(){
        if(getSpeed() % 5 != 0){
            throw new IllegalArgumentException("The car got a bad speed");
        }
    }

    public void drive(Integer distance){
        timer += (float)distance / getSpeed();
    }

    public void stop(Float timeToWait){
        timer += timeToWait;
    }

    public Float getTimer() {
        return timer;
    }
}
