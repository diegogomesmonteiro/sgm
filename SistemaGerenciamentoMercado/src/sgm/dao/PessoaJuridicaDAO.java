package sgm.dao;

import sgm.dominio.PessoaFisica;
import sgm.dominio.PessoaJuridica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaDAO implements DAO <PessoaJuridica, String>{
    
    @Override
    public void salvar(PessoaJuridica pessoaJuridica){
        try {
            Connection conexao = new Conexao().conectar();
            String sql = "insert into pessoa_juridica values (?,?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pessoaJuridica.getCnpj());
            stmt.setString(2, pessoaJuridica.getNome());
            stmt.setString(3, pessoaJuridica.getNomeFantasia());
            stmt.setString(4, pessoaJuridica.getEndereco());
            stmt.setString(5, pessoaJuridica.getRepresentanteLegal().getCpf());
            stmt.execute();
            stmt.close();
            conexao.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }   
    }

    @Override
    public PessoaJuridica consultar(String cnpj){
        PessoaJuridica pessoaJuridica = null;
        PessoaFisica representanteLegal = null;
        PessoaFisicaDAO bDPessoaFisica = new PessoaFisicaDAO();
        try{
            Connection conexao = new Conexao().conectar();
            String sql = "select * from pessoa_juridica where cnpj = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cnpj);
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next()){
                String cpf = resultado.getString("cpf_representante_legal");
                representanteLegal = bDPessoaFisica.consultar(cpf);
                pessoaJuridica = new PessoaJuridica(
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
        return pessoaJuridica;
    }

    @Override
    public PessoaJuridica excluir(String cnpj) throws Exception{
        PessoaJuridica pessoaJuridica = this.consultar(cnpj);
        try {
            Connection conexao = new Conexao().conectar();
            String sql = "delete from pessoa_juridica where cnpj = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cnpj);
            stmt.execute();
            stmt.close();
            conexao.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
            throw new Exception ("Pessoa Jurídica possui contrato vinculado.\nExclusão não realizada.");
        }
        return pessoaJuridica;
    }

    @Override
    public List <PessoaJuridica> listar(){
        PessoaJuridica pessoaJuridica = null;
        PessoaFisica representanteLegal = null;
        PessoaFisicaDAO bDPessoaFisica = new PessoaFisicaDAO();
        List <PessoaJuridica> pessoasJuridicas = new ArrayList<>();
        try{
            Connection conexao = new Conexao().conectar();
            String sql = "select * from pessoa_juridica";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next()){
                String cpf = resultado.getString("cpf_representante_legal");
                representanteLegal = bDPessoaFisica.consultar(cpf);
                pessoaJuridica = new PessoaJuridica(
                    resultado.getString("cnpj"),
                    resultado.getString("nome"),
                    resultado.getString("nome_fantasia"),
                    resultado.getString("endereco"),
                    representanteLegal
                );              
                pessoasJuridicas.add(pessoaJuridica);
            }
            resultado.close();
            stmt.close();
            conexao.close();
        } catch (SQLException erro){
            erro.printStackTrace();
        }
        return pessoasJuridicas;
    }
    
    @Override
    public void alterar(PessoaJuridica pessoaJuridica){
        try {
            Connection conexao = new Conexao().conectar();
            String sql = "update pessoa_juridica set nome=?, nome_fantasia=?, endereco=?, cpf_representante_legal=? where cnpj=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pessoaJuridica.getNome());
            stmt.setString(2, pessoaJuridica.getNomeFantasia());
            stmt.setString(3, pessoaJuridica.getEndereco());
            stmt.setString(4, pessoaJuridica.getRepresentanteLegal().getCpf());
            stmt.setString(5, pessoaJuridica.getCnpj());
            stmt.execute();
            stmt.close();
            conexao.close();
        } catch (SQLException erro) {
            erro.printStackTrace();            
        }
    }
}
