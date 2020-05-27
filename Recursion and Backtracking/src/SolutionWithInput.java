import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class SolutionWithInput implements Solution {

    protected BufferedReader reader;

    protected SolutionWithInput(){
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }
}
