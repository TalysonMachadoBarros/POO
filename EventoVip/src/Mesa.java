package src;

import java.util.ArrayList;

public class Mesa {
    private int id;
    private String decoracaoMesa = "padrão";
    private int cadeiras;
    private Garcom garcom;
    private ArrayList<Convidado> convidados;


    public Mesa(int id, int cadeiras) {
        this.id = id;
        this.cadeiras = cadeiras;
        this.convidados = new ArrayList<>();
    }

    public boolean adicionarConvidado(Convidado convidado) {
        if (convidados.size() < cadeiras) {
            convidados.add(convidado);
            return true;
        } else {
            System.out.println("A mesa " + id + " já está cheia!");
            return false;
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

    public void atribuirGarcom(Garcom garcom) {
        if (garcom.isDisponivel()) {
            this.garcom = garcom;
            garcom.setDisponivel(false); // Torna o garçom ocupado
        } else {
            System.out.println("O garçom " + garcom.getNome() + " não está disponível!");
        }
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
        return "Mesa " + id + " (Cadeiras: " + cadeiras + ", Garçom: " + (garcom != null ? garcom.getNome() : "Nenhum") + ", Convidados: " + convidados + ")";
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
