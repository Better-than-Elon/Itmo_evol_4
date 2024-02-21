package lab3;

import org.uncommons.watchmaker.framework.operators.AbstractCrossover;

import java.util.*;

public class TspCrossover extends AbstractCrossover<TspSolution> {
    protected TspCrossover() {
        super(1);
    }

    protected List<TspSolution> mate(TspSolution p1, TspSolution p2, int i, Random random) {
        ArrayList children = new ArrayList();

        int a = random.nextInt(p1.getDim() - 1);
        int b = a + random.nextInt(p1.getDim()- 1 - a) + 1 + 1;

        List<Integer> child = new ArrayList<>(p1.getSolution());
        Set<Integer> used = new HashSet<>(child.subList(a, b));

        int toAdd = b % p2.getDim();
        for (int j = 0; j < p2.getDim(); j++) {
            Integer cur = p2.getInd((b + j) % p2.getDim());

            if (!used.contains(cur)) {
                child.set(toAdd, cur);
                toAdd = (toAdd + 1) % p2.getDim();
            }
        }
        // your implementation:
        children.add(new TspSolution(child));
        return children;
    }

}