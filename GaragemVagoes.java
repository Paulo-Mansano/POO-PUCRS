import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma garagem de vagões que mantém vagões disponíveis.
 */
public class GaragemVagoes {
    private List<Vagao> vagoesDisponiveis;

    /**
     * Cria uma nova instância de GaragemVagoes.
     */
    public GaragemVagoes() {
        this.vagoesDisponiveis = new ArrayList<>();
    }

    /**
     * Adiciona um vagão à garagem.
     *
     * @param vagao O vagão a ser adicionado à garagem.
     */
    public void adicionarVagao(Vagao vagao) {
        vagoesDisponiveis.add(vagao);
    }

    /**
     * Remove um vagão da garagem.
     *
     * @param vagao O vagão a ser removido da garagem.
     */
    public void removerVagao(Vagao vagao) {
        vagoesDisponiveis.remove(vagao);
    }

    /**
     * Lista todos os vagões disponíveis na garagem.
     *
     * @return Uma lista de vagões disponíveis.
     */
    public List<Vagao> listarVagoesDisponiveis() {
        List<Vagao> vagoesLivres = new ArrayList<>();
        for (Vagao vagao : vagoesDisponiveis) {
            if (vagao.getComposicao() == -1) {
                vagoesLivres.add(vagao);
            }
        }
        return vagoesLivres;
    }

    public Vagao getVagaoPorId(int idVagao) {
        for (Vagao vagao : vagoesDisponiveis) {
            if (vagao.getIdentificador() == idVagao) {
                return vagao;
            }
        }
        return null; // Vagão não encontrado
    }

}
