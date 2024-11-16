package src;

public class Cardapio {
    private String nomePrato;
    private double precoPrato;


    public Cardapio(String nomePrato, double precoPrato) {
        this.nomePrato = nomePrato;
        this.precoPrato = precoPrato;
    }

    public String getNomePrato() {
        return nomePrato;
    }
    public void setNomePrato(String nomePrato) {
        this.nomePrato = nomePrato;
    }

    public double getPrecoPrato() {
        return precoPrato;
    }
    public void setPrecoPrato(double precoPrato) {
        this.precoPrato = precoPrato;
    }

}
