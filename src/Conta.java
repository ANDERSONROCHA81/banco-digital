import lombok.AccessLevel;
import lombok.Getter;

@Getter
public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.saldo = 0;
    }

    @Override
    public void sacar(double valor) {
        if (valor > this.saldo || valor <= 0){
            System.out.println("Impossível realizar o saque");
        }else{
            saldo -= valor;
            System.out.println("Saque realizado com sucesso");
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor <= 0){
            System.out.println("O valor do depósito deve ser maior que zero");
        }else{
            saldo += valor;
            System.out.println("Depósito realizado com sucesso");
        }
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        if (valor > 0 && valor <= this.saldo){
            this.saldo -= valor;
            contaDestino.depositar(valor);
            System.out.println("Transferência realizada com sucesso");
        }else{
            System.out.println("Transferência não realizada");
        }
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}