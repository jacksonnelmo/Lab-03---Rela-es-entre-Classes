import java.util.Objects;

public class Filme {
    private final String nome;
    private final String anoDeLancamento;
    private final String localParaAssistir;

    public Filme(String nome, String anoDeLancamento, String localParaAssistir) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
        this.localParaAssistir = localParaAssistir;
    }

    public String getNome() {
        return nome;
    }

    public String getAnoDeLancamento() {
        return anoDeLancamento;
    }

    @Override
    public String toString() {
        return nome + ", " + anoDeLancamento + localParaAssistir;
    }

@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Filme outro)) return false;

    return this.nome.equals(outro.nome) && this.anoDeLancamento.equals(outro.anoDeLancamento);
    }

    public int hashCode() {
        return Objects.hash(nome, anoDeLancamento);
    }

}