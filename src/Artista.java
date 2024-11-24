public class Artista {
    private String nomeArtista;
    private String genero;

    public Artista(String genero, String nomeArtista) {
        this.genero = genero;
        this.nomeArtista = nomeArtista;
    }

    public String getNomeArtista() {
        return nomeArtista;
    }

    public void setNomeArtista(String nomeArtista) {
        this.nomeArtista = nomeArtista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String toString() {
        return "Nome: " + nomeArtista +  "  |Genero: " + genero;
    }
}
