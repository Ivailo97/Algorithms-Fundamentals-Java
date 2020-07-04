import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AlphaDecay {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int[] numbers;

    static int[] kSlots;

    static boolean[] used;

    public static void main(String[] args) throws IOException {

        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        kSlots = new int[Integer.parseInt(reader.readLine())];

        used = new boolean[numbers.length];

        variations(0);
    }

    private static void variations(int index) {
        if (index == kSlots.length) {
            print(kSlots);
        } else {
            for (int i = 0; i < numbers.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    kSlots[index] = numbers[i];
                    variations(index + 1);
                    used[i] = false;
                }
            }
        }
    }

    private static void print(int[] kSlots) {

        for (int kSlot : kSlots) {
            System.out.print(kSlot + " ");
        }

        System.out.println();

    }
}
