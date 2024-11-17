package src;


public class Garcom {
    private String nome;
    private boolean disponivel;

    public Garcom(String nome) {
        this.nome = nome;
        this.disponivel = true; // Inicialmente, o garçom está disponível
    }

    public String getNome() {
        return nome;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return nome + (disponivel ? " (Disponível)" : " (Ocupado)");
    }
}
