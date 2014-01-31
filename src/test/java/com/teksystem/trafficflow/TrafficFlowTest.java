package com.teksystem.trafficflow;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class TrafficFlowTest {

    private TrafficFlow trafficFlow;

    @Before
    public void createSimulation() {
        trafficFlow = new TrafficFlow();
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    public static List<Integer[]> data() {
        return Arrays.asList(new Integer[][]{
                {10, 5},
                {10, 10},
                {10, 15},
                {20, 20},
                {10, 25},
                {10, 30}
        });
    }


    @Test
    public void shouldSpeedAModulo5AndNotHigherThan30(){
         for(Integer[] data : data()){
            trafficFlow.simulate(new Integer[]{data[0]}, data[1]);
         }
    }

    @Test
    public void shouldFailedWithNoSpeed() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The car is going too slow");


        trafficFlow.simulate(new Integer[]{10}, 0);
    }

    @Test
    public void shouldFailedWithSpeedNoModulo5() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The car got a bad speed");

        trafficFlow.simulate(new Integer[]{10}, 1);
    }

    @Test
    public void shouldFailedWithHighSpeed() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("The car is going too fast");

        trafficFlow.simulate(new Integer[]{10}, 35);
    }

    @Test
    public void shouldHaveAtLeast1Light() {
        trafficFlow.simulate(new Integer[]{10}, 30);
    }

    @Test
    public void shouldHaveAMaximunOf50Lights() {
        Integer[] lights = new Integer[50];

        for (int i = 0; i < lights.length; i++) {
            lights[i] = 10;
        }

        trafficFlow.simulate(lights, 30);
    }

    @Test
    public void shouldFailedWith0Lights() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Not enough lights");

        trafficFlow.simulate(new Integer[0], 30);
    }

    @Test
    public void shouldFailedWith60Lights() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Too much lights");

        trafficFlow.simulate(new Integer[60], 30);
    }

    @Test
    public void shouldHaveLightBetwen10secondsAnd60secondsDuration() {

    }

    @Test
    public void shouldFailedWithLights5secondsDuration() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Duration too low");

        trafficFlow.simulate(new Integer[]{5}, 30);
    }

    @Test
    public void shouldFailedWithLights61secondsDuration() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Duration too high");

        trafficFlow.simulate(new Integer[]{61}, 30);
    }


    @Test
    public void shouldReturn30secondsWithSpeed30() {
        Integer[] lights = {10, 10, 10};
        Integer speed = 30;

        assertThat(trafficFlow.simulate(lights, speed), is(30));
    }


    @Test
    public void shouldReturn35secondsWithSpeed20AndSameTimeLights() {
        Integer[] lights = {10, 10, 10};
        Integer speed = 20;

        assertThat(trafficFlow.simulate(lights, speed), is(35));

    }

    @Test
    public void shouldReturn35secondsWithSpeed20AndDifferentTimeLights() {
        Integer[] lights = {10, 20, 30};
        Integer speed = 20;

        assertThat(trafficFlow.simulate(lights, speed), is(30));
    }

    @Test
    public void shouldReturn240secondsWithSpeed5() {
        Integer[] lights = {10, 11, 12, 13, 14, 15};
        Integer speed = 5;

        assertThat(trafficFlow.simulate(lights, speed), is(240));
    }

    @Test
    public void shouldReturn630WithSpeed5() {
        Integer[] lights = {60, 60, 60, 60, 60, 60, 60, 60, 60, 60};
        Integer speed = 5;

        assertThat(trafficFlow.simulate(lights, speed), is(630));
    }

    @Test
    public void shouldReturn252WithSpeed25() {
        Integer[] lights = {55, 29, 26, 12, 19, 39, 18, 20, 23, 28, 56, 20, 59, 48, 33, 40, 30, 60, 19};
        Integer speed = 25;

        assertThat(trafficFlow.simulate(lights, speed), is(252));
    }

}
