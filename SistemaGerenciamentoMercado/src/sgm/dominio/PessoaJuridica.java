package sgm.dominio;

public class PessoaJuridica extends Pessoa{
  private String cnpj;
  private String nomeFantasia;
  private PessoaFisica representanteLegal;

  public PessoaJuridica(String cnpj, String nome, String nomeFantasia, String endereco, PessoaFisica representanteLegal){
    super(nome, endereco);
    this.cnpj = cnpj;
    this.nomeFantasia = nomeFantasia;
    this.representanteLegal = representanteLegal;
  }

  public String getCnpj(){
    return this.cnpj;
  }

  public String getNomeFantasia() {
      return nomeFantasia;
  }


  public void setNomeFantasia(String nomeFantasia) {
      this.nomeFantasia = nomeFantasia;
  }

  public PessoaFisica getRepresentanteLegal(){
    return this.representanteLegal;
  }
  
  public boolean isRepresentanteLegal(String cpf){
      return this.representanteLegal.getCpf().equals(cpf);
  }

  @Override
  public String getQualificacao(){
    PessoaFisica representante = this.representanteLegal;
    return "Empresa " + this.getNome() + " representada legalmente neste instrumento através do(a) senhor(a) " +
            representante.getNome() + " portador(a) da cédula de identidade " + representante.getRg() + " e CPF " + 
            representante.getCpf() + ", residente e domiciliado(a) à " + representante.getEndereco();
  }

  
  @Override
  public String toString(){
    return "Pessoa Jurídica - CNPJ: " + this.getCnpj() + " - Nome: " + this.getNome();
  }

}