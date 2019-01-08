package com.wisely.mongodb.domain;
/**
  *
  *
  * @author  changzhenzhen
  * @date 2019-01-07
  */
public class Location {

    private String place;

    private String year;

    public Location(String place, String year) {
        super();
        this.place = place;
        this.year = year;
    }

    /**
     * 属性get方法
     */
    public String getPlace() {
        return place;
    }

    /**
     * 属性set方法
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * 属性get方法
     */
    public String getYear() {
        return year;
    }

    /**
     * 属性set方法
     */
    public void setYear(String year) {
        this.year = year;
    }
}
