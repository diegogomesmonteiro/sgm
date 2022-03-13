package sgm.dao;

import sgm.dominio.Mercado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MercadoDAO implements DAO <Mercado, String> {
  
    @Override
    public void salvar(Mercado mercado){
        try {
            Connection conexao = new Conexao().conectar();
            String sql = "insert into mercado values (?,?,?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, mercado.getCnpj());
            stmt.setString(2, mercado.getNome());
            stmt.setString(3, mercado.getNomeFantasia());
            stmt.setString(4, mercado.getEndereco());
            stmt.setInt(5, mercado.getTotalBox());
            stmt.setString(6, mercado.getCnpjPrefeitura());
            stmt.execute();
            stmt.close();
            conexao.close();
        } catch (SQLException erro) {
            System.out.println("BDMercado: " + erro.getMessage());
        }
    }

    @Override
    public Mercado consultar(String cnpj){
        Mercado mercado = null;
        try{
            Connection conexao = new Conexao().conectar();
            String sql = "select * from mercado where cnpj = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cnpj);
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next()){
                mercado = new Mercado(
                resultado.getString("cnpj"),
                resultado.getString("nome"),
                resultado.getString("nome_fantasia"),
                resultado.getString("endereco"),
                resultado.getInt("total_box"),
                resultado.getString("cnpj_prefeitura")
                );
            }
            resultado.close();
            stmt.close();
            conexao.close();
        }catch (SQLException erro) {
            System.out.println("BDMercado: " + erro.getMessage());
        }
        return mercado;
    }

    @Override
    public Mercado excluir(String cnpj) throws Exception{
        Mercado mercado = this.consultar(cnpj);
        try {
            Connection conexao = new Conexao().conectar();
            String sql = "delete from mercado where cnpj = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cnpj);
            stmt.execute();
            stmt.close();
            conexao.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
            throw new Exception("Existe contratos vinculados a este mercado. \n"
                    + "Exclua os contratos vinculados a este mercado.\n"
                    + "Exclusão do mercado não realizada.");            
        }
        return mercado;
    }

    @Override
    public List <Mercado> listar(){
        Mercado mercado = null;
        List <Mercado> mercados = new ArrayList<>();
        try{
            Connection conexao = new Conexao().conectar();
            String sql = "select * from mercado";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next()){
                mercado = new Mercado(
                resultado.getString("cnpj"),
                resultado.getString("nome"),
                resultado.getString("nome_fantasia"),
                resultado.getString("endereco"),
                resultado.getInt("total_box"),
                resultado.getString("cnpj_prefeitura")
                );
                mercados.add(mercado);
            }
            resultado.close();
            stmt.close();
            conexao.close();
        }catch (SQLException erro) {
            System.out.println("BDMercado: " + erro.getMessage());
        }
        
        Collections.sort(mercados);
        return mercados;
    }
    
    @Override
    public void alterar(Mercado mercado){
        try {
            Connection conexao = new Conexao().conectar();
            String sql = "update mercado set nome=?, nome_fantasia=?, endereco=?, total_box=?, cnpj_prefeitura=? where cnpj=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, mercado.getNome());
            stmt.setString(2, mercado.getNomeFantasia());
            stmt.setString(3, mercado.getEndereco());
            stmt.setInt(4, mercado.getTotalBox());
            stmt.setString(5, mercado.getCnpjPrefeitura());
            stmt.setString(6, mercado.getCnpj());
            stmt.execute();
            stmt.close();
            conexao.close();
        } catch (SQLException erro) {
            System.out.println("BDMercado: " + erro.getMessage());
        }
    }
}