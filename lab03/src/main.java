void main() {
    ExibirMenu();
}

public static void ExibirMenu() {
    FilmNow catalogo1 = new FilmNow();
    Scanner sc = new Scanner(System.in);
    String acao;
    String saida;
    do {
        IO.print(
                "(A)Adicionar filme" +
                        "\n(M)Mostrar todos" +
                        "\n(D)Detalhar " +
                        "\n(E)Exibir HotList" +
                        "\n(H)Atribuir Hot " +
                        "\n(R)Remover Hot" +
                        "\n(S)Sair" +
                        "\n" +
                        "\nOpção> ");
        acao = sc.nextLine();
        switch (acao) {
            case ("A"):
                IO.print("Posição> ");
                int posicao = sc.nextInt();
                sc.nextLine();
                IO.print("Nome> ");
                String nome = sc.nextLine();
                IO.print("Ano> ");
                String anoDeLancamento = sc.nextLine();
                IO.print("Local> ");
                String localParaAssistir = sc.nextLine();
                saida = catalogo1.AdicionarFilme(nome, anoDeLancamento, localParaAssistir, posicao);
                IO.println(saida + "\n");
                break;
            case ("M"):
                saida = catalogo1.toString();
                IO.println(saida + "\n");
                break;
            case ("D"):
                IO.print("Posição> ");
                posicao = sc.nextInt();
                saida = catalogo1.DetalharFilme(posicao);
                IO.println(saida + "\n");
                sc.nextLine();
                break;
            case ("E"):
                IO.println();
                saida = catalogo1.ExibirHotList();
                IO.println(saida + "\n");
                break;
            case ("H"):
                IO.print("Filme> ");
                int indiceFilme = sc.nextInt();
                IO.print("Posicao> ");
                int indiceHotlist = sc.nextInt();
                saida = catalogo1.AdicionaHot(indiceFilme, indiceHotlist);
                IO.println(saida + "\n");
                sc.nextLine();
                break;
            case ("R"):
                IO.print("Posicao> ");
                posicao = sc.nextInt();
                catalogo1.RemoverHot(posicao);
                sc.nextLine();
                break;
            default:
                IO.println("OPÇÃO INVÁLIDA!");
                break;
        }
    } while (!acao.equals("S"));
}