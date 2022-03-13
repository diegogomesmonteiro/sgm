package sgm.dominio;

public class PessoaFisica extends Pessoa implements Comparable <PessoaFisica> {
  private String cpf;
  private String rg;
  private String sexo;
  private String dataNascimento;

  public PessoaFisica(String cpf, String nome, String rg, String endereco, String sexo, String dataNascimento){
  super(nome, endereco);
  this.cpf = cpf;
  this.rg = rg;
  this.sexo = sexo;
  this.dataNascimento = dataNascimento;
  }

  public String getCpf(){
    return this.cpf;
  }

  public String getRg() {
      return rg;
  }

  public String getSexo() {
      return sexo;
  }
  public String getDataNascimento() {
      return dataNascimento;
  }
  public void setCpf(String cpf) {
      this.cpf = cpf;
  }

  public void setRg(String rg) {
      this.rg = rg;
  }

  @Override
  public String getQualificacao(){
    return this.getNome() + " portador(a) da cédula de identidade " + 
            this.getRg() + " e CPF " + this.getCpf() + 
            ", residente e domiciliado à " + this.getEndereco();
  }


  @Override
  public String toString(){
    return "Pessoa Física - CPF: " + this.getCpf() + " - Nome: " + this.getNome();
  }

  @Override
  public int compareTo(PessoaFisica pessoa){
      return this.getNome().compareTo(pessoa.getNome());
  }

  @Override
  public boolean equals(Object pessoa){
      if(pessoa instanceof PessoaFisica){
                      System.out.println("É instância");

          PessoaFisica p = (PessoaFisica)pessoa;
                      System.out.println("primeiro: " + this.getCpf());
                      System.out.println("segundo: " + p.getCpf());

          if(this.getCpf().equals(p.getCpf())){
              System.out.println("É igual");
            return true;  
        }
      }
      return false;
  }
}