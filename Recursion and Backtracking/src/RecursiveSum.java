import java.io.IOException;
import java.util.Arrays;

public class RecursiveSum extends SolutionWithInput {

    public RecursiveSum() {
        super();
    }

    @Override
    public void solve() throws IOException {

        int[] numbers = Arrays.stream(reader.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = sum(numbers, 0);

        System.out.println(sum);
    }

    private int sum(int[] nums, int index) {

        if (index == nums.length) {
            return 0;
        }

        return nums[index] + sum(nums, index + 1);
    }
}
