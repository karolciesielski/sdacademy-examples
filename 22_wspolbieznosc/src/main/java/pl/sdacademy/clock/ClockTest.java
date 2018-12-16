package pl.sdacademy.clock;

import java.time.LocalTime;

public class ClockTest {
    public static void main(String[] args) throws InterruptedException {
      Clock clock = new Clock();

      clock.startClock();
      Thread.sleep(3000);
      clock.stopClock();
    }
}
