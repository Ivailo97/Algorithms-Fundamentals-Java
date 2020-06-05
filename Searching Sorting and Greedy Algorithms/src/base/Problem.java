package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Problem {

    protected BufferedReader reader;

    protected Problem() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public abstract void solve() throws IOException;

    protected abstract void init() throws IOException;
}
