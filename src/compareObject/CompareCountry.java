package compareObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareCountry {
    public static void main(String... args) {
        List<Country> listOfCountry = new ArrayList<>();
        listOfCountry.add(new Country("Beijing", "+8:00 GMT", 1400000000, 500.89));
        listOfCountry.add(new Country("New Deli", "+6:00 GMT", 1500000000, 300.89));
        listOfCountry.add(new Country("Pretoria", "+2:00 GMT", 40000000, 100.89));
        listOfCountry.add(new Country("Ottawa", "-6:00 GMT", 20000000, 1000.89));

        Collections.sort(listOfCountry);

        System.out.println(listOfCountry);

        List<Country1> listOfCountry1 = new ArrayList<>();
        listOfCountry1.add(new Country1("Beijing", "+8:00 GMT", 1400000000, 500.89));
        listOfCountry1.add(new Country1("New Deli", "+6:00 GMT", 1500000000, 300.89));
        listOfCountry1.add(new Country1("Pretoria", "+2:00 GMT", 40000000, 100.89));
        listOfCountry1.add(new Country1("Ottawa", "-6:00 GMT", 20000000, 1000.89));

        //Please note: Comparator interface sorting is done through a separate class
        Collections.sort(listOfCountry1,new Country1());

        System.out.println(listOfCountry1);
    }
}
