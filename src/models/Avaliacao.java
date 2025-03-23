package models;

public class Avaliacao {
    private int  id;
    private int idAreaVerde;
    private int  notaQuantidadeArvores;
    private int  notaQualidadeAr;
    private int  notaPoluicaoSonora;
    private int  notaColetaResiduos;
    private int  notaTransportePublico;

    public Avaliacao(int id, int idAreaVerde, int notaQuantidadeArvores, int notaQualidadeAr, int notaPoluicaoSonora, int notaColetaResiduos, int notaTransportePublico) {
        this.id = id;
        this.idAreaVerde = idAreaVerde;
        this.notaQuantidadeArvores = notaQuantidadeArvores;
        this.notaQualidadeAr = notaQualidadeAr;
        this.notaPoluicaoSonora = notaPoluicaoSonora;
        this.notaColetaResiduos = notaColetaResiduos;
        this.notaTransportePublico = notaTransportePublico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAreaVerde() {
        return idAreaVerde;
    }

    public void setIdAreaVerde(int idAreaVerde) {
        this.idAreaVerde = idAreaVerde;
    }

    public int getNotaQuantidadeArvores() {
        return notaQuantidadeArvores;
    }

    public void setNotaQuantidadeArvores(int notaQuantidadeArvores) {
        this.notaQuantidadeArvores = notaQuantidadeArvores;
    }

    public int getNotaQualidadeAr() {
        return notaQualidadeAr;
    }

    public void setNotaQualidadeAr(int notaQualidadeAr) {
        this.notaQualidadeAr = notaQualidadeAr;
    }

    public int getNotaPoluicaoSonora() {
        return notaPoluicaoSonora;
    }

    public void setNotaPoluicaoSonora(int notaPoluicaoSonora) {
        this.notaPoluicaoSonora = notaPoluicaoSonora;
    }

    public int getNotaColetaResiduos() {
        return notaColetaResiduos;
    }

    public void setNotaColetaResiduos(int notaColetaResiduos) {
        this.notaColetaResiduos = notaColetaResiduos;
    }

    public int getNotaTransportePublico() {
        return notaTransportePublico;
    }

    public void setNotaTransportePublico(int notaTransportePublico) {
        this.notaTransportePublico = notaTransportePublico;
    }

    public double calcularMedia() {
        return (double) (notaColetaResiduos + notaQualidadeAr + notaPoluicaoSonora + notaQuantidadeArvores + notaTransportePublico) / 5;
    }

    @Override
    public String toString() {
        return "Avaliações: " +
                "\nQualidade do Ar: " + notaQualidadeAr +
                "\nQuantidade de Árvores: " + notaQuantidadeArvores +
                "\nColeta de Resíduos: " + notaColetaResiduos +
                "\nAusência de Poluição Sonora: " + notaPoluicaoSonora +
                "\nFacilidade de chegar utilizando transporte público: " + notaTransportePublico;
    }
}
