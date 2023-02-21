package org.example;

public class Recurregut {
    /**
     * Recorregut té un array de Creuaments i una parada actual (int)
     * Recorregut té seguentCreuament que va donant els creuaments en ordre seqüencial fins a la fi
     */
    private Creument[] creuments;
    private int paradaActual = 0;

    public Recurregut(Creument[] creuments) {
        this.creuments = creuments;
    }

    public int seguentCreuament() {
        if (creuments.length > paradaActual)
            return paradaActual++;
        return -1;
    }

    public int getParadaActual() {
        return paradaActual;
    }

    public void setParadaActual(int paradaActual) {
        this.paradaActual = paradaActual;
    }

    public Creument[] getCreuments() {
        return creuments;
    }

    public void setCreuments(Creument[] creuments) {
        this.creuments = creuments;
    }

}
