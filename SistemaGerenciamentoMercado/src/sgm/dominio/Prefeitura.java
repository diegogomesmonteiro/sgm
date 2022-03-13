package sgm.dominio;

public class Prefeitura extends PessoaJuridica {
  
  public Prefeitura(String cnpj, String nome, String nomeFantasia, String endereco, PessoaFisica representanteLegal){
    super(cnpj, nome, nomeFantasia, endereco, representanteLegal);
  }
  
  @Override
  public String getQualificacao(){
      PessoaFisica prefeito = this.getRepresentanteLegal();
      return this.getNome() + " representada legalmente neste instrumento através do(a) Prefeito(a) " +
              prefeito.getNome() + " portador(a) da cédula de identidade " + prefeito.getRg() + " e CPF " +
              prefeito.getCpf() + ", residente e domiciliado(a) à " + prefeito.getEndereco();
  }
  
  @Override
  public String toString(){
      return "Prefeitura - CNPJ: " + this.getCnpj() + " - Nome: " + this.getNome();
  }
}