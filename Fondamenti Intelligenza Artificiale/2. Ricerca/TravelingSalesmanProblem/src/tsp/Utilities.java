package tsp;

/**
 * The class Util is the one containing two key methods for the implementation of a Simulated Annealing algorithm,
 * namely the probability - which will be used to express the likelihood to move into the search space - and the
 * distance, w
 */
public class Utilities {

    /**
     * The method computes the probability of accepting one of the two tours given as parameters in form of length.
     * The probability may be based on the temperature given as third parameter.
     *
     * @param f1: the length of the first tour;
     * @param f2: the length of the second tour;
     * @param temp: the current temperature of the algorithm.
     *
     * @return: a double number ranging between 0 and 1, representing the probability
     *          of accepting one of the two tours.
     */
    public static double probability(double f1, double f2, double temp) {
        //  Note that if the length of the second tour is shorter than the length
        //  of the first tour we will keep the second tour.
        double delta = f2 - f1;
        if (delta > 0) return 1;
        // Otherwise, we are going to return the probability of accepting the second tour.
        return Math.exp((f1 - f2) / temp);
    }

    /**
     * The method simply computes the Euclidean distance between the two cities given as parameters.
     *
     * @param city1: the first city;
     * @param city2: the second city;
     *
     * @return the Euclidean distance between city1 and city2.
     */
    public static double distance(City city1, City city2) {
        int xDist = Math.abs(city1.getX() - city2.getX());
        int yDist = Math.abs(city1.getY() - city2.getY());
        return Math.sqrt(xDist * xDist + yDist * yDist);
    }
}
