package br.faesa.Algoritimo.Forca;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;
public class gameForca {
	static StringBuilder guardPalavErrad = new StringBuilder();
	static int forCa_Mont = 7;
	static Random ranDomm = new Random();
	static boolean perDeu = false;
	static StringBuilder sepLetraSeparador = new StringBuilder();
	static String palavra;
	static String capTura;
	private static Scanner scann;
	private static String nome;
	private static String menu;
	private static String newPalavra;
	private static String[] bancoDP = { "PAULO", "BRASIL", "MORCEGO", "ALGORITIMO", "JAVA", "UNIVERSO", "SAIDEIRA","ADVINHAR","UNIVERSIDADE","LIVRE","PROGRAMA"
	,"MARTELO","UVA","HENDRIX","MOREIRA","ECLIPSE","LINUX","WINDOWS","APLICATIVO","WEB"};
	private static ArrayList<String> bancoDPalavras = new ArrayList<String>();
		public static void main(String args[]) throws Exception {
			criaListaNome();
		menuGame();	
		}
	public static void criaListaNome(){
		int i;
		for(i = 0; i<bancoDP.length;i++){
			bancoDPalavras.add(bancoDP[i]);
		}
	}
	public static void telaInicio() {
		palavra = getGerarPalavra();
		System.out.println("Dica .... A palavra sorteada tem:  " + palavra.length() + " Letras:!");
		for (int i = palavra.length(); i > 0; i--) {
			sepLetraSeparador = sepLetraSeparador.append("-");
		}
		System.out.println(sepLetraSeparador);
		getInicio();
		checarPalavra();
		while (!perDeu) {
			System.out.println("..................................");
			getInicio();
			checarPalavra();
			if (forCa_Mont == 0) {
				perDeu = true;
				System.out.println("Ixi não deu Certo, mas podemos tentar de novo na Proxima..");
				System.out.println(" a palavra sorteada era .. >  " + palavra);
				menuGame();
			} else if (palavra.equals(sepLetraSeparador.toString())) {
				perDeu = true;
				System.out.println("Parabens você Acertou: Hurruuu... Noss você e Bom");
				menuGame();
			}
	}}
	public static void limparConfigDefault() { /* aqui. iniciar o metodo, de limpesa zerando todos os metodos a cima com alguma coisa dentro. e dando valores Default.. a eles*/
		forCa_Mont = 7;
		perDeu = false;
		palavra = "";
		capTura = "";
		sepLetraSeparador.delete(0, sepLetraSeparador.length()); 
		guardPalavErrad.delete(0, guardPalavErrad.length()); 
		montarTelaInicio();
	}
	public static void getInicio() {
		scann = new Scanner(System.in);
		System.out.println("");
		System.out.println("Vamos lá, Digite uma Letra:");
		capTura = scann.nextLine().toUpperCase();
		if (capTura.length() > 1 ||Character.isDigit(capTura.length())) {
			System.out.println("Você Digitou Mais que Uma Letra! :( ");
			capTura = scann.next();
		} else if (capTura.length() == 0||Character.isDigit(capTura.charAt(0))) {
			JOptionPane.showMessageDialog(null,
					"Você não digitou uma Letra, ou esta vazio" + "\n" + "Tente Novamente" + "\n" + "Letra ok !");
			capTura = scann.next();
		} else {
			System.out.println("Letra Digitada: " + capTura);
	}}
	public static void checarPalavra() {
		if (!palavra.contains(capTura)) {
			forCa_Mont =forCa_Mont-1;
			System.out.println("Ops.. a Palavra não tem esta Letra >  " + capTura);
			guardPalavErrad = guardPalavErrad.append(capTura);
			MontForca();
			System.out.println("Acertos :" + sepLetraSeparador);
			System.out.println("Palpite Errados >> :( " + guardPalavErrad+" )");
		} else {
			System.out.println("Que Bom.. é isto ai ..");
			for (int i = 0; i < palavra.length(); i++) {
				if (palavra.charAt(i) == capTura.charAt(0)) {
					sepLetraSeparador.replace(i, i + 1, capTura);
				}
			}
			System.out.println("::::::::::::::::::::::::::");
			MontForca();
			System.out.println("Você acertou Huruu:   " + sepLetraSeparador);
			System.out.println("Palpites Errados :( " + guardPalavErrad+" )");
	}}
	public static void menuGame(){
		String tile="---game Forca---";
		menu = JOptionPane.showInputDialog(null, "Ola Bem Vido! Game da Forca"+"\n"+"1)- Jogar:"+"\n"+"2)- Inserir nova palavra:"+"\n"+"3)- Sair",tile,0);
		if(menu.equals("1")){
			limparConfigDefault();		
		}else if(menu.equals("2")){
			newPalavra=JOptionPane.showInputDialog(null,"Digite uma Palavra nova");
			setNewPalavra(newPalavra);
		}else if(menu.equals("3")){
			System.exit(0);
		}	
		JOptionPane.showConfirmDialog(null,"Em você não digitou uma opção correta, Vamos Novamente..");
		menuGame();
	}
	public static void nomeGamer() {
		String[] expec={"!","#","$","%","¨","&","*","(",")","-","_","+","=","§","¬","°","/","?","}","{","º","ª"};
		nome = JOptionPane.showInputDialog(null, "Ola Bem Vido! Game da Forca. Digite Seu nome..:","---Game Forca---",3);
		for(int i = 0 ; i<nome.length();i++){
			if(Character.isDigit(nome.charAt(i))){
				JOptionPane.showMessageDialog(null,"Você digitou Nº, não um Nome:",JOptionPane.ICON_PROPERTY,0);
				System.out.println("você digitou um numero: ");
				nomeGamer();
				break;
			}/*else if(Character.isDigit(nome.charAt(i)==Character.isDigit(expec[i].toCharArray()))){
				JOptionPane.showMessageDialog(null, "Você digitou algum caracter especial não pode: ");
				nomeGamer();*/
			else if(nome.equals("")){
				JOptionPane.showMessageDialog(null, "você não digitou nada mesmo assim vamos iniciar o game, afinal de contras ninguem e obrigado.. :)");
				setNome(nome);
			}
	}}
	public static String getGerarPalavra() {
		palavra = bancoDPalavras.get(ranDomm.nextInt(bancoDPalavras.size()));
		return palavra;
	}
	public static void setNewPalavra(String newPalavra) { // Metodo Adicionar	
		for(int i = 0 ; i<newPalavra.length();i++){
			if(Character.isDigit(newPalavra.charAt(i))){
				JOptionPane.showMessageDialog(null,"Você digitou Nº, não um Nome:",JOptionPane.ICON_PROPERTY,0);
				System.out.println("você digitou um numero: ");
				menuGame();
				break;
			}}// Novo Nome ...
		for (int i = 0; i < newPalavra.length(); i++) {
			if (Character.isDigit(newPalavra.charAt(i))) {
				JOptionPane.showMessageDialog(null, "Esta Palavra contem Números: não e permitido!");
			}else if (newPalavra.trim().length() == 0 || newPalavra.equals(null)) {
				JOptionPane.showMessageDialog(null, "Esta em branco vamos tentar novamente");
				menuGame();
			} else {
				bancoDPalavras.add(newPalavra);
				JOptionPane.showMessageDialog(null, "Sua Palavra foi adicionada: " +newPalavra);
				menuGame();
			}
	}}
	public static String getNome() {
		return nome;
	}
	public static void setNome(String nome) {
		gameForca.nome = nome;
	}
	public static void montarTelaInicio() {
		nomeGamer();
		System.out.println("_______________________________________________________________________");
		System.out.println("|                                                                      |");
		System.out.println("|" + "  :::: Ola.. Bem vindo ao Game Jogo da Forca.Algoritimos I ::::" + "       |");
		System.out.println("|" + "  :::: Developer: Paulo Hendrix Alves Moreira              ::::" + "       |");
		System.out.println("|" + "  :::: Professor: Howard Cruz Roatti                       ::::" + "       |");
		System.out.println("|" + "  :::: Vamos JOGAR ...!                                    ::::" + "       |");
		System.out.println("|______________________________________________________________________|");
		System.out.println(" ");
		System.out.println("_______________**     ****    **    *    * *****     ******    **       ********");
		System.out.println("               **    **      *  *   **  ** **        **   **  *  *      ********");
		System.out.println("               **    **  ** ******  ****** *****     **   ** ******     ********");
		System.out.println("               **    ***** **    ** **  ** **        **  ** **    **    ********");
		System.out.println("               **      **  **    ** **  ** *****     ***** **      **   ********");
		System.out.println("               **                                                       ********");
		System.out.println("               **     ******  ****   *******   ****     **              ********");
		System.out.println("               **     **     **  **  **  **   **       *  *             ********");
		System.out.println("               **     ***** **    ** ** **   **       ******            ********");
		System.out.println("               **     **    **    ** ***     **      **    **           ********");
		System.out.println("               **     **     **  **  ** **    **    **      **          ********");
		System.out.println("               **     *       ****   **  **    *** **        **         ********");
		System.out.println("");
		System.out.println("      Seja bem Vindo ''"+getNome()+"'' Vamos Jogar");
		System.out.println("_____Começou____você tem 7 Chances para errar...");
		telaInicio();
	}
	public static void MontForca() {
		switch (forCa_Mont) {
		case 0:
			System.out.println("     _Você Foi Enforcado_**");
			System.out.println("     | ___            **");
			System.out.println("     |(-_-)           **");
			System.out.println("     |--º             **");
			System.out.println("       /|\\            **");
			System.out.println("      / | \\           **");
			System.out.println("     /  |  \\          **");
			System.out.println("        |             **");
			System.out.println("        |             **");
			System.out.println("       / \\            **");
			System.out.println("      /   \\           **");
			System.out.println("     /     \\          **");
			System.out.println("!!!!!!!Game Over!!!!!! <<< Você foi enforcado >>>");
			  try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {e.printStackTrace();}
			break;
		case 1:
			System.out.println("	__________________**");
			System.out.println("     	___            **");
			System.out.println("       (-_-)           **");
			System.out.println("                       **");
			System.out.println("     	/|\\            **");
			System.out.println("       / | \\           **");
			System.out.println("      /  |  \\          **");
			System.out.println("         |             **");
			System.out.println("         |             **");
			System.out.println("        / \\            **");
			System.out.println("       /   \\           **");
			System.out.println("      /     \\          **");
			System.out.println("                      <<< ATENÇÃO !!Tentativa: 06 >>>");
			break;
		case 2:
			System.out.println("	_________________**");
			System.out.println("	    ___            **");
			System.out.println("	   (-_-)           **");
			System.out.println("	                   **");
			System.out.println("	   / | \\           **");
			System.out.println("	  /  |  \\          **");
			System.out.println("	 /   |   \\         **");
			System.out.println("	     |             **");
			System.out.println("	     |             **");
			System.out.println("	      \\            **");
			System.out.println("	       \\           **");
			System.out.println("	        \\          **");
			System.out.println("                      ____Nada Bom .. Tentativa: 05");
			break;
		case 3:
			System.out.println("	_________________**");
			System.out.println("	    ___            **");
			System.out.println("	   (-_-)           **");
			System.out.println("	                   **");
			System.out.println("	   / | \\           **");
			System.out.println("	  /  |  \\          **");
			System.out.println("	 /   |   \\         **");
			System.out.println("	     |             **");
			System.out.println("	     |             **");
			System.out.println("	                   **");
			System.out.println("	                   **");
			System.out.println("	                   **");
			System.out.println("                      ____Nada Bom .. Tentativa: 04");
			break;
		case 4:
			System.out.println("	_________________**");
			System.out.println("	    ___            **");
			System.out.println("	   (-_-)           **");
			System.out.println("	                   **");
			System.out.println("	     | \\           **");
			System.out.println("	     |  \\          **");
			System.out.println("	     |   \\         **");
			System.out.println("	     |             **");
			System.out.println("	     |             **");
			System.out.println("	                   **");
			System.out.println("	                   **");
			System.out.println("	                   **");
			System.out.println("	                  ____Nada Bom .. Tentativa: 03");
			break;
		
		case 5:
			System.out.println("	_________________**");
			System.out.println("	    ___            **");
			System.out.println("	   (-_-)           **");
			System.out.println("	                   **");
			System.out.println("	     |             **");
			System.out.println("	     |             **");
			System.out.println("	     |             **");
			System.out.println("	     |             **");
			System.out.println("	     |             **");
			System.out.println("	                   **");
			System.out.println("	                   **");
			System.out.println(" 	                  **");
			System.out.println("                      ____Nada Bom .. Tentativa: 02");
			break;
		case 6:
			System.out.println("	_________________**");
			System.out.println("	    ___            **");
			System.out.println("	   (-_-)           **");
			System.out.println("	                   **");
			System.out.println("	                   **");
			System.out.println("	                   **");
			System.out.println("	                   **");
			System.out.println("	                   **");
			System.out.println("	                   **");
			System.out.println("	                   **");
			System.out.println("	                   **");
			System.out.println("	                   **");
			System.out.println("                      ____Nada Bom .. Tentativa: 01");
			break;
}}}