import java.util.*;
import Models.*;

public class App {
    static Scanner scanner = new Scanner(System.in);
    static Map<Integer, Cliente> clientes = new HashMap<>();
    static Map<Integer, ContaCliente> contas = new HashMap<>();
    static Map<Integer, FaturaCliente> faturas = new HashMap<>();

    public static void main(String[] args) {
        int opcao;

        do 
        {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Criar Conta para Cliente");
            System.out.println("3. Depositar na Conta");
            System.out.println("4. Sacar da Conta");
            System.out.println("5. Criar Fatura");
            System.out.println("6. Exibir Faturas");
            System.out.println("7. Exibir Contas");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();

            switch (opcao) 
            {
                case 1 -> cadastrarCliente();
                case 2 -> criarConta();
                case 3 -> depositar();
                case 4 -> sacar();
                case 5 -> criarFatura();
                case 6 -> exibirFaturas();
                case 7 -> exibirContas();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    static void cadastrarCliente() {
        System.out.print("ID do Cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // limpar
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Desconto (%): ");
        int desconto = scanner.nextInt();
        Cliente cliente = new Cliente(id, nome, desconto);
        clientes.put(id, cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    static void criarConta() {
        System.out.print("ID da Conta: ");
        int idConta = scanner.nextInt();
        System.out.print("ID do Cliente: ");
        int idCliente = scanner.nextInt();
        Cliente cliente = clientes.get(idCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }
        ContaCliente conta = new ContaCliente(idConta, cliente);
        contas.put(idConta, conta);
        System.out.println("Conta criada com sucesso!");
    }

    static void depositar() {
        System.out.print("ID da Conta: ");
        int id = scanner.nextInt();
        ContaCliente conta = contas.get(id);
        if (conta == null) {
            System.out.println("Conta não encontrada.");
            return;
        }
        System.out.print("Valor a depositar: ");
        double valor = scanner.nextDouble();
        conta.addDeposito(valor);
    }

    static void sacar() {
        System.out.print("ID da Conta: ");
        int id = scanner.nextInt();
        ContaCliente conta = contas.get(id);
        if (conta == null) {
            System.out.println("Conta não encontrada.");
            return;
        }
        System.out.print("Valor a sacar: ");
        double valor = scanner.nextDouble();
        conta.subSaldo(valor);
    }

    static void criarFatura() {
        System.out.println("Função em desenvolvimento, ainda não disponível.");
    }

    static void exibirFaturas() {
        System.out.println("Função em desenvolvimento, ainda não disponível.");
    }

    static void exibirContas() {
        System.out.println("Função em desenvolvimento, ainda não disponível.");
    }
}