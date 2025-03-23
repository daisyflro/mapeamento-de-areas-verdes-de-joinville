package repositories;

import models.Avaliacao;
import models.AreaVerde;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoRepository {

    private static ArrayList<Avaliacao> AVALIACOES = new ArrayList<>();

    public void salvar(Avaliacao novaAvaliacao, AreaVerde areaVerde) {
        novaAvaliacao.setId(AVALIACOES.size()+1);
        AVALIACOES.add(novaAvaliacao);
        areaVerde.adicionarAvaliacao(novaAvaliacao);
    }

    public Avaliacao buscar(int idAvaliacao){
        for(Avaliacao avaliacao : AVALIACOES) {
            if (idAvaliacao == avaliacao.getId()) {
                return avaliacao;
            }
        }

        return null;
    }

    public List<Avaliacao> listarTodas() {
        return AVALIACOES;
    }
}
