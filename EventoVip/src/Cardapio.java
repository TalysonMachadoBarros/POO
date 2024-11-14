package src;

public class Cardapio {
    private String nomePrato;
    private double precoPrato;
    private String nomePratoVIP;
    private double precoPratoVIP;

    public Cardapio(String nomePrato, double precoPrato,String nomePratoVIP, double precoPratoVIP) {
        this.nomePrato = nomePrato;
        this.precoPrato = precoPrato;
        this.nomePratoVIP = nomePratoVIP;
        this.precoPratoVIP = precoPratoVIP;
    }

    public String getNomePrato() {
        return nomePrato;
    }

    public double getPrecoPrato() {
        return precoPrato;
    }

    public String getNomePratoVIP() {
        return nomePratoVIP;
    }

    public double getPrecoPratoVIP() {
        return precoPratoVIP;
    }

}
