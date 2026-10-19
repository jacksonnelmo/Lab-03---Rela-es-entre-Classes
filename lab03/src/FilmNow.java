import java.util.Scanner;

public class FilmNow {
    private final Filme[] filmes;
    private final Filme[] hotList;

    public FilmNow() {
        filmes = new Filme[100];
        hotList = new Filme[10];
    }

    public void AdicionarFilme(String nome, String anoDeLancamento, String localParaAssistir, int posicaoNaLista) {
        if ((posicaoNaLista >= 1) && (posicaoNaLista <= 100)) {
            if (!(nome == null || localParaAssistir == null)) {
                Filme candidatoAdiciona = new Filme(nome, anoDeLancamento, localParaAssistir);
                for (int i = 0; i < 100; i++) {
                    if (filmes[i] != null) {
                        if (filmes[i].equals(candidatoAdiciona)) {
                            System.out.println("FILME JA ADICIONADO");
                            break;
                        } else {
                            filmes[posicaoNaLista] = candidatoAdiciona;
                            System.out.println("FILME ADICIONADO");
                        }
                    }
                }
            } else {
                System.out.println("FILME INVALIDO");
            }
            filmes[posicaoNaLista] = candidatoAdiciona;
            System.out.println("FILME ADICIONADO");

        } else {
            System.out.println("POSIÇÃO INVÁLIDA");
        }
    }

    public String DetalharFilme(int indice) {
        for (int i = 0; i < 10; i++) {
            if (hotList[i].equals(filmes[indice])) {
                return "\uD83D\uDD25" + filmes[indice].toString();
            }
        }
        return filmes[indice].toString();
    }

    /**
     * Representa o metodo Mostrar todos de FilmNow.
     * Imprime na tela uma lista dos filmes cadastrados em FilmNow.
     *
     * @return lista de filmes cadastrados em FilmNow.
     */
    @Override
    public String toString() {
        StringBuilder conc = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            conc.append(i + " - " + filmes[i].getNome());
        }
        return conc.toString();
    }

    public boolean AdicionaHot(int posicaoFilme, int posicaoHot) {
        Filme hot = filmes[posicaoFilme];
        for (int i = 0; i < 10; i++) {
            if (hotList[i].equals(hot)) {
                return false;
            }
        }
        hotList[posicaoHot] = hot;
        return true;
    }

    public String ExibirHotList() {
        StringBuilder conc = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            conc.append(i).append(" - ").append(hotList[i].getNome());
        }
        return conc.toString();
    }

    public void RemoverHot(int posicaoHot) {
        hotList[posicaoHot] = null;
    }
}