import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma garagem de locomotivas que mantém locomotivas disponíveis.
 */
public class GaragemLocomotivas {
    private List<Locomotiva> locomotivasDisponiveis;

    /**
     * Cria uma nova instância de GaragemLocomotivas.
     */
    public GaragemLocomotivas() {
        this.locomotivasDisponiveis = new ArrayList<>();
    }

    /**
     * Adiciona uma locomotiva à garagem.
     *
     * @param locomotiva A locomotiva a ser adicionada à garagem.
     */
    public void adicionarLocomotiva(Locomotiva locomotiva) {
        locomotivasDisponiveis.add(locomotiva);
    }

    /**
     * Remove uma locomotiva da garagem.
     *
     * @param locomotiva A locomotiva a ser removida da garagem.
     */
    public void removerLocomotiva(Locomotiva locomotiva) {
        locomotivasDisponiveis.remove(locomotiva);
    }

    /**
     * Lista todas as locomotivas disponíveis na garagem.
     *
     * @return Uma lista de locomotivas disponíveis.
     */
    public List<Locomotiva> listarLocomotivasDisponiveis() {
        return new ArrayList<>(locomotivasDisponiveis); // Retorna uma cópia da lista de locomotivas disponíveis
    }

    public Locomotiva getLocomotivaPorId(int idLocomotiva) {
        for (Locomotiva locomotiva : locomotivasDisponiveis) {
            if (locomotiva.getIdLoc() == idLocomotiva) {
                return locomotiva;
            }
        }
        return null; // Locomotiva não encontrada
    }

}
