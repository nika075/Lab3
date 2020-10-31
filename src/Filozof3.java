import java.util.Random;
import java.util.concurrent.Semaphore ;
public class Filozof3 extends Thread {
    //static final int MAX=5;
    //static Semaphore [] widelec = new Semaphore [MAX] ;
    //int mojNum;
    Glowna g = new Glowna();
    Random losuj;

    public Filozof3(int nr) {
        g.mojNum = nr;
        losuj = new Random(g.mojNum);
    }

    public void run() {
        while (true) {
// myslenie
            System.out.println("Mysle ¦ " + g.mojNum);
            try {
                Thread.sleep((long) (5000 * Math.random()));
            } catch (InterruptedException e) {
            }
            int strona = losuj.nextInt(2);
            boolean podnioslDwaWidelce = false;
            do {
                if (strona == 0) {
                    g.widelec[g.mojNum].acquireUninterruptibly();
                    if (!(g.widelec[(g.mojNum + 1) % g.MAX].tryAcquire())) {
                        g.widelec[g.mojNum].release();
                    } else {
                        podnioslDwaWidelce = true;
                    }
                } else {
                    g.widelec[(g.mojNum + 1) % g.MAX].acquireUninterruptibly();
                    if (!(g.widelec[g.mojNum].tryAcquire())) {
                        g.widelec[(g.mojNum + 1) % g.MAX].release();
                    } else {
                        podnioslDwaWidelce = true;
                    }
                }
            } while (podnioslDwaWidelce == false);
            System.out.println("Zaczyna jesc " + g.mojNum);
            try {
                Thread.sleep((long) (3000 * Math.random()));
            } catch (InterruptedException e) {
            }
            System.out.println("Konczy jesc " + g.mojNum);
            g.widelec[g.mojNum].release();
            g.widelec[(g.mojNum + 1) % g.MAX].release();
        }
    }
}
