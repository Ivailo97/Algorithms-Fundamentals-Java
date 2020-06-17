package problems.combinations;

import problems.Problem;

public abstract class Combinations extends Problem {

    protected Combinations() {
        super();
    }

    protected abstract void comb(int index, int start);

    @Override
    protected void printInitMessage() {
        System.out.println("Enter number of elements and number of sub-elements");
    }
}
