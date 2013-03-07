package algorithm.ss;

import static org.junit.Assert.*;

import org.junit.Test;

public class GaussianElimTest {

    @Test
    public void test() {
        GaussianElim ge = new GaussianElim(new double[][] {
                {1, 1, 1},
                {1, 0, 0},
                {0, 1, 1}
        });
        assert(ge != null);
    }

}
