import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MonkeyBusiness {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int[] expression;

    static int n;

    static int totalSolutions;

    public static void main(String[] args) throws IOException {

        init();

        comb(0, 1);

        System.out.println("Total Solutions: " + totalSolutions);
    }

    private static void comb(int index, int start) {

        if (index == n) {
            print();
        } else {

            for (int i = start; i <= n; i++) {
                expression[index] = i;
                comb(index + 1, i + 1);
                expression[index] = -i;
                comb(index + 1, i + 1);
            }
        }
    }

    private static void print() {

        if (Arrays.stream(expression).sum() == 0) {

            for (int num : expression) {
                String n = num > 0 ? "+" + num : String.valueOf(num);
                System.out.print(n + " ");
            }
            System.out.println();

            totalSolutions++;
        }
    }

    private static void init() throws IOException {

        n = Integer.parseInt(reader.readLine());

        expression = new int[n];
    }
}
