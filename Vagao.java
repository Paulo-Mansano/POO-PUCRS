import java.util.ArrayList;
import java.util.List;

public class Vagao {
    private int identificador;
    private double capacidadeMaxima;
    private Composicao composicao;

    public Vagao(int identificador, double capacidadeMaxima) {
        this.identificador = identificador;
        this.capacidadeMaxima = capacidadeMaxima;
        this.composicao = null;
    }

    public void engatarEmComposicao(Composicao composicao) {
        if (this.composicao == null) {
            this.composicao = composicao;
            composicao.adicionarVagao(this);
        } else {
            System.out.println("Este vagão já está engatado em uma composição.");
        }
    }

    public void desengatar() {
        if (this.composicao != null) {
            this.composicao.removerVagao(this);
            this.composicao = null;
        } else {
            System.out.println("Este vagão não está engatado em nenhuma composição.");
        }
    }
}

