package trabalhopraticosaude;

import java.util.ArrayList;
import java.util.List;

class PlanoSaude {

    private double preco;
    private List<String> clinicas;
    private List<String> especialidades;
    private String nome;

    public PlanoSaude(double preco, List<String> clinicas, List<String> especialidades) {
        this.preco = preco;
        this.clinicas = clinicas;
        this.especialidades = especialidades;
    }

    public PlanoSaude(double preco, List<String> clinicas, List<String> especialidades, String nome) {
        this.preco = preco;
        this.clinicas = clinicas;
        this.especialidades = especialidades;
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

    public List<String> getClinicas() {
        return clinicas;
    }

    public List<String> getEspecialidades() {
        return especialidades;
    }
}
