package it.unisa;

import org.apache.commons.math3.genetics.GeneticAlgorithm;
import org.uma.jmetal.algorithm.Algorithm;
import org.uma.jmetal.algorithm.AlgorithmBuilder;
import org.uma.jmetal.algorithm.singleobjective.geneticalgorithm.GeneticAlgorithmBuilder;
import org.uma.jmetal.example.AlgorithmRunner;
import org.uma.jmetal.operator.mutation.impl.IntegerPolynomialMutation;
import org.uma.jmetal.operator.selection.impl.BinaryTournamentSelection;
import org.uma.jmetal.solution.integersolution.IntegerSolution;
import org.uma.jmetal.util.JMetalLogger;

public class Main {
    public static void main(String[] args) {
        double crossoverProb =  0.8;
        int crossoverPoints = 1;
        NQueensProblem problem = new NQueensProblem("Eight Queens Problem", 8);
        BinaryTournamentSelection<IntegerSolution> selection = new BinaryTournamentSelection<>();
        IntegerNPointCrossover crossover = new IntegerNPointCrossover(crossoverProb, crossoverPoints);
        IntegerPolynomialMutation mutation = new IntegerPolynomialMutation(0.01,  0);
        Algorithm<IntegerSolution> sga = new GeneticAlgorithmBuilder<>(problem, crossover, mutation)
                .setPopulationSize(100)
                .setMaxEvaluations(250000)
                .setSelectionOperator(selection)
                .build();
        AlgorithmRunner.Executor executor = new AlgorithmRunner.Executor(sga);
        AlgorithmRunner runner = executor.execute();
        JMetalLogger.logger.info("Total execution time: " + runner.getComputingTime() + "ms");
        JMetalLogger.logger.info("Best solution: " + sga.getResult());
    }
}