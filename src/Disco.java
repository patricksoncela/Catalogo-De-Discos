import java.util.ArrayList;
import java.util.List;

public class Disco {
    private String titulo;
    private int lancamento;
    private List<String> faixas;
    private Artista artista;

    public Disco(String nome, int lancamento, List<String> faixas) { //Construtor
        this.titulo = nome;
        this.lancamento = lancamento;
        this.faixas = faixas;
    }

    public Disco(String nome, int lancamento) { //Construtor sobrecarregado para permitir criação de disco sem faixas
        this.titulo = nome;
        this.lancamento = lancamento;
        this.faixas = new ArrayList<>();
    }

    public int getLancamento() {
        return lancamento;
    }

    public void setLancamento(int lancamento) {
        this.lancamento = lancamento;
    }

    public List<String> getFaixas() {
        return faixas;
    }

    public void setFaixas(List<String> faixas) {
        this.faixas = faixas;
    }

    public String getNome() {
        return titulo;
    }

    public void setNome(String nome) {
        this.titulo = nome;
    }

    public void adicionarFaixa(String faixa) {
        this.faixas.add(faixa);
    }

    public void removerFaixa(String faixa) {
        this.faixas.remove(faixa);
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }



    @Override
    public String toString(){
        return "Título: " + titulo +
                "\nLançamento: " + lancamento +
                "\nFaixas: " + faixas +
                "\nArtista: " + (artista != null ? artista.toString() : "N/A") +
                "\n|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-|" +
                "\n";
    }

}
