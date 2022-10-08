package tsp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The class SimulatedAnnealing implements the actual algorithm to solve the traveling salesman problem.
 */
public class SimulatedAnnealing {
    // First, let's set the two input parameter of the algorithm, namely the temperature and the cooling factor.
    private static double temperature = 1000;
    private static double coolingFactor = 0.995;

    public static void main(String[] args) {

        // Adding some cities to a list. For simplicity, we added four cities representing a square.
        // The names are clearly not relevant for the problem itself, but are added to better understand the output.
        List<City> cities = new ArrayList<>();

        City city1 = new City("Firenze", 100, 100);
        cities.add(city1);

        City city2 = new City("Napoli", 200, 200);
        cities.add(city2);

        City city3 = new City("Roma", 100, 200);
        cities.add(city3);

        City city4 = new City("Milano", 200, 100);
        cities.add(city4);

        // We create a new Tour with the given cities. Remember that the Tour constructor will shuffle the list.
        Tour current = new Tour(cities);
        Tour best = current.duplicate();

        // Now, let's define the main loop of the algorithm. As shown, the for loop
        // will slowly lower the temperature by a cooling factor.
        for (double t = temperature; t > 1; t *= coolingFactor) {
            Tour neighbor = current.duplicate();

            // In each iteration of the loop, we generate a neighbor
            // by randomly swapping two cities in our current tour.
            int index1 = (int) (neighbor.noCities() * Math.random());
            int index2 = (int) (neighbor.noCities() * Math.random());

            // Note that the method swap of Collections implements
            // the actual swapping of two elements of a list.
            Collections.swap(neighbor.getCities(), index1, index2);

            int currentLength = current.getTourLength();
            int neighborLength = neighbor.getTourLength();

            // By means of the probability method, the algorithm determines
            // whether the neighbori will be accepted or not.
            if (Math.random() < Utilities.probability(currentLength, neighborLength, t)) {
                // If so, the neighbor becomes the current solution.
                current = neighbor.duplicate();
            }

            // Finally, if the current length is lower than the best,
            // then the best solution becomes the current one.
            if (current.getTourLength() < best.getTourLength()) {
                best = current.duplicate();
            }
        }

        // Just printing the total length of the tour along with the best solution.
        System.out.println("Final tour length: " + best.getTourLength());
        System.out.println("Tour: " + best);
    }
}