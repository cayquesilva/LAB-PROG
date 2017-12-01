/*
 * Aluno: <David Félix da Silva Filho>
 */
package lab06;

import java.util.*;

/**
 * Classe CD de músicas de um artista.
 * @author david
 */

public class CD {
    
    private String artista;
    private String tituloCD;
    private String musicaPrincipal;
    private List<String> listaDeMusicas;
    private int M;

    /**
     * Construtor que recebe o artista, título e a quantidade de músicas.
     * @param artista Artista do CD.
     * @param tituloCD Título do CD do artista/banda/etc;
     * @param M Quantidade de músicas informada pelo usuário.
     * @throws Exception Se algum parâmetro passado for inválido, será lançado uma exceção.
     */
    public CD(String artista, String tituloCD, int M) throws Exception{   
        verificaParametros(artista, tituloCD, M);
        listaDeMusicas  = new ArrayList<>(this.M);
    }

    /**
     * Construtor que recebe o artista e o título do CD.
     * @param artista Artista compositor do CD.
     * @param tituloCD Título do CD do artista/banda/etc.
     * @throws Exception Se algum parâmetro passado for inválido, será lançado uma exceção.
     */
    public CD(String artista, String tituloCD) throws Exception{
        M = 10;
        verificaParametros(artista, tituloCD, M); 
        listaDeMusicas  = new ArrayList<>(this.M);
    }
    
    private void verificaParametros(String artista, String tituloCD, int M) throws Exception{
        if(tituloCD == null || tituloCD.trim().isEmpty()){
            throw new Exception ("O nome do CD não pode ser vazio.");
        }else{
            this.tituloCD = tituloCD;
        }
        if(artista == null || artista.trim().isEmpty()){
            throw new Exception ("O nome do compositor do CD não pode ser vazio.");
        }else{
            this.artista = artista;
        }
        if(M <= 0){
            throw new Exception ("O número de músicas deve ser maior do que 0(zero).");
        }else{
            this.M = M;
        }
        
    }

    /**
     * Retorna o nome do artista.
     * @return O artista.
     */
    public String getArtista() {
        return artista;
    }

    /**
     * Retorna o nome do CD.
     * @return O nome do CD.
     */
    public String getTituloCD() {
        return tituloCD;
    }

    /**
     * Retorna a trilha principal do CD.
     * @return A trilha principal do CD.
     */
    public String getMusicaPrincipal() {
        return musicaPrincipal;
    }

    /**
     * Define alguma música do CD como principal.
     * @param faixa A música que o usuário deseja colocar como principal.
     * @return Retorna o resultado da tentativa de alteração.
     */
    public boolean setMusicaPrincipal(String faixa){
        if (listaDeMusicas.contains(faixa)){
            this.musicaPrincipal = faixa;
            return true;
        }
        return false;
    }
    
    /**
     * Retorna a i-ésima faixa do CD.
     * @param indice Se não for válido retorna null.
     * @return A i-ésima faixa do CD se o índice for válido
     */ 
    public String getIesimaMusica(int indice){
	if(indice >= 0 && indice < listaDeMusicas.size()){
            return listaDeMusicas.get(indice);
	}
	return null;
    }
    
    /**
     * Cadastra uma nova faixa no CD. 
     * @param faixa A música a ser cadastrada no CD.
     * @return true se a música for adicionada com sucesso e false caso não seja adicionada.
     */
    public boolean cadastraMusica(String faixa){
        if(!(faixa == null) && listaDeMusicas.size() < M){
            listaDeMusicas.add(faixa);
            return true;
        }
        return false;
    }

    /**
     * Retorna todas as músicas do CD. 
     * @return Todas as músicas do CD.
     */
    public List<String> getListaDeMusicas() {
        return listaDeMusicas;
    }
    
    /**
     * Retorna a quantidade de músicas.
     * @return A quantidade de músicas.
     */
    public int getM() {
        return M;
    }
    
    /**
     * Faz a comparação de 2 CD's
     */
    @Override
    public boolean equals(Object cdMusicas){
        if (cdMusicas instanceof CD && cdMusicas != null){
            CD cdTemp = (CD) cdMusicas;
            if (getArtista().equals(cdTemp.getArtista()) && getTituloCD().equals(cdTemp.getTituloCD())){
                return true;
            }
            
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "CD{" + "Artista: " + artista + ", Título do CD: " + tituloCD + ", Música Principal: " + musicaPrincipal + ", Lista de Músicas: " + listaDeMusicas + ", Quantidade de Músicas: " + M + '}';
    }
     
}