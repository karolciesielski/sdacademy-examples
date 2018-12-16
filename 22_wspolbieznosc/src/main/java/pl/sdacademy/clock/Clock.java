package pl.sdacademy.clock;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Clock {

    void startClock() {
        new Thread(this::work).start();
    }

    private void work(){
        while (isWorking()){
            try {
                Thread.sleep(1000);
                System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }

    private boolean working = true;

    private boolean isWorking() {
        return working;
    }

    void stopClock() {
        working = false;
    }
}
