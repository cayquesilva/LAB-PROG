/*
 * Aluno: <David Félix da Silva Filho>
 */
package lab06;

import java.util.*;

/**
 * Classe que representa uma coleção de CD's.
 * @author david
 */

public class MinhaCDTeca {
    private List<CD> listaDeCDs;

    /**
     * Construtor que inicializa alguma coleção de CD's.
     */
    public MinhaCDTeca() {
        listaDeCDs = new ArrayList<CD>();
    }
    
    /**
     * Adicionar um CD á lista.
     * @param cd CD que vai er inserido.
     */
    public void adicionaCD(CD cd) throws Exception{
        if(cd != null){
            listaDeCDs.add(cd);
        }else{
            throw new Exception("Informe um CD válido.");
        }
    }
    
    /**
     * Adiciona CD's na coleção
     * @param listaDeCDs Uma lista de CD's que pertence a coleção.
     */
    public void adicionaCDs(List<CD> listaDeCds) throws Exception{
        if(listaDeCds != null){
            for(int i = 0; i < listaDeCds.size(); i++){
                adicionaCD(listaDeCds.get(i));
            }
        }else{
            throw new Exception("Informe uma lista de CD's válida para adicionar.");
        }
        
    }
    
    /**
     * Remove um CD escolhido da lista.
     * @param tituloCD O CD a ser removido.
     * @return Retorna o CD que foi removido.
     */
    public CD removeCD(String tituloCD){
        for(int i = 0; i < listaDeCDs.size(); i++){
            if(tituloCD.equals(listaDeCDs.get(i).getTituloCD())){
                return listaDeCDs.remove(i);
            }
        }
        return null;
    }
    
    /**
     * Remove múltiplos CD's 
     * @param listaDeCDs Uma lista de CD's que serão removidos.
     * @return Se algum CD for removido retorna true senão false.
     */
    public boolean removeCDs(List<CD> listaDeCds){
        boolean remove = false;
        if(listaDeCds.isEmpty()){
            for(int i = 0; i < listaDeCds.size(); i++){
                removeCD(listaDeCds.get(i).getTituloCD());
                remove = true;
            }
        }
        return remove;
    }
    
    /**
     * Pesquisa algum CD.
     * @param nomeCD O CD que deseja pesquisar.
     * @return O CD se pertencer a coleção e retorna null caso não pertença.
     */
    public CD pesquisaCD(String nomeCD){
        for (int i = 0; i < listaDeCDs.size(); i++){
            if(nomeCD.equals(listaDeCDs.get(i).getTituloCD())){
                return listaDeCDs.get(i);
            }
        }
        return null;
        
    }
    
    /**
     * A quantidade de CD's na lista da coleção
     * @return Quantidade de CD's.
     */
    public int numeroDeCDs(){
        return listaDeCDs.size();
    }

    /**
     * Retorna de forma organizada as informações dos CD's.
     * @return as informações dos CD's
     */
    @Override
    public String toString() {
        return "MinhaCDTeca{" + "Lista de CD's" + listaDeCDs + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.listaDeCDs);
        return hash;
    }

    /**
     * Compara duas CDTecas.
     * @return Retorna true caso as coleções tenham os mesmos CD's.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MinhaCDTeca other = (MinhaCDTeca) obj;
        if (!Objects.equals(this.listaDeCDs, other.listaDeCDs)) {
            return false;
        }
        return true;
    }
    
    
    

}
