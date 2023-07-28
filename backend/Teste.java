package backend;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import backend.banco.Agencia;
import backend.banco.Corrente;
import backend.banco.DadosAgencias;
import backend.banco.DadosContas;
import backend.banco.Poupanca;
import backend.banco.Salario;
import backend.banco.Transacao;
import backend.pessoa.cliente.Cliente;
import backend.pessoa.cliente.DadosClientes;
import backend.pessoa.funcionario.DadosFuncionarios;
import backend.pessoa.funcionario.Gerente;

import java.io.IOException;

public class Teste {


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println(DadosAgencias.mostrarDados());
		
		Scanner leitor = new Scanner(System.in);
		
		String nome = "Inicio";
		
		// Dados Cliente
		String CPFCliente, nomeCliente, dataNascimentoCliente, escolaridadeCliente;
		String estadoCliente, cidadeCliente, bairroCliente, ruaCliente, numeroCliente;
		int estadocivilCliente;
		
		// Agencia
		String nomeAg, estadoAgencia, cidadeAgencia, bairroAgencia, ruaAgencia, numeroAgencia;
		int numerodaAgencia, escolheAgencia, escolheTransacao;
		
		// Gerente
		String CPFGerente, nomeCompletoGerente, dataNascimentoGerente, dataAdmissaoGerente;
		String cargoEmpresaGerente, estadoGerente, cidadeGerente, bairroGerente, ruaGerente;
		String numeroGerente;
		int ingressoGerenteGerente, cursoGerente, sexoGerente, estadoCivilGerente;

		// Conta
		String flagueAtiva;
		char tipoTransacao;
		double saldoAtual, valorTransacao;
		Date dataAbertura;
		int tipoContaCorrente, escolheAgConta, escolheConta, escolheContaTransacao, escolheCliente, codigo, senha, numeroConta;

		System.out.printf("CADASTRO GERENTES: \n\n");
		
		// Entrada de dados Gerente
		while (true) {
	        System.out.printf("Ficha Gerente: \n");
	        System.out.printf("Informe o nome da Gerente, FIM para encerrar:\n");
	        nome = leitor.nextLine();
	        if (nome.equalsIgnoreCase("FIM"))
	        	break;
	        
	        // Gerente
	        System.out.printf("\nInforme o CPF do gerente : ");
	        CPFGerente = "11573197696"; // leitor.nextLine();
	        System.out.printf("\nInforme o nome completo do gerente : ");
	        nomeCompletoGerente = "Gean Fernandes da Silva"; // leitor.nextLine();
	        System.out.printf("\nInforme a data da nascimento do gerente : ");
	        dataNascimentoGerente = "20/04/1994"; // leitor.nextLine();
	        System.out.printf("\nInforme o estado civil do gerente, 1 para solteiro e 2 para casado : ");
	        estadoCivilGerente = 1; // leitor.nextInt();
	        System.out.printf("\nInforme a data de admissao do gerente : ");
	        dataAdmissaoGerente = "25/03/2014"; // leitor.nextLine();
	        System.out.printf("\nInforme o sexo do gerente, 1 para homem e 2 para mulher : ");
	        sexoGerente = 1;
	        cargoEmpresaGerente = "Gerente";
	        System.out.printf("\nInforme o ano de ingresso como gerente : ");
	        ingressoGerenteGerente = 2016; // leitor.nextInt();
	        System.out.printf("\nInforme se ele possui curso de gerente, 1 para sim e 2 para nao : ");
	        cursoGerente = 1; // leitor.nextInt();
	        System.out.printf("\nInforme o estado do gerente : ");
	        estadoGerente = "MG";// leitor.nextLine();
	        System.out.printf("\nInforme a cidade do gerente : ");
	        cidadeGerente = "Uberlandia";// leitor.nextLine();
	        System.out.printf("\nInforme o bairro do gerente : ");
	        bairroGerente = "Santa Monica";// leitor.nextLine();
	        System.out.printf("\nInforme a rua do gerente : ");
	        ruaGerente = "Manoel Serralha";// leitor.nextLine();
	        System.out.printf("\nInforme o numero da casa do gerente : ");
	        numeroGerente = "807";// leitor.nextLine();
	        
	        DadosFuncionarios.cadastrar(new Gerente(CPFGerente, nomeCompletoGerente, dataNascimentoGerente, new Endereco(estadoGerente, cidadeGerente, bairroGerente, ruaGerente, numeroGerente ) , estadoCivilGerente, dataAdmissaoGerente, sexoGerente, cargoEmpresaGerente, ingressoGerenteGerente, cursoGerente)); 
	        
	        leitor.nextLine(); 
	        System.out.printf("\n");
	      } 
		
		System.out.println(DadosFuncionarios.getFuncionarios());
		
		System.out.printf("\n\nCADASTRO AGENCIAS: \n\n");
		 
		while (true) {
	        System.out.printf("Ficha Agencia: \n");
	        System.out.printf("Informe o nome da Agencia, FIM para encerrar:\n");
	        nome = leitor.nextLine();
	        if (nome.equalsIgnoreCase("FIM"))
	        	break;

	        // Agencia
	        System.out.printf("\nInforme o numero da agencia : ");
	        numerodaAgencia = 7469; // leitor.nextInt();
	        System.out.printf("\nInforme o nome da agencia : ");
	        nomeAg = "AG-516"; // leitor.nextLine();
	       	System.out.printf("\nInforme o estado da agencia : ");
	       	estadoAgencia = "MG"; // leitor.nextLine();
	       	System.out.printf("\nInforme a cidade da agencia : ");
	       	cidadeAgencia = "Uberlandia";// leitor.nextLine();
	       	System.out.printf("\nInforme o bairro da agencia : ");
	       	bairroAgencia = "Centro"; // leitor.nextLine();
	       	System.out.printf("\nInforme a rua da agencia : ");
	       	ruaAgencia = "Rua Amazonas"; // leitor.nextLine();
	       	System.out.printf("\nInforme o numero da agencia : ");
	       	numeroAgencia = "574"; // leitor.nextLine();
	       	System.out.printf("\nEscolha qual o gerente da agencia, 0 para o primeiro gerente cadastrado, 1 para o segundo gerente cadastrado ... : "); 
	       	int escolheGerente = 0; // leitor.nextInt();
	       
	       	DadosAgencias.cadastrar(new Agencia(numerodaAgencia, nomeAg, ((Gerente)DadosFuncionarios.getFuncionarios().get(escolheGerente)), new Endereco(estadoAgencia, cidadeAgencia, bairroAgencia, ruaAgencia, numeroAgencia) ));
	        
	       	leitor.nextLine(); 
	        System.out.printf("\n");
      } 
		
		System.out.println(DadosAgencias.getAgencias());
	  
		
		System.out.printf("\n\nCADASTRO CLIENTES: \n\n");
		 
		while (true) {
	        System.out.printf("Ficha Cliente: \n");
	        System.out.printf("Informe o nome do cliente, FIM para encerrar:\n");
	        nome = leitor.nextLine();
	        if (nome.equalsIgnoreCase("FIM"))
	        	break;
	      
	        // Cliente
	        System.out.printf("\nInforme o CPF do Cliente : ");
	        CPFCliente = "11573197696"; // leitor.nextLine();
	        System.out.printf("\nInforme o nome completo do Cliente : ");
	        nomeCliente = "Alceu";
	        System.out.printf("\nInforme a data da nascimento do Cliente : ");
	        dataNascimentoCliente = "20/04/1994"; // leitor.nextLine();
	        System.out.printf("\nInforme o estado civil do Cliente, 1 para solteiro e 2 para casado : ");
	        estadocivilCliente = 1; // leitor.nextInt();
	        System.out.printf("\nInforme a escolaridade do Cliente : ");
	        escolaridadeCliente = "Superior Completo"; // leitor.nextLine();
	        System.out.printf("\nInforme o estado do Cliente : ");
	        estadoCliente = "MG"; // leitor.nextLine();
	        System.out.printf("\nInforme a cidade do Cliente : ");
	        cidadeCliente = "Cruzeiro da Fortaleza"; // leitor.nextLine();
	        System.out.printf("\nInforme o bairro do Cliente : ");
	        bairroCliente = "Centro"; // leitor.nextLine();
	        System.out.printf("\nInforme a rua do Cliente : ");
	        ruaCliente = "Rua Acre"; // leitor.nextLine();
	        System.out.printf("\nInforme o numero da casa do Cliente : ");
	        numeroCliente = "927"; // leitor.nextLine();
	        System.out.printf("\nEscolha qual a agencia do cliente, 0 para a primeiro agencia cadastrado, 1 para a segundo agencia cadastrado ... : "); 
	       	escolheAgencia = 0; // leitor.nextInt();
	        
	       	DadosClientes.cadastrar(new Cliente(CPFCliente, nomeCliente, dataNascimentoCliente, new Endereco(estadoCliente, cidadeCliente, bairroCliente, ruaCliente, numeroCliente), estadocivilCliente, escolaridadeCliente, DadosAgencias.getAgencias().get(escolheAgencia)));
	        
	       	leitor.nextLine(); 
	        System.out.printf("\n");
      } 
	      
		System.out.println(DadosClientes.getClientes());
		
		System.out.printf("\n\nCADASTRO CONTAS: \n\n"); 
		
		// Entrada de dados Contas
		while (true) {
			System.out.printf("Ficha Contas: \n");
			System.out.printf("Informe 1 para conta corrente, 2 para conta poupanca e 3 para conta salario ou -1 para encerrar:\n");
			escolheConta = leitor.nextInt();
			if (escolheConta < 0)
				break;
			
				if (escolheConta == 1 ) {
			        // Conta Corrente
					System.out.printf("\nCONTA CORRENTE: ");
			        System.out.printf("\nInforme o codigo da conta : ");
			        codigo = 123; // leitor.nextInt();
			        System.out.printf("\nInforme o status da conta: A para ativa, I para inativa e N para analise: ");
			        flagueAtiva = "A"; // leitor.nextLine()
			        System.out.printf("\nInforme a senha da conta : ");
			        senha = 456789; // leitor.nextInt();
			        System.out.printf("\nInforme o numero da conta : ");
			        numeroConta = 2020; // leitor.nextInt();
			        System.out.printf("\nInforme o saldo da conta : ");
			        saldoAtual = 1000; // leitor.nextInt();
			        Calendar hoje = Calendar.getInstance();
			        dataAbertura = hoje.getTime();
			        System.out.printf("\nInforme o tipo de conta corrente: 1 para Standard e 2 para Premiun: ");
			        tipoContaCorrente = 2; // leitor.nextInt();
			        System.out.printf("\nEscolha qual a agencia da conta, 0 para a primeiro agencia cadastrado, 1 para a segundo agencia cadastrado ... : "); 
			        escolheAgConta = 0; // leitor.nextInt();
			        System.out.printf("\nEscolha qual o cliente da conta, 0 para a primeiro cliente cadastrado, 1 para a segundo cliente cadastrado ... : "); 
			        escolheCliente = 0; // leitor.nextInt();
			        
			        DadosContas.cadastrar(new Corrente(codigo, flagueAtiva, senha, numeroConta, saldoAtual, dataAbertura, DadosAgencias.getAgencias().get(escolheAgConta), DadosClientes.getClientes().get(escolheCliente), tipoContaCorrente));
			        
			        leitor.nextLine(); 
			        System.out.printf("\n"); 
			      }
				
				if (escolheConta == 2 ) {
			        // Conta Poupanca
					System.out.printf("\nCONTA POUPANCA: ");
			        System.out.printf("\nInforme o codigo da conta : ");
			        codigo = 741; // leitor.nextInt();
			        System.out.printf("\nInforme o status da conta: A para ativa, I para inativa e N para analise: ");
			        flagueAtiva = "N"; // leitor.nextLine()
			        System.out.printf("\nInforme a senha da conta : ");
			        senha = 1473652; // leitor.nextInt();
			        System.out.printf("\nInforme o numero da conta : ");
			        numeroConta = 3030; // leitor.nextInt();
			        System.out.printf("\nInforme o saldo da conta : ");
			        saldoAtual = 1000; // leitor.nextInt();
			        Calendar hoje = Calendar.getInstance();
			        dataAbertura = hoje.getTime();
			        System.out.printf("\nEscolha qual a agencia da conta, 0 para a primeiro agencia cadastrado, 1 para a segundo agencia cadastrado ... : "); 
			        escolheAgConta = 0; // leitor.nextInt();
			        System.out.printf("\nEscolha qual o cliente da conta, 0 para a primeiro cliente cadastrado, 1 para a segundo cliente cadastrado ... : "); 
			        escolheCliente = 0; // leitor.nextInt();
			        
			        DadosContas.cadastrar(new Poupanca(codigo, flagueAtiva, senha, numeroConta, saldoAtual, dataAbertura, DadosAgencias.getAgencias().get(escolheAgConta), DadosClientes.getClientes().get(escolheCliente)));
			        
			        leitor.nextLine(); 
			        System.out.printf("\n");
			      }
				
				if (escolheConta == 3 ) {
			        // Conta Salario
					System.out.printf("\nCONTA SALARIO: ");
			        System.out.printf("\nInforme o codigo da conta : ");
			        codigo = 162; // leitor.nextInt();
			        System.out.printf("\nInforme o status da conta: A para ativa, I para inativa e N para analise: ");
			        flagueAtiva = "A"; // leitor.nextLine()
			        System.out.printf("\nInforme a senha da conta : ");
			        senha = 4446523; // leitor.nextInt();
			        System.out.printf("\nInforme o numero da conta : ");
			        numeroConta = 1010; // leitor.nextInt();
			        System.out.printf("\nInforme o saldo da conta : ");
			        saldoAtual = 2500; // leitor.nextDouble();
			        Calendar hoje = Calendar.getInstance();
			        dataAbertura = hoje.getTime();
			        System.out.printf("\nEscolha qual a agencia da conta, 0 para a primeiro agencia cadastrado, 1 para a segundo agencia cadastrado ... : "); 
			        escolheAgConta = 0; // leitor.nextInt();
			        System.out.printf("\nEscolha qual o cliente da conta, 0 para a primeiro cliente cadastrado, 1 para a segundo cliente cadastrado ... : "); 
			        escolheCliente = 0; // leitor.nextInt();
			        
			        DadosContas.cadastrar(new Salario(codigo, flagueAtiva, senha, numeroConta, saldoAtual, dataAbertura, DadosAgencias.getAgencias().get(escolheAgConta), DadosClientes.getClientes().get(escolheCliente)));
			        
			        leitor.nextLine(); 
			        System.out.printf("\n");
			      }
				leitor.nextLine(); 
				 System.out.printf("\n");
			}
		
		System.out.println(DadosContas.getContas());
		
		System.out.printf("\n\nTRANSACOES: \n\n");
		
		// Transacoes
		while (true) {
			System.out.printf("Escolha o tipo de transa��o que deseja fazer: \n");
			System.out.printf("Informe 1 saque, 2 tranferencia e 3 deposito ou -1 para encerrar:\n");
			escolheTransacao = leitor.nextInt();
			if (escolheTransacao < 0)
				break;
			
			
			// Transacao
			if (escolheTransacao == 1 ) {
				System.out.printf("\nTRANSACAO: ");
		        System.out.printf("\nEscolha em qual conta sera realiza a transacao, 1 para a conta cadastrado, 2 para a segundo conta cadastrado ... : "); 
		        escolheContaTransacao = 0; // leitor.nextInt();
		        System.out.printf("\nEscolha qual a agencia do cliente, 1 para a primeira agencia cadastrado, 2 para a segundo agencia cadastrado ... : "); 
		       	escolheAgencia = 0; // leitor.nextInt();
		       	System.out.printf("\nEscolha o tipo de transacao, S: Saque, T: Transferencia, D: Deposito : "); 
		       	tipoTransacao = 'D'; // leitor.nextInt();
		       	System.out.printf("\nInforme valor que deseja sacar : ");
		       	valorTransacao = 250; // leitor.nextDouble();
		       	
		       	Transacao transacao = new Transacao( DadosAgencias.getAgencias().get(escolheAgencia), valorTransacao, tipoTransacao, DadosContas.getContas().get(escolheContaTransacao));
					transacao.efetivaTransacao();
			       	DadosContas.atualizarSaldo(1010);
		       	
		       	System.out.println(DadosContas.getContas().get(escolheContaTransacao).getSaldoAtual());
		       	
		        leitor.nextLine(); 
		        System.out.printf("\n");
		      }

			leitor.nextLine(); 
		    System.out.printf("\n");
		}

		
		// Calculo de tarifa das contas
		System.out.println("\n TARIFA DAS CONTAS ");
		for( int i = 0 ; i < DadosContas.getContas().size() ; i++){
			System.out.printf("\nA tarifa da conta " + i + " e : " + DadosContas.getContas().get(i).calculaTarifa());
		}
	

		System.out.printf("\n\nINFORMACOES: \n\n");
		
		// Imprime informa�oes
		while (true) {
			System.out.printf("Escolha o tipo de informacoes deseja imprimir: \n");
			System.out.printf("Informe 1 para informacoes das agencias , 2 para nformacoes dos clientes,\n3 para informacoes das contas, 4 para informacoes dos funcionarios ou -1 para encerrar:\n");
			escolheTransacao = leitor.nextInt();
			if (escolheTransacao < 0)
				break;

				// Informacoes das agencias
				if (escolheTransacao == 1 ) {
					System.out.println(DadosAgencias.mostrarDados());
					leitor.nextLine(); 
				    System.out.printf("\n");
				}
					
				// Informacoes dos clientes
				if (escolheTransacao == 2 ) {
					System.out.println(DadosClientes.mostrarDados());
				    leitor.nextLine(); 
				    System.out.printf("\n"); 
				      }
					
				// Informacoes das contas
				if (escolheTransacao == 3 ) {
					System.out.println(DadosContas.mostrarDados());
				    leitor.nextLine(); 
				    System.out.printf("\n"); 
				}
				
				// Informacoes dos funcionarios
				if (escolheTransacao == 4 ) {
					System.out.println(DadosFuncionarios.mostrarDados());
				    leitor.nextLine(); 
				    System.out.printf("\n"); 
				}
				
				leitor.nextLine(); 
				System.out.printf("\n");
			}
				
		leitor.close(); 
	}
		
}
