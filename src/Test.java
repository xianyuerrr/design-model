public class Test {
    private static final int TENK = 10000;
    private static long count = 0;

    private void add10k() {
        int idx = 0;
        while (idx++ < TENK) {
            count++;
        }
    }

    private static long calc() throws InterruptedException {
        final Test test = new Test();

        Thread th1 = new Thread(test :: add10k);
        Thread th2 = new Thread(test :: add10k);

        th1.start();
        th2.start();

        th1.join();
        th2.join();
        return count;
    }

    public static void main(String[] args) {
        try {
            System.out.println(calc());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
