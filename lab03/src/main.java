import java.util.Scanner;

public class main {
    static void main(String[] args) {
        ExibirMenu();
    }

    public static void ExibirMenu() {
        FilmNow catalogo1 = new FilmNow();
        Scanner sc = new Scanner(System.in);
        String acao;
        do {
            System.out.println("(A)Adicionar filme\n(M)Mostrar todos\n(D)Detalhar filme\n(E)Exibir HotList\n(H)Atribuir Hot\n(R)Remover Hot\n(S)Sair");
            System.out.print("Opção> ");
            acao = sc.nextLine();
            switch (acao) {
                case ("A"):
                    int posicao = sc.nextInt();
                    String nome = sc.nextLine();
                    String anoDeLancamento = sc.nextLine();
                    String localParaAssistir = sc.nextLine();
                    catalogo1.AdicionarFilme(nome, anoDeLancamento, localParaAssistir, posicao);
                    break;
                case ("M"):
                    catalogo1.toString();
                    break;
                case ("D"):
                    posicao = sc.nextInt();
                    catalogo1.DetalharFilme(posicao);
                    break;
                case ("E"):
                    catalogo1.ExibirHotList();
                    break;
                case ("H"):
                    int filme = sc.nextInt();
                    posicao = sc.nextInt();
                    catalogo1.AdicionaHot(posicao,posicao);
                    break;
                case ("R"):
                    posicao = sc.nextInt();
                    catalogo1.RemoverHot(posicao);
                    break;
                default:
                    System.out.print("OPÇÃO INVÁLIDA!");
                    break;
            }
        } while (!acao.equals("S"));
    }
}