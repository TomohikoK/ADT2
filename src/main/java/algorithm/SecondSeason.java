package algorithm;


class SecondSeason {

    public int fibonacci(int n) {
        if (n <= 2)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private Integer[] fibonacciSeries;

    public int memoizedFibonacci(int n) {
        fibonacciSeries = new Integer[n + 1];
        return memoizedFibonacciHelper(n);
    }

    public int memoizedFibonacciHelper(int n) {
        if (n <= 2) {
            fibonacciSeries[n] = 1;
            return 1;
        } else if (fibonacciSeries.length > n && fibonacciSeries[n] != null)
            return fibonacciSeries[n];
        else {
            int v = memoizedFibonacciHelper(n - 1) + memoizedFibonacciHelper(n - 2);
            fibonacciSeries[n] = v;
            return v;
        }
    }


    public int memoizedFibonacci2(int n) {
        Integer[] fibonacciSeries2 = new Integer[n + 1];
        fibonacciSeries2[1] = 1;
        fibonacciSeries2[2] = 1;

        for (int i = 3; i <= n; i++) {
            fibonacciSeries2[i] = fibonacciSeries2[i - 2] + fibonacciSeries2[i - 1];
        }

        return fibonacciSeries2[n];
    }

    public static void main(String[] args) {
        SecondSeason ss = new SecondSeason();
        System.out.println(ss.fibonacci(10));
        System.out.println(ss.memoizedFibonacci(10));
        System.out.println(ss.memoizedFibonacci2(10));
    }

}
