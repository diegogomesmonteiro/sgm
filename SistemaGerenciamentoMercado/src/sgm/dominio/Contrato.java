package sgm.dominio;

import sgm.dao.PrefeituraDAO;
import sgm.dao.ContratoDAO;

public class Contrato {
    
    private int idContrato;
    private Pessoa locatario;
    private Mercado mercado;
    private int box;
    private String dataInicio;
    private String dataFim;
    private double valorDoAluguel;

    public Contrato (Pessoa locatario, Mercado mercado, int box, String dataInicio, String dataFim, double valorDoAluguel){
        ContratoDAO bDContrato = new ContratoDAO();
        int quantidadeContratos = bDContrato.getQtdeContratos();
        this.idContrato = quantidadeContratos + 1;
        this.locatario = locatario;
        this.mercado = mercado;
        this.box = box;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valorDoAluguel = valorDoAluguel;
    }
    
    public Contrato (int id, Pessoa locatario, Mercado mercado, int box, String dataInicio, String dataFim, double valorDoAluguel){
        this.idContrato = id;
        this.locatario = locatario;
        this.mercado = mercado;
        this.box = box;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valorDoAluguel = valorDoAluguel;
    }
    
    public int getIdContrato(){
        return idContrato;
    }
    
    public Pessoa getLocatario() {
        return locatario;
    }

    public Mercado getMercado() {
        return mercado;
    }

    public int getBox() {
        return box;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public double getValorDoAluguel() {
        return valorDoAluguel;
    }
    
    private String getTituloContrato(){
        return "CONTRATO DE LOCAÇÃO\n\n";
    }
    
    private String getDadosLocador(){
        PrefeituraDAO bDPrefeitura = new PrefeituraDAO();
        String cnpjPrefeitura = this.mercado.getCnpjPrefeitura();
        PessoaJuridica prefeitura = bDPrefeitura.consultar(cnpjPrefeitura);
        return "LOCADOR: \n" + prefeitura.getQualificacao() + "\n\n";
    }
    
    private String getDadosLocatario(){
        return "LOCATÁRIO: \n" + this.locatario.getQualificacao() + "\n\n";
    }
    
    private String getObjetoDoContrato(){
        return "O objeto da locação consiste no Box nº " + this.box + " do " + 
                this.mercado.getQualificacao() + ".\n\n";
    }
    
    private String getClausulaContratual(){
        return "CLÁUSULAS CONTRATUAIS: \nxxxxxxxxxxxxxxxxxxxxxxxxxxx\nxxxxxxxxxxxxxxxxxxxxxxxxxxx\n\n";
    }
    
    private String getAssinaturas(){
        PrefeituraDAO bDPrefeitura = new PrefeituraDAO();
        String cnpjPrefeitura = this.mercado.getCnpjPrefeitura();
        PessoaJuridica prefeitura = bDPrefeitura.consultar(cnpjPrefeitura);
        String assinaturaLocador = 
        "__________________________________________\n" +
        prefeitura.getRepresentanteLegal().getNome() +
        "\nPrefeito(a) Municipal\n\n";

        String assinaturaLocatario =
        "__________________________________________\n" +
        this.locatario.getNome() + "\nLocatário(a)\n\n";
        return assinaturaLocador + assinaturaLocatario;
    }
    
    
    
    public void imprimir(){
        System.out.println(this.getTituloContrato()+this.getDadosLocador()+this.getDadosLocatario()+
                this.getObjetoDoContrato()+this.getClausulaContratual()+this.getAssinaturas());
    }

    @Override
    public String toString(){
        return "Contrato - ID: " + this.getIdContrato() + " - Locatário: " + this.getLocatario().getNome() + " - Mercado: " + 
                this.getMercado().getNome() + " - Box: " + this.getBox() + " - Período de locação: " +
                this.getDataInicio() + " a " + this.getDataFim();
    }

}