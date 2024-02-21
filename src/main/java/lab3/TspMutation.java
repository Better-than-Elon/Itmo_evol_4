package lab3;

import org.uncommons.watchmaker.framework.EvolutionaryOperator;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static lab3.TspAlg.generations;

public class TspMutation implements EvolutionaryOperator<TspSolution> {
    double iteration = 0;

    public List<TspSolution> apply(List<TspSolution> population, Random random) {
        // your implementation:
        double p = iteration / generations;
        for (TspSolution solution : population) {
            int a = random.nextInt(solution.getDim() - 1);
            int b = a + random.nextInt(solution.getDim() - 1 - a) + 1 + 1;

            List<Integer> modify = solution.getSolution().subList(a, b);


            if (random.nextDouble() > Math.min(p*p,0.9)) {
                invert(modify);
            } else {
                if (p < 0.9) {
                    shuffle(modify, random);
                } else {
                    swap(modify);
                }
            }
        }
        iteration++;
        return population;
    }

    private void swap(List<Integer> modify) {
        System.out.println(modify);
        Collections.swap(modify, 0, modify.size() - 1);
    }

    private void insert(List<Integer> modify) {
        Collections.rotate(modify, 1);
    }

    private void shuffle(List<Integer> modify, Random rnd) {
        Collections.shuffle(modify, rnd);
    }

    private void invert(List<Integer> modify) {
        Collections.reverse(modify);
    }
}
