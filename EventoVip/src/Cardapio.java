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

    public double getPrecoPrato() {
        return precoPrato;
    }

}
