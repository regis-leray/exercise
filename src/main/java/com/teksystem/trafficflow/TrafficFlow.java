package com.teksystem.trafficflow;


import java.util.Iterator;

public class TrafficFlow {

    public static final Integer DEFAULT_DISTANCE = 150;

    private final Integer startDistance;

    private final Integer distanceBetweenLight;

    private final Integer endDistance;

    public TrafficFlow() {
        this(DEFAULT_DISTANCE, DEFAULT_DISTANCE, DEFAULT_DISTANCE);
    }

    public TrafficFlow(Integer startDistance, Integer distanceBetweenLight, Integer endDistance) {
        this.startDistance = startDistance;
        this.distanceBetweenLight = distanceBetweenLight;
        this.endDistance = endDistance;
    }

    public Integer simulate(Integer[] lights, Integer speed) {
        Car car = new Car(speed).validate();
        Road road = new Road(lights).validate();
        return simulate(road, car);
    }

    private Integer simulate(Road road, Car car) {
        Integer distance = getStartDistance();

        for (Iterator<Light> it = road.getLigths().iterator(); it.hasNext(); ) {
            Light light = it.next();
            car.drive(distance);

            Float timeToWait = light.run(car.getTimer());

            if (light.isRed()) {
                car.stop(timeToWait);
            }

            if (noMoreLights(it)) {
                car.drive(getEndDistance());
            }

            distance = getDistanceBetweenLight();
        }

        return car.getTimer().intValue();
    }

    private boolean noMoreLights(Iterator<Light> it) {
        return it.hasNext() == false;
    }

    public Integer getStartDistance() {
        return startDistance;
    }

    public Integer getDistanceBetweenLight() {
        return distanceBetweenLight;
    }

    public Integer getEndDistance() {
        return endDistance;
    }
}
