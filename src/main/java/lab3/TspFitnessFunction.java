package lab3;

import org.uncommons.watchmaker.framework.FitnessEvaluator;

import java.util.List;

public class TspFitnessFunction implements FitnessEvaluator<TspSolution> {
    private List<Point> cities;
    public TspFitnessFunction(List<Point> cities) {
        this.cities = cities;
    }

    public double getFitness(TspSolution solution, List<? extends TspSolution> list) {

        double sum = cities.get(solution.getInd(solution.getDim()-1)).dist(cities.get(solution.getInd(0)));
        for(int i = 1; i < solution.getDim(); i++) {
            sum += cities.get(solution.getInd(i)).dist(cities.get(solution.getInd(i-1)));
        }
        return sum;
    }

    public boolean isNatural() {
        return false;
    }
}
