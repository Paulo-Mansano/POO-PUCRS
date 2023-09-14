import java.util.ArrayList;
import java.util.List;

public class Composicao {
    private int identificador;
    private List<Locomotiva> locomotivas;
    private List<Vagao> vagoes;

    public Composicao(int identificador) {
        this.identificador = identificador;
        this.locomotivas = new ArrayList<>();
        this.vagoes = new ArrayList<>();
    }

    public void adicionarLocomotiva(Locomotiva locomotiva) {
        locomotivas.add(locomotiva);
    }

    public void removerLocomotiva(Locomotiva locomotiva) {
        locomotivas.remove(locomotiva);
    }

    public void adicionarVagao(Vagao vagao) {
        vagoes.add(vagao);
    }

    public void removerVagao(Vagao vagao) {
        vagoes.remove(vagao);
    }

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
}
