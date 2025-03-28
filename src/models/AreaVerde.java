package models;

import repositories.LocalizacaoRepository;

import java.util.ArrayList;
import java.util.List;

public class AreaVerde {
    private int id;
    private String nome;
    private Localizacao localizacao;
    private String tipoVegetacao;
    private String horarioFuncionamento;
    private List<String> atividadesDisponiveis;
    private List<Avaliacao> listaAvaliacoes;

    public AreaVerde(String nome, String tipoVegetacao, String horarioFuncionamento, List<String> atividadesDisponiveis) {
        this.nome = nome;
        this.tipoVegetacao = tipoVegetacao;
        this.horarioFuncionamento = horarioFuncionamento;
        this.atividadesDisponiveis = atividadesDisponiveis;
        this.listaAvaliacoes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Localizacao getLocalizacao() {
        LocalizacaoRepository localizacao = new LocalizacaoRepository();
        return localizacao.buscarByAreaVerde(id);
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public String getTipoVegetacao() {
        return tipoVegetacao;
    }

    public void setTipoVegetacao(String tipoVegetacao) {
        this.tipoVegetacao = tipoVegetacao;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public List<String> getAtividadesDisponiveis() {
        return atividadesDisponiveis;
    }

    public void setAtividadesDisponiveis(List<String> atividadesDisponiveis) {
        this.atividadesDisponiveis = atividadesDisponiveis;
    }

    public void setListaAvaliacoes(List<Avaliacao> listaAvaliacoes) {
        this.listaAvaliacoes = listaAvaliacoes;
    }

    public List<Avaliacao> getListaAvaliacoes() {
        return listaAvaliacoes;
    }

    public void adicionarAvaliacao(Avaliacao avaliacao) {
        listaAvaliacoes.add(avaliacao);
    }

    public double calcularMedia() {
        if (listaAvaliacoes.isEmpty()) return 0;

        double soma = 0;
        for (Avaliacao avaliacao : listaAvaliacoes) {
            soma += avaliacao.calcularMedia();
        }
        return soma / listaAvaliacoes.size();
    }

    public String DetalhesToString() {
        return "Informações: " +
                "\nID: " + id +
                "\nNome: " + nome +
                "\nHorário de Funcionamento: " + horarioFuncionamento +
                "\nLocalização: " + getLocalizacao().toString() +
                "\nTipo de vegetação: " + tipoVegetacao +
                "\nAtividades Disponíveis: " + String.join(", ", atividadesDisponiveis) +
                "\nAvaliação: " + calcularMedia();
    }

    @Override
    public String toString() {
        return "Área Verde - ID: " + id +
                "\nNome: " + nome +
                "\nTipo de vegetação: " + tipoVegetacao +
                "\nAvaliação: " + calcularMedia() +
                "\n";
    }
}
