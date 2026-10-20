
public class FilmNow {
    private final Filme[] filmes;
    private final Filme[] hotList;

    public FilmNow() {
        filmes = new Filme[100];
        hotList = new Filme[10];
    }

    public String AdicionarFilme(String nome, String anoDeLancamento, String localParaAssistir, int posicaoNaLista) {
        posicaoNaLista -= 1;
        Filme candidatoAdiciona = new Filme(nome, anoDeLancamento, localParaAssistir);
        if ((posicaoNaLista >= 0) && (posicaoNaLista <= 99)) {
            if (!(nome == null || localParaAssistir == null)) {
                for (int i = 0; i < 100; i++) {
                    if (filmes[i] != null) {
                        if (filmes[i].equals(candidatoAdiciona)) {
                            return "FILME JA ADICIONADO";
                        }
                    }
                }
                filmes[posicaoNaLista] = candidatoAdiciona;
                return "FILME ADICIONADO";
            } else {
                System.out.println("FILME INVALIDO");
            }
        }
        return "POSIÇÃO INVÁLIDA";
        }

    public String DetalharFilme(int indice) {
        indice -= 1;
        if (filmes[indice] != null) {
            for (int i = 0; i < 10; i++) {
                if (hotList[i] != null) {
                    if (hotList[i].equals(filmes[indice])) {
                        return "\uD83D\uDD25" + filmes[indice].toString();
                    }
                }
            }
            return filmes[indice].toString();
        } else {
            return "FILME NÃO CADASTRADO!";
        }
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
            if (filmes[i] != null) {
                conc.append(i + 1).append(" - ").append(filmes[i].getNome());
            }
        }
        return conc.toString();
    }

    public String AdicionaHot(int posicaoFilme, int posicaoHot) {
        posicaoFilme -= 1;
        posicaoHot -= 1;
        Filme hot = filmes[posicaoFilme];
        for (int i = 0; i < 10; i++) {
            if (hotList[i] != null) {
                if (hotList[i].equals(hot)) {
                    return "FILME JÁ ADICIONADO NA HOTLIST!";
                }
            }
        }
        hotList[posicaoHot] = hot;
        return "ADICIONADO À HOTLIST NA POSIÇÃO " + (posicaoHot+1) + "!";
    }

    public String ExibirHotList() {
        StringBuilder conc = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            if (hotList[i] != null){
                conc.append(i + 1).append(" - ").append(hotList[i].getNome()).append(",  ").append(hotList[i].getAnoDeLancamento());
            }
        }
        return conc.toString();
    }

    public void RemoverHot(int posicaoHot) {
        posicaoHot -= 1;
        hotList[posicaoHot] = null;
    }
}