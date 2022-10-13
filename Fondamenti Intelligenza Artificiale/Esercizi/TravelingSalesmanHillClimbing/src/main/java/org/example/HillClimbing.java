package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The class HillClimbing implements the actual algorithm to solve the traveling salesman problem.
 */
public class HillClimbing {

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

        //Tour iniziali randomizzato
        Tour current = new Tour(cities);

        //Lista delle citta' prese dal tour iniziali randomizzato
        cities = current.getCities();

        //Lista nella quale verranno inserite le citta' ordinate per fitness
        List<City> nuoveCitta = new ArrayList<>();

        //Tour nel quale verra' salvato il miglior tour trovato
        Tour best = current.duplicate();

        //Salvo la root tra le nuove citta' da restituire e la rimuovo dalle vecchie
        nuoveCitta.add(cities.get(0));
        cities.remove(0);

        //Finche' la lista delle citta' vecchie non e' vuota cerco la miglior citta' successiva a quella nella quale mi trovo, la aggiungo alla lista di quelle nuove e la rimuovo da
        //quelle vecchie
        while(!cities.isEmpty()){
            //Di volta in volta cities[0] sara' la citta' successiva a quella nella quale mi trovo nel percorso originale, resta sempre 0 perche' ad ogni iterazione rimuovo
            //un elemento dalla lista
            City tmp = cities.get(0);
            for (int i = 1; i < cities.size(); i++){
                //Se la distanza tra la citta' nella quale mi trovo e la citta' che sto considerando e' minore di quella tra la citta' nella quale mi trovo e la citta' che il
                //percorso originale mi aveva proposto
                if (Utilities.distance(nuoveCitta.get(nuoveCitta.size()-1), cities.get(i)) < Utilities.distance(nuoveCitta.get(nuoveCitta.size()-1), tmp)){
                    tmp = cities.get(i);
                }
            }

            //Rimuovo la citta' che ho scelto dalla lista delle citta' vecchie e la aggiungo alla lista delle nuove
            cities.remove(tmp);
            nuoveCitta.add(tmp);
        }

        //Creo un nuovo tour con le nuove citta' ordinate per fitness
        best.setCities(nuoveCitta);

        // Just printing the total length of the tour along with the best solution.
        System.out.println("Final tour length: " + best.getTourLength());
        System.out.println("Tour: " + best);
    }
}