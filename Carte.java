package problema_test;

public class Carte extends Publicatie{
    private int nrPagini;

    public Carte(String titlu, String autor, int anPublicare, int nrPagini) {
        super(titlu, autor, anPublicare);
        this.nrPagini = nrPagini;
    }

    public int getNrPagini() {
        return nrPagini;
    }

    public void setNrPagini(int nrPagini) {
        this.nrPagini = nrPagini;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "nrPagini=" + nrPagini +
                '}';
    }
}
