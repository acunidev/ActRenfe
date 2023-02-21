package org.example;

import java.util.Random;

public class Tren extends Thread {
    private static final int TEMPS_ENTRE_PARADES = 300;
    /*
        Tren té un nom i un recorregut i un TEMPS_ENTRE_PARADES = 300
    Tren demana al recorregut el seguentCreuament() i entra, espera i surt fins que s’acaben els
        creuaments del recorregut.
    */
    private Random rand = new Random();
    private String nom;
    private Recurregut recurregut;

    public Tren(String nom, Recurregut recurregut) {
        this.nom = nom;
        this.recurregut = recurregut;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Recurregut getRecurregut() {
        return recurregut;
    }

    public void setRecurregut(Recurregut recurregut) {
        this.recurregut = recurregut;
    }

    @Override
    public void run() {
        int numCreaument = 0;
        while ((numCreaument = recurregut.seguentCreuament()) != -1) {
            recurregut.getCreuments()[numCreaument].entrarEstacio(this);
            try {
                Thread.sleep(rand.nextInt(TEMPS_ENTRE_PARADES + 1));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            recurregut.getCreuments()[numCreaument].sortirEstacio(this);
        }
        System.out.printf("[%s] ruta finalitzada%n", nom);
    }

}
