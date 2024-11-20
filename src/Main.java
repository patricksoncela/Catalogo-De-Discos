import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //scanner
        int opcao;

        Disco d1 = new Disco("Album 1",2023);  //Disco criado sem faixas, sendo adicionadas posteriormente
        d1.adicionarFaixa("Faixa 1");
        d1.adicionarFaixa("Faixa 2");

        List<String> faixas = new ArrayList<String>();
        faixas.add("Faixa 1");
        faixas.add("Faixa 2");
        faixas.add("Faixa 3");

        Disco d2 = new Disco("Album 2",2023,faixas);  //Disco criado já com faixas

        do {
            System.out.println("|==== CATÁLOGO DE DISCOS ====|");
            System.out.println("Listar discos disponíveis");
            System.out.println("2 - Cadastrar novo disco");
            System.out.println("3 - Cadastrar novo artista");
            System.out.println("4 - Associar um artista a um disco");
            System.out.println("5 - Editar disco ou artista");
            System.out.println("6 - Remover disco ou artista");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                //case 1: cadastrarDiscos (pensei em fazer os métodos para cada opção na main mas não sei ta certo)
            }

        } while (opcao != 0);
        System.out.println("Saindo...");
    }
}