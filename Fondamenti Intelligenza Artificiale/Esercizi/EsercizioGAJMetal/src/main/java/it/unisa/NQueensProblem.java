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

    public int computeConflicts(List<Integer> encoding){
        int rowConflicts = 0;
        int upperRightConflicts = 0;
        int lowerRightConflicts = 0;
        for (int col = 0; col < chessboardSize; col++){
            int row = encoding.get(col);
            for (int rightCol = col + 1; rightCol < chessboardSize; rightCol++){
                int rightRow = encoding.get(rightCol);
                if (row == rightRow){
                    rowConflicts++;
                }
                if (row == rightRow - (rightCol - col)){
                    upperRightConflicts++;
                }
                if (row == rightRow + (rightCol - col)){
                    lowerRightConflicts++;
                }
            }
        }
        return rowConflicts + upperRightConflicts + lowerRightConflicts;
    }
    @Override
    public void evaluate(IntegerSolution integerSolution) {
        int evaluation = computeConflicts(integerSolution.getVariables());
        integerSolution.getObjectives()[0] = evaluation;
    }


}
