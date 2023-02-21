package org.example;

public class Creument {

    private int idTren;
    private boolean semafor = false;

    public Creument(int idTren) {
        this.idTren = idTren;
    }

    public synchronized void entrarEstacio(Tren tren) {
        while (semafor) {
            System.out.printf("[%s] esperant a la estació[%d]%n", tren.getNom(), idTren);
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.printf("[%s] arriban a la estació[%d]%n", tren.getNom(), idTren);
        semafor = !semafor;
    }

    public synchronized void sortirEstacio(Tren tren) {
        System.out.printf("[%s] sortint de la estació[%d]%n", tren.getNom(), idTren);
        semafor = !semafor;
        notifyAll();
    }
}
