/**
 * Classe que representa uma locomotiva.
 */
public class Locomotiva {

    // Variáveis e encapsulamento:

    private int idLoc; // Identificador único da locomotiva.
    private double pesoMax; // Peso máximo suportado pela locomotiva (em toneladas).
    private int qntVagoes; // Quantidade de vagões que a locomotiva pode puxar.
    private Composicao composicao; // Composição à qual a locomotiva está vinculada.

    // Construtores:

    /**
     * Cria uma nova instância de locomotiva com composição.
     *
     * @param idLoc      O identificador único da locomotiva.
     * @param pesoMax    O peso máximo suportado pela locomotiva (em toneladas).
     * @param qntVagoes  A quantidade de vagões que a locomotiva pode puxar.
     * @param composicao A composição à qual a locomotiva está vinculada.
     */
    public Locomotiva(int idLoc, double pesoMax, int qntVagoes, Composicao composicao) {
        this.idLoc = idLoc;
        this.pesoMax = pesoMax;
        this.qntVagoes = qntVagoes;
        this.composicao = composicao;
    }

    /**
     * Cria uma nova instância de locomotiva sem composição.
     *
     * @param idLoc     O identificador único da locomotiva.
     * @param pesoMax   O peso máximo suportado pela locomotiva (em toneladas).
     * @param qntVagoes A quantidade de vagões que a locomotiva pode puxar.
     */
    public Locomotiva(int idLoc, double pesoMax, int qntVagoes) {
        this.idLoc = idLoc;
        this.pesoMax = pesoMax;
        this.qntVagoes = qntVagoes;
        this.composicao = null;
    }

    // Métodos:

    /**
     * Engata a locomotiva em uma composição.
     *
     * @param composicao A composição à qual a locomotiva será engatada.
     * @throws RuntimeException Se a locomotiva já estiver engatada em uma
     *                          composição.
     */
    public void engatarEmComposicao(Composicao composicao) {
        if (this.composicao != null) {
            throw new RuntimeException("Esta locomotiva já está engatada em uma composição.");
        }
        this.composicao = composicao;
        composicao.adicionarLocomotiva(this);
    }

    /**
     * Desengata a locomotiva da composição à qual está vinculada.
     *
     * @throws RuntimeException Se a locomotiva não estiver engatada em nenhuma
     *                          composição.
     */
    public void desengatar() {
        if (this.composicao == null) {
            throw new RuntimeException("Esta locomotiva não está engatada em nenhuma composição.");
        }
        this.composicao.removerLocomotiva(this);
        this.composicao = null;
    }

    /**
     * Obtém a disponibilidade da locomotiva (livre ou ocupada).
     *
     * @return "Livre" se a locomotiva não estiver em uma composição, "Ocupada" caso
     *         contrário.
     */
    public String getDisponibilidade() {
        return (composicao == null) ? "Livre" : "Ocupado";
    }

    // Getters e Setters - Organização:

    /**
     * Obtém o identificador único da locomotiva.
     *
     * @return O identificador da locomotiva.
     */
    public int getIdLoc() {
        return idLoc;
    }

    /**
     * Define o identificador único da locomotiva.
     *
     * @param idLoc O identificador da locomotiva.
     */
    public void setIdLoc(int idLoc) {
        this.idLoc = idLoc;
    }

    /**
     * Obtém o peso máximo suportado pela locomotiva.
     *
     * @return O peso máximo da locomotiva em toneladas.
     */
    public double getPesoMax() {
        return pesoMax;
    }

    /**
     * Define o peso máximo suportado pela locomotiva.
     *
     * @param pesoMax O peso máximo da locomotiva em toneladas.
     */
    public void setPesoMax(double pesoMax) {
        this.pesoMax = pesoMax;
    }

    /**
     * Obtém a quantidade de vagões que a locomotiva pode puxar.
     *
     * @return A quantidade de vagões.
     */
    public int getQntVagoes() {
        return qntVagoes;
    }

    /**
     * Define a quantidade de vagões que a locomotiva pode puxar.
     *
     * @param qntVagoes A quantidade de vagões.
     */
    public void setQntVagoes(int qntVagoes) {
        this.qntVagoes = qntVagoes;
    }

    /**
     * Obtém a composição à qual a locomotiva está vinculada.
     *
     * @return A composição da locomotiva ou null se não estiver vinculada a nenhuma
     *         composição.
     */
    public Composicao getComposicao() {
        return composicao;
    }

    /**
     * Define a composição à qual a locomotiva está vinculada.
     *
     * @param composicao A composição da locomotiva.
     */
    public void setComposicao(Composicao composicao) {
        this.composicao = composicao;
    }

    /**
     * Retorna uma representação em formato de string da locomotiva.
     *
     * @return Uma string que descreve a locomotiva.
     */
    @Override
    public String toString() {
        return "idLoc: " + getIdLoc() + "\n" +
                "pesoMax: " + getPesoMax() + "\n" +
                "qntVagoes: " + getQntVagoes() + "\n" +
                "Composicao: " + getComposicao() + "\n" +
                "pesoMax: " + getPesoMax() + "\n" +
                "Livre: " + getDisponibilidade() + "\n";
    }
}
