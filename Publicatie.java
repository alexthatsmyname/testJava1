package problema_test;

public class Publicatie {
    private String titlu;
    private String autor;
    private int anPublicare;

    public Publicatie(String titlu, String autor, int anPublicare) {
        this.titlu = titlu;
        this.autor = autor;
        this.anPublicare = anPublicare;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnPublicare() {
        return anPublicare;
    }

    public void setAnPublicare(int anPublicare) {
        this.anPublicare = anPublicare;
    }

    @Override
    public String toString() {
        return "Publicatie{" +
                "titlu='" + titlu + '\'' +
                ", autor='" + autor + '\'' +
                ", anPublicare=" + anPublicare +
                '}';
    }
}
