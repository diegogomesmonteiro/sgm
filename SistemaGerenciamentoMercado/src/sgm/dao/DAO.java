package sgm.dao;

import java.util.List;

public interface DAO <T, C>  {
    public void salvar(T objeto) throws Exception;
    public T consultar(C chaveDePesquisa);
    public T excluir(C chaveDePesquisa) throws Exception;
    public List <T> listar();
    public void alterar(T novoObjeto) throws Exception;
}