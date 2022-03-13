package sgm.dao;

import sgm.dominio.PessoaFisica;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import sgm.dominio.Contrato;
import sgm.dominio.Pessoa;
import sgm.dominio.PessoaJuridica;
import sgm.dominio.Prefeitura;
import sgm.conversores.ConverterData;

public class PessoaFisicaDAO implements DAO <PessoaFisica, String>{
    
    @Override
    public void salvar(PessoaFisica pessoaFisica){
        String dataNascimento = ConverterData.converterParaBD(pessoaFisica.getDataNascimento());
        
        try {
            Connection conexao = new Conexao().conectar();
            String sql = "insert into pessoa_fisica values (?,?,?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pessoaFisica.getCpf());
            stmt.setString(2, pessoaFisica.getNome());
            stmt.setString(3, pessoaFisica.getRg());
            stmt.setString(4, pessoaFisica.getEndereco());
            stmt.setString(5, pessoaFisica.getSexo());
            stmt.setString(6, dataNascimento);
            stmt.execute();
            stmt.close();
            conexao.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }   
    }

    @Override
    public PessoaFisica consultar(String cpf){
        PessoaFisica pessoaFisica = null;
        try {
            Connection conexao = new Conexao().conectar();
            String sql = "select * from pessoa_fisica where cpf = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet resultado = stmt.executeQuery();  
            while(resultado.next()){
                pessoaFisica = new PessoaFisica(
                    resultado.getString("cpf"),
                    resultado.getString("nome"),
                    resultado.getString("rg"),
                    resultado.getString("endereco"),
                    resultado.getString("sexo"),
                    ConverterData.converterParaUsu(resultado.getString("data_nascimento"))
                );
            }
            resultado.close();
            stmt.close();
            conexao.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return pessoaFisica;
    }

    @Override
    public PessoaFisica excluir(String cpf) throws Exception{
        PessoaFisica pessoaFisica = this.consultar(cpf);
        try {
            Connection conexao = new Conexao().conectar();
            String sql = "delete from pessoa_fisica where cpf = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.execute();
            stmt.close();
            conexao.close();
        } catch (SQLException erro) {
            //erro.printStackTrace();
            PrefeituraDAO prefeituraDAO = new PrefeituraDAO();
            List<Prefeitura> prefeituras = prefeituraDAO.listar();
            for(Prefeitura p : prefeituras){
                if(p.getRepresentanteLegal().equals(pessoaFisica)){
                    throw new Exception(pessoaFisica.getNome() + " é o(a) representante legal da Prefeitura.\n"
                            + "Altere o representante legal da prefeitura.");
                }
            }
            PessoaJuridicaDAO pjDAO = new PessoaJuridicaDAO();
            List<PessoaJuridica> pj = pjDAO.listar();
            for(PessoaJuridica p : pj){
                if(p.getRepresentanteLegal().equals(pessoaFisica)){
                    throw new Exception(pessoaFisica.getNome() + " é o(a) representante legal da pessoa jurídica: "
                            + p.getNome() + "\nAltere o representante legal da pessoa jurídica.");
                }
            }
            ContratoDAO contratoDAO = new ContratoDAO();
            List<Contrato> contratos = contratoDAO.listar();
            Pessoa locatario;            
            for(Contrato ct : contratos){
                locatario = ct.getLocatario();
                if(pessoaFisica.equals(locatario)){
                    throw new Exception(pessoaFisica.getNome() + " está associado a um contrato.\n"
                            + "Para realizar a exclusao e necessário exclior o contrato: " + ct);
                }
            }
        }
        return pessoaFisica;
    }

    @Override
    public List <PessoaFisica> listar(){
        PessoaFisica pessoaFisica = null;
        PessoaFisicaDAO bDPessoaFisica = new PessoaFisicaDAO();
        List <PessoaFisica> pessoasFisicas = new ArrayList<>();
        try{
            Connection conexao = new Conexao().conectar();
            String sql = "select * from pessoa_fisica";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next()){                
                pessoaFisica = new PessoaFisica(
                    resultado.getString("cpf"),
                    resultado.getString("nome"),
                    resultado.getString("rg"),
                    resultado.getString("endereco"),
                    resultado.getString("sexo"),
                    ConverterData.converterParaUsu(resultado.getString("data_nascimento"))
                );
                pessoasFisicas.add(pessoaFisica);
                Collections.sort(pessoasFisicas);
            }
            resultado.close();
            stmt.close();
            conexao.close();
        }catch (SQLException erro){
            erro.printStackTrace();
        }
        return pessoasFisicas;
    }
    
    @Override
    public void alterar(PessoaFisica pessoaFisica){
        String dataNascimento = ConverterData.converterParaBD(pessoaFisica.getDataNascimento());
        try {
            Connection conexao = new Conexao().conectar();
            String sql = "update pessoa_fisica set nome=?, rg=?, endereco=?, sexo=?, data_nascimento=? where cpf=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, pessoaFisica.getNome());
            stmt.setString(2, pessoaFisica.getRg());
            stmt.setString(3, pessoaFisica.getEndereco());
            stmt.setString(4, pessoaFisica.getSexo());
            stmt.setString(5, dataNascimento);
            stmt.setString(6, pessoaFisica.getCpf());
            stmt.execute();
            stmt.close();
            conexao.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }   
    }
}