public class conta {
    
    protected int codConta;
    public int getCodConta() {
        return codConta;
    }
    public void setCodConta(int codConta) {
        this.codConta = codConta;
    }
    
    protected int codAgenc;
    public void setCodAgenc(int codAgenc) {
        this.codAgenc = codAgenc;
    }
    public int getCodAgenc() {
        return codAgenc;
    }
    
    protected String nome;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    protected double saldo;
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "[Codigo da Conta= " + codConta + ", Codigo da agencia= " + codAgenc + ", nome= " + nome + ", saldo= " + saldo + "]";
    }

}
