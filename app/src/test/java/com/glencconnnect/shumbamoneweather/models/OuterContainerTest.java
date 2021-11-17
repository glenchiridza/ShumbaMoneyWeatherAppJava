package com.glencconnnect.shumbamoneweather.models;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

public class OuterContainerTest {


    private static ArrayList<List> list;
    private static OuterContainer container;
    private static Main main;
    private static ArrayList<Weather> weatherList;
    private static Weather weather;
    private static String listResult;
    private static String weatherResult;

    @BeforeClass
    public static void setupTest(){
        main = new Main(25.24,44,43);
        weather = new Weather("cloudy sky","Ond");
        weatherList = new ArrayList<>();
        weatherList.add(weather);
        List myList= new List(100112L,04304340430L,34303043L,main,weatherList,"11-23-21");

        list = new ArrayList<>();
        list.add(myList);
        container = new OuterContainer(list);
    }

    @Test
    public void getList() {
        listResult = list.get(0).getDt_txt();
    }

    @Test
    public void getWeather() {
        weatherResult =  list.get(0).getWeather().get(0).getDescription();
    }

    @Test
    public void checkResult(){
        //arrange
        String retrievedWeather = weatherResult;
        String retrievedList = listResult;

        //act
        int retrieveHumidity = list.get(0).getMain().getHumidity();
        String retrieveDescription = list.get(0).getWeather().get(0).getDescription();


        //assert
        Assert.assertNotNull(main);
        Assert.assertNotNull(weather);
        Assert.assertNotNull(container);

        Assert.assertNotNull(retrieveHumidity);
        Assert.assertNotNull(retrieveDescription);

        Assert.assertNotEquals(weatherResult,retrieveDescription);
    }


}