public class Main {

    public static void main(String[] args) {
        Cliente anderson = new Cliente();
        anderson.setNome("Anderson");

        Cliente patricia = new Cliente();
        patricia.setNome("Patrícia");

        Conta ccAnderson = new ContaCorrente(anderson);
        Conta poupancaAnderson = new ContaPoupanca(anderson);

        Conta ccPatricia = new ContaCorrente(patricia);
        Conta poupancaPatricia = new ContaPoupanca(patricia);

        ccAnderson.depositar(1000);
        ccAnderson.transferir(100, poupancaPatricia);

        poupancaAnderson.depositar(1000);
        poupancaAnderson.transferir(100, ccPatricia);

        ccAnderson.imprimirExtrato();
        poupancaPatricia.imprimirExtrato();
        ccPatricia.imprimirExtrato();
    }
}