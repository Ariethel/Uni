package it.unisa;

import org.uma.jmetal.problem.integerproblem.impl.AbstractIntegerProblem;
import org.uma.jmetal.solution.integersolution.IntegerSolution;

import java.util.ArrayList;
import java.util.List;

public class NQueensProblem extends AbstractIntegerProblem {
    private int chessboardSize;
    public NQueensProblem(String name, int chessboardSize){
        if(chessboardSize < 3){
            throw new IllegalArgumentException("The chessboard size must be greater than 2");
        }
        this.chessboardSize = chessboardSize;
        setNumberOfVariables(chessboardSize); //Serve a settare n variabili corrispondenti al nostro # di regine
        setNumberOfObjectives(1); //Abbiamo un solo obiettivo
        setName(name);

        List<Integer> lowerBounds = new ArrayList<>();
        List<Integer> upperBounds = new ArrayList<>();

        for (int i = 0; i < chessboardSize; i++) {
            lowerBounds.add(1);
            upperBounds.add(chessboardSize);
        }
        setVariableBounds(lowerBounds, upperBounds);
    }

    @Override
    public IntegerSolution evaluate(IntegerSolution integerSolution) {
        return null;
    }


}
