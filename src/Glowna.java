import com.sun.deploy.security.SelectableSecurityManager;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Glowna  {

    public static int MAX ;
    public static Semaphore[] widelec ;
    public int mojNum;
    public static int ktora;
    public static void main(String[] args) {
        Scanner n1;
        n1 = new Scanner(System.in);
        System.out.println("Podaj ile filozofów 2-100: ");
        MAX=n1.nextInt();
        widelec=new Semaphore[MAX];
            if (MAX >= 2 && MAX <= 100) {
                System.out.println("Podaj która metoda 1-3: ");
                ktora = n1.nextInt();
                switch (ktora) {
                    case 1:
                        System.out.println("Metoda: " + ktora);
                        for (int i = 0; i < MAX; i++) {
                            widelec[i] = new Semaphore(1);
                        }
                        for (int i = 0; i < MAX; i++) {
                            new Filozof(i).start();
                        }
                        break;
                    case 2:
                        System.out.println("Metoda: " + ktora);
                        for (int i = 0; i < MAX; i++) {
                            widelec[i] = new Semaphore(1);
                        }
                        for (int i = 0; i < MAX; i++) {
                            new Filozof2(i).start();
                        }
                        break;
                    case 3:
                        System.out.println("Metoda: " + ktora);
                        for (int i = 0; i < MAX; i++) {
                            widelec[i] = new Semaphore(1);
                        }
                        for (int i = 0; i < MAX; i++) {
                            new Filozof3(i).start();

                        }
                        break;
                    default:
                        System.out.println("Metoda domyślna: " + ktora);
                        for (int i = 0; i < MAX; i++) {
                            widelec[i] = new Semaphore(1);
                        }
                        for (int i = 0; i < MAX; i++) {
                            new Filozof(i).start();

                        }
                        break;
                }
            } else {

                System.out.println("Problemy z czytaniem? Zła liczba filozofów. Koniec zabawy, zacznij od nowa. ");
            }

    }

}



