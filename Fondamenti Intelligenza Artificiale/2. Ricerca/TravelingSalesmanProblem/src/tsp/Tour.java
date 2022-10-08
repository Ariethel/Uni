package tsp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The class Tour represents a path covering multiple cities. A Tour is composed of a list
 * of cities belonging to the path as well as of a distance, which will represent the length of the path.
 */
public class Tour {

    private List<City> cities;
    private int distance;

    public Tour(List<City> cities) {
        this.cities = new ArrayList<>(cities);
        // Note that the shuffle method will randomly permute the specified list of cities.
        Collections.shuffle(this.cities);
    }

    public City getCity(int index) {
        return cities.get(index);
    }

    /**
     * The method getTourLength will compute the distance traveled by the salesman.
     * @return the total distance traveled.
     */
    public int getTourLength() {
        if (distance != 0) return distance;

        int totalDistance = 0;

        for (int i = 0; i < noCities(); i++) {
            City start = getCity(i);
            // the end point depends on whether we have considered all cities of the list.
            City end = getCity(i + 1 < noCities() ? i + 1 : 0);

            // The distance method is a utility function computing the distance between two cities.
            totalDistance += Utilities.distance(start, end);
        }

        distance = totalDistance;
        return totalDistance;
    }

    public Tour duplicate() {
        return new Tour(new ArrayList<>(cities));
    }

    public int noCities() {
        return cities.size();
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * The toString method will print the information of an instance of a Tour.
     * @return a String representation of a Tour.
     */
    @Override
    public String toString() {
        return "Tour{" +
                "cities=" + cities +
                ", distance=" + distance +
                '}';
    }
}
