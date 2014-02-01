package org.rayjars.trafficflow;


public class Light implements ObjectValidator {

    private Boolean state = Boolean.TRUE;

    private Integer duration = 0;

    public Light(Integer duration) {
        this.duration = duration;
    }

    public Integer getDuration() {
        return duration;
    }

    public Float run(Float timer){
       Float nbCycle = timer / getDuration();

       for(int i = nbCycle.intValue(); i > 0; i--){
         state = !state;
       }

       if( (nbCycle.intValue() * getDuration()) == timer){
           return new Float(getDuration());
       }

       return ((nbCycle.intValue()+1) * getDuration()) - timer;
    }


    public Boolean isGreen(){
        return state == Boolean.TRUE;
    }

    public Boolean isRed(){
        return !isGreen();
    }


    public void validate() throws IllegalArgumentException {
        validateDurationTooLow();
        validateDurationTooHigh();
    }

    protected void validateDurationTooHigh() {
        if(duration > 60 ){
            throw new IllegalArgumentException("Duration too high");
        }
    }

    protected void validateDurationTooLow() {
        if(duration < 10 ){
            throw new IllegalArgumentException("Duration too low");
        }
    }
}
