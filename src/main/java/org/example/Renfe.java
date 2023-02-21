package org.example;

public class Renfe {
    private static final int NUMERO_TRENS = 5;
    private static final int NUMERO_CREUAMENTS = 10;
    /*
    Renfe declara NTRENS = 5 i NCREUAMENTS = 10, té un array de trens, un array de recorrecuts
    i un array de creuaments. (Cada tren té el se propi recorregut, però tots els recorreguts
    comparteixen el mateix array de creuaments).
*/

    public static void main(String[] args) {

        Tren[] trens = new Tren[NUMERO_TRENS];
        Creument[] creuments = new Creument[NUMERO_CREUAMENTS];

        for (int id = 0; id < creuments.length; id++) {
            creuments[id] = new Creument(id);
        }

        Recurregut recurregut = new Recurregut(creuments);
        for (int id = 0; id < trens.length; id++) {
            trens[id] = new Tren(String.format("Tren-%d", id), recurregut);
            trens[id].start();
        }
    }
}
