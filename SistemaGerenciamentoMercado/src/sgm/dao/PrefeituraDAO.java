package sgm.dao;

import sgm.dominio.PessoaFisica;
import sgm.dominio.Prefeitura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PrefeituraDAO implements DAO <Prefeitura, String>{
  
    @Override
    public void salvar(Prefeitura prefeitura){
        try {
            Connection conexao = new Conexao().conectar();
            String sql = "insert into prefeitura values (?,?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);         
            stmt.setString(1, prefeitura.getCnpj());
            stmt.setString(2, prefeitura.getNome());
            stmt.setString(3, prefeitura.getNomeFantasia());
            stmt.setString(4, prefeitura.getEndereco());
            stmt.setString(5, prefeitura.getRepresentanteLegal().getCpf());            
            stmt.execute();
            stmt.close();
            conexao.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }   
    }

    @Override
    public Prefeitura consultar(String cnpj){
        Prefeitura prefeitura = null;
        PessoaFisica representanteLegal = null;
        PessoaFisicaDAO bDPessoaFisica = new PessoaFisicaDAO();
        try{
            Connection conexao = new Conexao().conectar();
            String sql = "select * from prefeitura where cnpj = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cnpj);
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next()){
                String cpf = resultado.getString("cpf_representante_legal");
                representanteLegal = bDPessoaFisica.consultar(cpf);
                prefeitura = new Prefeitura(
                    resultado.getString("cnpj"),
                    resultado.getString("nome"),
                    resultado.getString("nome_fantasia"),
                    resultado.getString("endereco"),
                    representanteLegal
                );
            }
            resultado.close();
            stmt.close();
            conexao.close();
        }catch (SQLException erro) {
            erro.printStackTrace();
        }
        return prefeitura;
    }

    @Override
    public Prefeitura excluir(String cnpj) throws Exception{
        Prefeitura prefeitura = this.consultar(cnpj);
        try {
            Connection conexao = new Conexao().conectar();
            String sql = "delete from prefeitura where cnpj = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cnpj);
            stmt.execute();
            stmt.close();
            conexao.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
            throw new Exception("Exclua os mercados vinculados à prefeitura: " + prefeitura.getNome());
        }
        return prefeitura;
    }

    @Override
    public List <Prefeitura> listar(){
        Prefeitura prefeitura = null;
        PessoaFisica representanteLegal = null;
        PessoaFisicaDAO bDPessoaFisica = new PessoaFisicaDAO();
        List <Prefeitura> prefeituras = new ArrayList<>();
        try{
            Connection conexao = new Conexao().conectar();
            String sql = "select * from prefeitura";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next()){
                String cpf = resultado.getString("cpf_representante_legal");
                representanteLegal = bDPessoaFisica.consultar(cpf);
                prefeitura = new Prefeitura(
                    resultado.getString("cnpj"),
                    resultado.getString("nome"),
                    resultado.getString("nome_fantasia"),
                    resultado.getString("endereco"),
                    representanteLegal
                );
                prefeituras.add(prefeitura);
            }
            resultado.close();
            stmt.close();
            conexao.close();
        }catch (SQLException erro){
            erro.printStackTrace();
        }
        return prefeituras;
    }
    
    @Override
    public void alterar(Prefeitura prefeitura){
        try {
            Connection conexao = new Conexao().conectar();
            String sql = "update prefeitura set nome=?, nome_fantasia=?, endereco=?, cpf_representante_legal=?"
                    + " where cnpj=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);         
            stmt.setString(1, prefeitura.getNome());
            stmt.setString(2, prefeitura.getNomeFantasia());
            stmt.setString(3, prefeitura.getEndereco());
            stmt.setString(4, prefeitura.getRepresentanteLegal().getCpf());            
            stmt.setString(5, prefeitura.getCnpj());
            stmt.execute();
            stmt.close();
            conexao.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }   
    }

            
            
}