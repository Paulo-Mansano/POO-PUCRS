import java.util.ArrayList;
import java.util.List;

/**
 * A classe PatioComposicoes representa um pátio de composições ferroviárias.
 */
public class PatioComposicoes {
    private List<Composicao> composicoes;

    /**
     * Construtor que cria uma nova instância do pátio de composições.
     */
    public PatioComposicoes() {
        this.composicoes = new ArrayList<>();
    }

    /**
     * Adiciona uma composição ao pátio.
     *
     * @param composicao A composição a ser adicionada ao pátio.
     */
    public void adicionarComposicao(Composicao composicao) {
        composicoes.add(composicao);
    }

    /**
     * Remove uma composição do pátio.
     *
     * @param composicao A composição a ser removida do pátio.
     */
    public void removerComposicao(Composicao composicao) {
        composicoes.remove(composicao);
    }

    /**
     * Obtém uma composição com base no seu identificador.
     *
     * @param identificador O identificador da composição desejada.
     * @return A composição correspondente ao identificador ou null se não
     *         encontrada.
     */
    public Composicao getComposicaoPorIdentificador(int identificador) {
        for (Composicao composicao : composicoes) {
            if (composicao.getIdentificador() == identificador) {
                return composicao;
            }
        }
        return null; // Composição não encontrada
    }

    /**
     * Lista todas as composições presentes no pátio.
     *
     * @return Uma lista contendo todas as composições atualmente no pátio.
     */
    public List<Composicao> listarComposicoes() {
        return new ArrayList<>(composicoes); // Retorna uma cópia da lista de composições
    }
}
