package org.gary.compareObject;

import java.util.Comparator;

/**
 * Compare objects by using Comparator<T> interface
 */
public class Country1 implements Comparator<Country1> {
    private String capital;
    private String timezone;
    private long population;
    private double GDP;

    public Country1(String capital, String timezone, long population, double GDP) {
        this.capital = capital;
        this.timezone = timezone;
        this.population = population;
        this.GDP = GDP;
    }

    @Override
    public String toString() {
        return "Country1{" +
                "capital='" + capital + '\'' +
                ", timezone='" + timezone + '\'' +
                ", population=" + population +
                ", GDP=" + GDP +
                '}';
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public void setGDP(double GDP) {
        this.GDP = GDP;
    }

    public String getCapital() {
        return capital;
    }

    public String getTimezone() {
        return timezone;
    }

    public long getPopulation() {
        return population;
    }

    public double getGDP() {
        return GDP;
    }

    @Override
    public int compare(Country1 o1, Country1 o2) {
        return o1.population > o2.population ? 1 : (o1.population < o2.population ? -1 : 0);
    }

    public Country1(){}
}

