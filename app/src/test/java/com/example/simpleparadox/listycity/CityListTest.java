package com.example.simpleparadox.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {
    private CityList mockCityList(){
        CityList citylist = new CityList();
        citylist.add(mockCity());
        return citylist;
    }

    private City mockCity(){
        return new City("Edmonton","Alberta");

    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity(){
        CityList citylist = mockCityList();
        City city = new City("GuangZhou","GuangDong");
        citylist.add(city);
        City city2 = new City("GuangZhou","GuangDong");
        assertEquals(true,citylist.hasCity(city2));
    }

    @Test
    void testDelete(){
        CityList citylist = mockCityList();
        City city = new City("GuangZhou","GuangDong");
        citylist.add(city);
        City city2 = new City("GuangZhou","GuangDong");
        assertEquals(true,citylist.hasCity(city2));
        citylist.delete(city2);
        assertEquals(false,citylist.hasCity(city2));
    }
    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    @Test
    void testCountCities(){
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertEquals(1,cityList.countCities());
        City city2 = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city2);
        assertEquals(2,cityList.countCities());
        City city3 = new City("GuangZhou","GuangDong");
        cityList.add(city3);
        assertEquals(3,cityList.countCities());

    }




}
