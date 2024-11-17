package src;

public class Convidado {
    private String nomeConvidado;
    private boolean isVIP;

    public Convidado(String nomeConvidado, boolean isVIP) {
        this.nomeConvidado = nomeConvidado;
        this.isVIP = false;
    }

    public String getNomeConvidado() {
        return nomeConvidado;
    }

    public boolean isVIP() {
        return isVIP;
    }

    @Override
    public String toString() {
        return nomeConvidado + (isVIP ? " (VIP)" : "");
    }


}
