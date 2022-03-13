package sgm.dominio;

public class Mercado extends PessoaJuridica implements Comparable <Mercado> {

    private int totalBox;
    private String cnpjPrefeitura;
    
    
    public Mercado(String cnpj, String nome, String nomeFantasia, String endereco, int totalBox, String cnpjPrefeitura){
        super(cnpj, nome, nomeFantasia, endereco, null);
        this.totalBox = totalBox;
        this.cnpjPrefeitura = cnpjPrefeitura;
    }
    
    public int getTotalBox(){
        return this.totalBox;
    }
    
    public String getCnpjPrefeitura(){
        return this.cnpjPrefeitura;
    }
    
    @Override
    public String getQualificacao(){
        return this.getNome() + " localizado na " + 
                this.getEndereco();
    }
    
    @Override
    public String toString(){
        return "Mercado - CNPJ: " + this.getCnpj() + " - Nome: " + this.getNome();
    }
    
    @Override
    public int compareTo(Mercado mercado){
      return this.getNome().compareTo(mercado.getNome());
  }

}