/**
 * A classe Vagao representa um vagão ferroviário que pode ser integrado em
 * composições.
 */
public class Vagao {
    private int identificador;
    private double capacidadeMaxima;
    private int composicao; // Identificador da composição que está integrando ou -1 se está livre

    /**
     * Cria uma nova instância de Vagao com um identificador e capacidade máxima.
     *
     * @param identificador    O identificador único do vagão (deve ser não
     *                         negativo).
     * @param capacidadeMaxima A capacidade máxima de carga do vagão (deve ser
     *                         positiva).
     * @throws IllegalArgumentException Se o identificador for negativo ou
     *                                  capacidade máxima não for positiva.
     */
    public Vagao(int identificador, double capacidadeMaxima) {
        if (identificador < 0 || capacidadeMaxima <= 0) {
            throw new IllegalArgumentException(
                    "Identificador deve ser não negativo e capacidade máxima deve ser positiva.");
        }
        this.identificador = identificador;
        this.capacidadeMaxima = capacidadeMaxima;
        this.composicao = -1;
    }

    /**
     * Engata o vagão em uma composição específica.
     *
     * @param composicao A composição à qual o vagão será engatado.
     * @throws IllegalStateException Se o vagão já estiver engatado em uma
     *                               composição.
     */
    public void engatarEmComposicao(Composicao composicao) {
        if (this.composicao != -1) {
            throw new IllegalStateException("Este vagão já está engatado em uma composição.");
        }
        this.composicao = composicao.getIdentificador();
    }

    /**
     * Desengata o vagão da composição em que está integrado.
     *
     * @throws IllegalStateException Se o vagão não estiver engatado em nenhuma
     *                               composição.
     */
    public void desengatar() {
        if (this.composicao == -1) {
            throw new IllegalStateException("Este vagão não está engatado em nenhuma composição.");
        }
        this.composicao = -1;
    }

    /**
     * Obtém o identificador único do vagão.
     *
     * @return O identificador único do vagão.
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * Define o identificador único do vagão.
     *
     * @param identificador O identificador único do vagão (deve ser não negativo).
     * @throws IllegalArgumentException Se o identificador for negativo.
     */
    public void setIdentificador(int identificador) {
        if (identificador < 0) {
            throw new IllegalArgumentException("Identificador deve ser não negativo.");
        }
        this.identificador = identificador;
    }

    /**
     * Define a capacidade máxima de carga do vagão.
     *
     * @param capacidadeMaxima A capacidade máxima de carga do vagão (deve ser
     *                         positiva).
     * @throws IllegalArgumentException Se a capacidade máxima não for positiva.
     */
    public void setCapacidadeMaxima(double capacidadeMaxima) {
        if (capacidadeMaxima <= 0) {
            throw new IllegalArgumentException("Capacidade máxima deve ser positiva.");
        }
        this.capacidadeMaxima = capacidadeMaxima;
    }

    /**
     * Obtém o identificador da composição à qual o vagão está integrado, ou -1 se
     * estiver livre.
     *
     * @return O identificador da composição ou -1 se estiver livre.
     */
    public int getComposicao() {
        return composicao;
    }

    /**
     * Obtém a capacidade máxima de carga do vagão.
     *
     * @return A capacidade máxima de carga do vagão.
     */
    public double getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Vagao [Identificador=" + identificador + ", Capacidade Máxima=" + capacidadeMaxima + ", Composição="
                + composicao + "]";
    }
}
