package repositories;

import models.AreaVerde;
import java.util.ArrayList;
import java.util.List;

public class AreaVerdeRepository {

    private static ArrayList<AreaVerde> AREAS_VERDES = new ArrayList<>();

    public void salvar(AreaVerde novaAreaVerde) {
        novaAreaVerde.setId(AREAS_VERDES.size()+1);
        AREAS_VERDES.add(novaAreaVerde);
    }

    public AreaVerde buscar(int idAreaVerde) {
        for(AreaVerde areaVerde : AREAS_VERDES){
            if(idAreaVerde ==  areaVerde.getId()){
                return areaVerde;
            }
        }

        return null;
    }

    public List<AreaVerde> listarTodas() {
        return AREAS_VERDES;
    }
}
