import java.util.ArrayList;
import java.util.List;

public class Locomotiva {

    //Variáveis e encapsulamento:
    private int idLoc;
    private double pesoMax; // Unidade de medida: toneladas.
    private int qntVagoes;
    private Composicao composicao;

    private boolean livre = true; //

    //Construtor:

    public Locomotiva(int idLoc, double pesoMax, int qntVagoes, Composicao composicao) {
        this.idLoc = idLoc;
        this.pesoMax = pesoMax;
        this.qntVagoes = qntVagoes;
        this.composicao = null;

        if (this.composicao != null) {
            this.livre = false;
        } else {
            this.livre = false;
        }
    }
    
    //Métodos:
    
    public void engatarEmComposicao(Composicao composicao) {
        if (this.composicao == null) {
            this.composicao = composicao;
            composicao.adicionarLocomotiva(this);
        } else {
            System.out.println("Esta locomotiva já está engatada em uma composição.");
        }
    }

    public void desengatar() {
        if (this.composicao != null) {
            this.composicao.removerLocomotiva(this);
            this.composicao = null;
        } else {
            System.out.println("Esta locomotiva não está engatada em nenhuma composição.");
        }
    }

    public String getDisponibilidade() {
        final String dispLivre = "Livre";
        final String dispOcupado = "Ocupado";

        if (this.livre == true) {
            return dispLivre;           
        } else {
            return dispOcupado;
        }
        
    }

    /**
     * Getters e Setters - Organização:
     * 
     * getMetodoX() {};
     * setMetodoX(type idVar) {};
     * 
     * getMetodoY() {};
     * setMetodoY(type idVar) {};
     * 
     */

    public int getIdLoc() {
        return idLoc;
    }

    public void setIdLoc(int idLoc) {
        this.idLoc = idLoc;
    }

    public double getPesoMax() {
        return pesoMax;
    }

    public void setPesoMaximo(double pesoMax) {
        this.pesoMax = pesoMax;
    }

    public int getQntVagoes() {
        return qntVagoes;
    }

    public void setQntVagoes(int qntVagoes) {
        this.qntVagoes = qntVagoes;
    }

    public Composicao getComposicao() {
        return composicao;
    }

    public void setComposicao(Composicao composicao) {
        this.composicao = composicao;
    }

    /**
     * Método toString() da Classe:
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
