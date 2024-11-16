package src;

import java.util.ArrayList;

public class Mesa {
    private int id;
    private String decoracaoMesa = "padrão";
    private int cadeiras;
    private ArrayList<Convidado> convidados;


    public Mesa(int id, int cadeiras) {
        this.id = id;
        this.cadeiras = cadeiras;
        this.convidados = new ArrayList<>();
    }

    public void addConvidado(Convidado convidado) {
        if (convidados.size() < cadeiras) {
            convidados.add(convidado);
        } else {
            System.out.println("A mesa " + id + " já está cheia!");
        }
    }

    public boolean possuiVIP() {
        for (Convidado convidado : convidados) {
            if (convidado.isVIP()) {
                return true;
            }
        }
        return false;

    }

    public void setDecoracaoMesa(String decoracaoMesa) {
        if (possuiVIP()) {
            this.decoracaoMesa = decoracaoMesa;
        } else {
            System.out.println("Apenas mesas com convidados VIP podem ser personalizadas.");
        }
    }

    @Override
    public String toString() {
        return "Mesa " + id + " (Cadeiras: " + cadeiras + ", Decoração: " + decoracaoMesa + ", Convidados: " + convidados + ")";
    }





    public int getId() {
        return id;
    }

    public String getDecoracaoMesa() {
        return decoracaoMesa;
    }

    public int getCadeiras() {
        return cadeiras;
    }


}
