import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Catalogo {
    private static List<Disco> discos = new ArrayList<>(); //Cria e inicializa a lista de discos
    private static List<Artista> artistas = new ArrayList<>(); //Cria e inicializa a lista de artistas
    Scanner scanner = new Scanner(System.in);


    public void listarDiscos() {
        if (discos.isEmpty()) {
            System.out.println("Nenhum disco cadastrado.");
            System.out.println("");
        } else {
            System.out.println("|==== LISTA DE DISCOS ====|");
            for (Disco d : discos) {
                System.out.println(d);
            }
        }
    }

    public void cadastrarDisco() {
        System.out.println("Digite o título do disco:");
        String titulo = scanner.nextLine();
        System.out.println("Digite o ano de lançamento do disco:");
        int ano = scanner.nextInt();
        scanner.nextLine(); //limpar o buffer

        List<String> faixas = new ArrayList<>(); //cria lista de faixas

        System.out.println("Digite as faixas uma por linha (deixe uma linha em branco para finalizar):"); //adiciona faixas até uma linha vazia ser inserida
        while (true) {
            String faixa = scanner.nextLine();
            if (faixa != "") {
                faixas.add(faixa);
            } else {
                break;
            }
        }

        Disco novoDisco = new Disco(titulo, ano, faixas);
        discos.add(novoDisco);
        System.out.println("Disco cadastrado com sucesso.");
        System.out.println("");
    }

    public void cadastrarArtista() {
        System.out.println("Digite o nome do artista:");
        String nomeArtista = scanner.nextLine();
        System.out.println("Digite o gênero musical do artista:");
        String generoArtista = scanner.nextLine();


        Artista novoArtista = new Artista(nomeArtista, generoArtista);
        artistas.add(novoArtista);
        System.out.println("Artista cadastrado com sucesso.");
        System.out.println("");
    }

    public void associarArtistaADisco() {
        if (discos.isEmpty()) {
            System.out.println("Nenhum disco cadastrado.");
            System.out.println("Primeiro cadastre um disco para que seja possível associá-lo a um artista.");
        } else if (artistas.isEmpty()) {
            System.out.println("Nenhum artista cadastrado.");
            System.out.println("Primeiro cadastre um artista para que seja possível associá-lo a um disco.");
        } else {
            listarDiscos();
            System.out.println("Digite o título do disco ao qual deseja associar um artista:");
            String tituloDisco = scanner.nextLine();
            Disco disco = buscarDisco(tituloDisco);
    
            if (disco != null) {
                listarArtistas();
                System.out.println("Digite o nome do artista que deseja associar ao disco:");
                String nomeArtista = scanner.nextLine();
                Artista artista = buscarArtista(nomeArtista);
    
                if (artista != null) {
                    disco.setArtista(artista);
                    System.out.println("Artista associado ao disco com sucesso.");
                } else {
                    System.out.println("Artista não encontrado.");
                }
            } else {
                System.out.println("Disco não encontrado.");
            }
        }
    }

    public void listarArtistas() {
        if (artistas.isEmpty()) {
            System.out.println("Nenhum artista cadastrado.");
        } else {
            System.out.println("|==== LISTA DE ARTISTAS ====|");
            for (Artista a : artistas) {
                System.out.println(a);
            }
        }
    }
    
    private Artista buscarArtista(String nome) {
        for (Artista artista : artistas) {
            if (artista.getNomeArtista().equalsIgnoreCase(nome)) {
                return artista;
            }
        }
        return null;
    }
    
    public void editarDiscoOuArtista() {
        System.out.println("Deseja editar um disco ou um artista? (Digite 'disco' ou 'artista')");
        String escolha = scanner.nextLine().toLowerCase();
    
        if (escolha.equals("disco")) {
            listarDiscos();
            System.out.println("Digite o título do disco que deseja editar:");
            String titulo = scanner.nextLine();
            Disco disco = buscarDisco(titulo);
    
            if (disco != null) {
                System.out.println("Digite o novo título do disco (ou pressione Enter para manter o atual):");
                String novoTitulo = scanner.nextLine();
                if (!novoTitulo.isEmpty()) {
                    disco.setNome(novoTitulo);
                }
    
                System.out.println("Digite o novo ano de lançamento (ou pressione Enter para manter o atual):");
                String novoAno = scanner.nextLine();
                if (!novoAno.isEmpty()) {
                    disco.setLancamento(Integer.parseInt(novoAno));
                }
    
                System.out.println("Deseja atualizar as faixas? (s/n)");
                if (scanner.nextLine().equalsIgnoreCase("s")) {
                    List<String> novasFaixas = new ArrayList<>();
                    System.out.println("Digite as faixas uma por linha (deixe uma linha em branco para finalizar):");
                    while (true) {
                        String faixa = scanner.nextLine();
                        if (faixa.isEmpty()) break;
                        novasFaixas.add(faixa);
                    }
                    disco.setFaixas(novasFaixas);
                }
    
                System.out.println("Disco atualizado com sucesso.");
            } else {
                System.out.println("Disco não encontrado.");
            }
    
        } else if (escolha.equals("artista")) {
            listarArtistas();
            System.out.println("Digite o nome do artista que deseja editar:");
            String nomeArtista = scanner.nextLine();
            Artista artista = buscarArtista(nomeArtista);
    
            if (artista != null) {
                System.out.println("Digite o novo nome do artista (ou pressione Enter para manter o atual):");
                String novoNome = scanner.nextLine();
                if (!novoNome.isEmpty()) {
                    artista.setNomeArtista(novoNome);
                }
    
                System.out.println("Digite o novo gênero do artista (ou pressione Enter para manter o atual):");
                String novoGenero = scanner.nextLine();
                if (!novoGenero.isEmpty()) {
                    artista.setGenero(novoGenero);
                }
    
                System.out.println("Artista atualizado com sucesso.");
            } else {
                System.out.println("Artista não encontrado.");
            }
        } else {
            System.out.println("Opção inválida.");
        }
    }
    
    private Disco buscarDisco(String titulo) {
        for (Disco disco : discos) {
            if (disco.getNome().equals(titulo)) {
                return disco;
            }
        }
        return null;
    }

    public void removerDiscoOuArtista() {
        System.out.println("Deseja remover um disco ou um artista? ");
        {
            if (discos.isEmpty()) {
                System.out.println("Nenhum disco cadastrado.");
                System.out.println("");
            } else {
                listarDiscos();
                System.out.println("Digite o titulo do disco que deseja remover: ");
                String titulo = scanner.nextLine();
                Disco disco = buscarDisco(titulo);

                if (disco != null) {
                    discos.remove(disco);
                    System.out.println("Disco removido com sucesso.");
                    System.out.println("Deseja continuar removendo? [s/n]");
                    String continuar = scanner.nextLine();
                    if (continuar.equalsIgnoreCase("s")) {
                        removerDiscoOuArtista();
                    }
                } else {
                    System.out.println("Disco não encontrado.");
                }
            }
        }
    }
}