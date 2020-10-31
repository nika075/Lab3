import java.util.concurrent.Semaphore;

class Filozof2 extends Thread {
   // public static final int MAX = 11;
    //public static Semaphore[] widelec = new Semaphore[MAX];
    //public int mojNum;
    Glowna g=new Glowna();
    public Filozof2(int nr) {
        g.mojNum = nr;
    }

    public void run() {
        while (true) {
// myslenie
            System.out.println("Mysle ¦ " + g.mojNum);
            try {
                Thread.sleep((long) (5000 * Math.random()));
            } catch (InterruptedException e) {
            }
            if (g.mojNum == 0) {
                g.widelec[(g.mojNum + 1) % g.MAX].acquireUninterruptibly();
                g.widelec[g.mojNum].acquireUninterruptibly();
            } else {
                g.widelec[g.mojNum].acquireUninterruptibly();
                g.widelec[(g.mojNum + 1) % g.MAX].acquireUninterruptibly();
            }
// jedzenie
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