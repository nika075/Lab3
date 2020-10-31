import java.util.concurrent.Semaphore;

public class Filozof extends Thread {
    Glowna g=new Glowna();
    //public static final int MAX = 5;

    //public static Semaphore[] widelec = new Semaphore[MAX];
    //public static int mojNum;


    public Filozof(int nr) {
        g.mojNum = nr;
    }

    public void run() {
        while (true) {
// myslenie
            System.out.println("Mysle ¦ " + g.mojNum);
            try {
                Thread.sleep((long) (7000 * Math.random()));
            } catch (InterruptedException e) {
            }
            g.widelec[g.mojNum].acquireUninterruptibly(); //przechwycenie L widelca
            g.widelec[(g.mojNum + 1) % g.MAX].acquireUninterruptibly(); //przechwycenie P widelca
// jedzenie
            System.out.println("Zaczyna jesc " + g.mojNum);
            try {
                Thread.sleep((long) (5000 * Math.random()));
            } catch (InterruptedException e) {
            }
            System.out.println("Konczy jesc " + g.mojNum);
            g.widelec[g.mojNum].release(); //zwolnienie L widelca
            g.widelec[(g.mojNum + 1) % g.MAX].release(); //zwolnienie P widelca
        }
    }
}