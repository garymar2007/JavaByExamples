package compareObject;

/**
 * Compare objects by using Comparable<T> interface
 */
public class Country implements Comparable<Country>{
    private String capital;
    private String timezone;
    private long population;
    private double GDP;

    public Country(String capital, String timezone, long population, double GDP) {
        this.capital = capital;
        this.timezone = timezone;
        this.population = population;
        this.GDP = GDP;
    }

    @Override
    public String toString() {
        return "Country{" +
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
    public int compareTo(Country country) {
        return this.population > country.population ? 1 : (this.population < country.population ? -1 : 0);
    }
}

