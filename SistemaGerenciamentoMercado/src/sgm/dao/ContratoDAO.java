package sgm.dao;

import sgm.dominio.Contrato;
import sgm.dominio.Mercado;
import sgm.dominio.Pessoa;
import sgm.dominio.PessoaFisica;
import sgm.dominio.PessoaJuridica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sgm.conversores.ConverterData;

public class ContratoDAO implements DAO <Contrato, Integer>{
    
    @Override
    public void salvar(Contrato contrato) throws Exception{
        String dataInicio = ConverterData.converterParaBD(contrato.getDataInicio());
        String dataFim = ConverterData.converterParaBD(contrato.getDataFim());
        if(isAlugado(contrato.getMercado(), contrato.getBox(), dataInicio)){
            throw new Exception("Box indisponível para locação.");
        }
        if(contrato.getBox() > contrato.getMercado().getTotalBox()){
            throw new Exception("Número do box superior ao total de boxs cadastrados no mercado.");
        }
        Pessoa pessoa = contrato.getLocatario();
        if(pessoa instanceof PessoaFisica){
            PessoaFisica pessoaFisica = (PessoaFisica)pessoa;
            try {
                Connection conexao = new Conexao().conectar();
                String sql = "insert into contrato values (?,?,?,?,?,?,?,null)";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setInt(1, contrato.getIdContrato());
                stmt.setString(2, contrato.getMercado().getCnpj());
                stmt.setInt(3, contrato.getBox());
                stmt.setString(4, dataInicio);
                stmt.setString(5, dataFim);
                stmt.setDouble(6, contrato.getValorDoAluguel());
                stmt.setString(7, pessoaFisica.getCpf());            
                stmt.execute();
                stmt.close();
                conexao.close();
            } catch (SQLException erro) {
                erro.printStackTrace();
                throw new Exception("Contrato não foi salvo.");
            }
        }else {
            PessoaJuridica pessoaJuridica = (PessoaJuridica)pessoa;
            try {
                Connection conexao = new Conexao().conectar();
                String sql = "insert into contrato values (?,?,?,?,?,?,null,?)";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setInt(1, contrato.getIdContrato());
                stmt.setString(2, contrato.getMercado().getCnpj());
                stmt.setInt(3, contrato.getBox());
                stmt.setString(4, dataInicio);
                stmt.setString(5, dataFim);
                stmt.setDouble(6, contrato.getValorDoAluguel());
                stmt.setString(7, pessoaJuridica.getCnpj());            
                stmt.execute();
                stmt.close();                
                conexao.close();
            } catch (SQLException erro) {
                erro.printStackTrace();
                throw new Exception("Contrato não foi salvo.");
            }
        }
    }
    
    @Override
    public Contrato consultar(Integer idContrato){
        Contrato contrato = null;
        PessoaFisicaDAO bDPessoaFisica = new PessoaFisicaDAO();
        PessoaJuridicaDAO bDPessoaJuridica = new PessoaJuridicaDAO();
        MercadoDAO bDMercado = new MercadoDAO();
        int id = 0;
        String cnpjMercado = null;
        int box = 0;
        String dataInicio = null;
        String dataFim = null;
        Double valorDoAluguel = 0.0;
        String cpfLocatario = null;
        String cnpjLocatario = null;
        try{
            Connection conexao = new Conexao().conectar();
            String sql = "select * from contrato where id = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idContrato);
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next()){
                id = resultado.getInt("id");
                cnpjMercado = resultado.getString("cnpj_mercado");
                box = resultado.getInt("box");
                dataInicio = ConverterData.converterParaUsu(resultado.getString("data_inicio"));
                dataFim = ConverterData.converterParaUsu(resultado.getString("data_fim"));
                valorDoAluguel = resultado.getDouble("valor_aluguel");
                cpfLocatario = resultado.getString("cpf_locatario");
                cnpjLocatario = resultado.getString("cnpj_locatario");
            }            
            if(cpfLocatario == null){
                contrato = new Contrato(
                    id, bDPessoaJuridica.consultar(cnpjLocatario), bDMercado.consultar(cnpjMercado),
                    box, dataInicio, dataFim, valorDoAluguel);
            } else{
                contrato = new Contrato(
                    id, bDPessoaFisica.consultar(cpfLocatario), bDMercado.consultar(cnpjMercado),
                    box, dataInicio, dataFim, valorDoAluguel);
            }
            resultado.close();
            stmt.close();
            conexao.close();
        }catch (SQLException erro) {
            erro.printStackTrace();
        }
        return contrato;
    }
    
    @Override
    public Contrato excluir(Integer idContrato){
        Contrato contrato = this.consultar(idContrato);
        try {
            Connection conexao = new Conexao().conectar();
            String sql = "delete from contrato where id = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idContrato);
            stmt.execute();
            stmt.close();            
            conexao.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return contrato;
    }
    
    @Override
    public List <Contrato> listar(){
        Contrato contrato = null;
        PessoaFisicaDAO bDPessoaFisica = new PessoaFisicaDAO();
        PessoaJuridicaDAO bDPessoaJuridica = new PessoaJuridicaDAO();
        MercadoDAO bDMercado = new MercadoDAO();
        int id = 0;
        String cnpjMercado = null;
        int box = 0;
        String dataInicio = null;
        String dataFim = null;
        Double valorDoAluguel = 0.0;
        String cpfLocatario = null;
        String cnpjLocatario = null;
        List <Contrato> contratos = new ArrayList<>();
        try{
            Connection conexao = new Conexao().conectar();
            String sql = "select * from contrato";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next()){
                id = resultado.getInt("id");
                cnpjMercado = resultado.getString("cnpj_mercado");
                box = resultado.getInt("box");
                dataInicio = ConverterData.converterParaUsu(resultado.getString("data_inicio"));
                dataFim = ConverterData.converterParaUsu(resultado.getString("data_fim"));
                valorDoAluguel = resultado.getDouble("valor_aluguel");
                cpfLocatario = resultado.getString("cpf_locatario");
                cnpjLocatario = resultado.getString("cnpj_locatario");
                        
                if(cpfLocatario == null){
                    contrato = new Contrato(
                        id, bDPessoaJuridica.consultar(cnpjLocatario), bDMercado.consultar(cnpjMercado),
                        box, dataInicio, dataFim, valorDoAluguel);
                    contratos.add(contrato);
                } else{
                    contrato = new Contrato(
                        id, bDPessoaFisica.consultar(cpfLocatario), bDMercado.consultar(cnpjMercado),
                        box, dataInicio, dataFim, valorDoAluguel);
                    contratos.add(contrato);
                }
            }
            resultado.close();
            stmt.close();
            conexao.close();
        }catch (SQLException erro) {
            erro.printStackTrace();
        }
        return contratos;
    }
    
    public int getQtdeContratos(){
        int quantidadeContratos = 0;
        try{
            Connection conexao = new Conexao().conectar();
            String sql = "select max(id) from contrato";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next()){
                quantidadeContratos = resultado.getInt("max(id)");
            }
            stmt.close();            
            conexao.close();
        } catch (SQLException erro){
                System.out.println("BDContrato" + erro.getMessage());
        }
        return quantidadeContratos;
    }
    
    public boolean isAlugado(Mercado mercado, int box, String dataInicio){
        dataInicio = ConverterData.converterParaBD(dataInicio);
        int quantidadeContratos = 0;
        try{
            Connection conexao = new Conexao().conectar();
            //Falta acrescentar condição de data fim na String abaixo.
            String sql = "select count(id) from contrato where cnpj_mercado = ? and box = ? and "
                    + "data_inicio <= ? and data_fim >= ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, mercado.getCnpj());
            stmt.setInt(2, box);
            stmt.setString(3, dataInicio);
            stmt.setString(4, dataInicio);
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next()){
                quantidadeContratos = resultado.getInt("count(id)");
            }
            
            stmt.close();
            conexao.close();
        } catch (SQLException erro){
            System.out.println("BDContrato: " + erro.getMessage());
        }
        if(quantidadeContratos > 0) return true;
        return false;
    }
    
    @Override
    public void alterar(Contrato contrato) throws Exception {
        String dataInicio = ConverterData.converterParaBD(contrato.getDataInicio());
        String dataFim = ConverterData.converterParaBD(contrato.getDataFim());

        if(contrato.getBox() > contrato.getMercado().getTotalBox()){
            throw new Exception("Número do box superior ao total de boxs cadastrados no mercado.");
        }
        
        Pessoa pessoa = contrato.getLocatario();
        if(pessoa instanceof PessoaFisica){
            PessoaFisica pessoaFisica = (PessoaFisica)pessoa;
            try {
                Connection conexao = new Conexao().conectar();
                String sql = "update contrato set cnpj_mercado=?, box=?, data_inicio=?, data_fim=?, valor_aluguel=?, cpf_locatario=? where id=? ";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setString(1, contrato.getMercado().getCnpj());
                stmt.setInt(2, contrato.getBox());
                stmt.setString(3, dataInicio);
                stmt.setString(4, dataFim);
                stmt.setDouble(5, contrato.getValorDoAluguel());
                stmt.setString(6, pessoaFisica.getCpf());            
                stmt.setInt(7, contrato.getIdContrato());
                stmt.execute();
                stmt.close();
                conexao.close();
            } catch (SQLException erro) {
                erro.printStackTrace();
            }
        }else {
            PessoaJuridica pessoaJuridica = (PessoaJuridica)pessoa;
            try {
                Connection conexao = new Conexao().conectar();
                String sql = "update contrato set cnpj_mercado=?, box=?, data_inicio=?, data_fim=?, valor_aluguel=?, cnpj_locatario=? where id=? ";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setString(1, contrato.getMercado().getCnpj());
                stmt.setInt(2, contrato.getBox());
                stmt.setString(3, dataInicio);
                stmt.setString(4, dataFim);
                stmt.setDouble(5, contrato.getValorDoAluguel());
                stmt.setString(6, pessoaJuridica.getCnpj());     
                stmt.setInt(7, contrato.getIdContrato());                
                stmt.execute();
                stmt.close();                
                conexao.close();
            } catch (SQLException erro) {
                erro.printStackTrace();
            }
        }
    }
}
