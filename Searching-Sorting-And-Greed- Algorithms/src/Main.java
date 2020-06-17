import base.Problem;
import problems.*;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Problem> problems = List.of(new BinarySearch(), new MergeSort(),
                new QuickSort(), new SumOfCoins(), new SetCover());

        for (Problem problem : problems) {
            System.out.println(problem.getClass().getSimpleName());
            problem.solve();
        }
    }
}
