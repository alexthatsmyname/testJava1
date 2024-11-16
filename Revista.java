package problema_test;

public class Revista extends Publicatie {
    private int nrExemplare;

    public Revista(String titlu, String autor, int anPublicare, int nrExemplare) {
        super(titlu, autor, anPublicare);
        this.nrExemplare = nrExemplare;
    }

    public int getNrExemplare() {
        return nrExemplare;
    }

    public void setNrExemplare(int nrExemplare) {
        this.nrExemplare = nrExemplare;
    }

    @Override
    public String toString() {
        return "Revista{" +
                "nrExemplare=" + nrExemplare +
                '}';
    }
}
