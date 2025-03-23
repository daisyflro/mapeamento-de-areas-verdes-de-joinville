package repositories;

import models.Localizacao;
import java.util.ArrayList;

public class LocalizacaoRepository {

    private static ArrayList<Localizacao> LOCALIZACOES = new ArrayList<>();

    public void salvar(Localizacao novaLocalizacao){
        novaLocalizacao.setId(LOCALIZACOES.size()+1);
        LOCALIZACOES.add(novaLocalizacao);
    }

    public Localizacao buscar(int idLocalizacao){
        for(Localizacao localizacao : LOCALIZACOES){
            if(idLocalizacao ==  localizacao.getId()){
                return localizacao;
            }
        }
        
        return null;
    }
}
