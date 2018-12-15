package pl.sdacademy.thread;

public class HelloThreadExample {
    public static void main(String[] args) throws InterruptedException {
        NumberHolder number = new NumberHolder(0);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                number.increment();
            }
        });
        thread.start();
        number.increment();
        System.out.printf("Number holder value = %d", number.getNumber());
    }

    private static class NumberHolder {
        private int number;

        private NumberHolder(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }

        public void increment() {
            number++;
        }
    }
}
