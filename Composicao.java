import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma composição ferroviária que pode conter locomotivas e vagões.
 */
public class Composicao {
    private int identificador;
    private List<Locomotiva> locomotivas;
    private List<Vagao> vagoes;

    /**
     * Cria uma nova composição com o identificador especificado.
     *
     * @param identificador O identificador da composição (deve ser não negativo).
     * @throws IllegalArgumentException Se o identificador for negativo.
     */
    public Composicao(int identificador) {
        if (identificador < 0) {
            throw new IllegalArgumentException("O identificador deve ser não negativo.");
        }
        this.identificador = identificador;
        this.locomotivas = new ArrayList<>();
        this.vagoes = new ArrayList<>();
    }

    /**
     * Adiciona uma locomotiva à composição.
     *
     * @param locomotiva A locomotiva a ser adicionada.
     */
    public void adicionarLocomotiva(Locomotiva locomotiva) {
        locomotivas.add(locomotiva);
    }

    /**
     * Remove uma locomotiva da composição.
     *
     * @param locomotiva A locomotiva a ser removida.
     */
    public void removerLocomotiva(Locomotiva locomotiva) {
        locomotivas.remove(locomotiva);
    }

    /**
     * Adiciona um vagão à composição.
     *
     * @param vagao O vagão a ser adicionado.
     */
    public void adicionarVagao(Vagao vagao) {
        vagoes.add(vagao);
    }

    /**
     * Remove um vagão da composição.
     *
     * @param vagao O vagão a ser removido.
     */
    public void removerVagao(Vagao vagao) {
        vagoes.remove(vagao);
    }

    /**
     * Calcula a capacidade de tração da composição com base nas locomotivas
     * presentes.
     *
     * @return A capacidade de tração da composição.
     */
    public double calcularCapacidadeDeTracao() {
        int numLocomotivas = locomotivas.size();
        double capacidadeTotal = 0.0;

        for (Locomotiva locomotiva : locomotivas) {
            capacidadeTotal += locomotiva.getPesoMax();
        }

        // Redução de capacidade após a segunda locomotiva
        if (numLocomotivas > 1) {
            capacidadeTotal *= Math.pow(0.9, numLocomotivas - 1);
        }

        return capacidadeTotal;
    }

    /**
     * Verifica se é possível inserir uma locomotiva na composição.
     *
     * @param locomotiva A locomotiva a ser inserida.
     * @return true se a locomotiva pode ser inserida, caso contrário, false.
     */
    public boolean podeInserirLocomotiva(Locomotiva locomotiva) {
        // Verifique se a composição já atingiu o número máximo de vagões permitido
        if (locomotivas.size() + 1 > locomotiva.getQntVagoes()) {
            return false;
        }

        // Verifique se a locomotiva pode puxar o peso total da composição
        double pesoTotal = 0.0;
        for (Locomotiva loc : locomotivas) {
            pesoTotal += loc.getPesoMax();
        }

        // Redução de capacidade após a segunda locomotiva
        if (locomotivas.size() > 1) {
            pesoTotal *= Math.pow(0.9, locomotivas.size() - 1);
        }

        pesoTotal += locomotiva.getPesoMax();

        if (pesoTotal > locomotiva.getPesoMax()) {
            return false;
        }

        return true;
    }

    /**
     * Obtém o identificador da composição.
     *
     * @return O identificador da composição.
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * Define o identificador da composição.
     *
     * @param identificador O novo identificador da composição.
     */
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    /**
     * Obtém uma cópia da lista de locomotivas na composição.
     *
     * @return Uma lista de locomotivas na composição.
     */
    public List<Locomotiva> getLocomotivas() {
        return new ArrayList<>(locomotivas); // Retorna uma cópia da lista de locomotivas
    }

    /**
     * Obtém uma cópia da lista de vagões na composição.
     *
     * @return Uma lista de vagões na composição.
     */
    public List<Vagao> getVagoes() {
        return new ArrayList<>(vagoes); // Retorna uma cópia da lista de vagões
    }

    /**
     * Obtém uma representação em string da composição.
     *
     * @return Uma representação em string da composição.
     */
    @Override
    public String toString() {
        return "Composicao #" + identificador + ": Locomotivas = " + locomotivas.size() + ", Vagoes = " + vagoes.size();
    }
}
