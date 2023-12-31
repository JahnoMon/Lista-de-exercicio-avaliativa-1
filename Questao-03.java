/*
Escreva um programa em Java que leia dados referentes a alunos. Nessas
entradas, deve-se informar, através de uma string, o nome completo do aluno, o seu
período de entrada e o seu CRA. Entradas serão pedidas até que uma entrada vazia seja
fornecida. Escreva métodos que calculem as seguintes estatísticas:

a) A média aritmética do CRA de todos os alunos X
b) A média aritmética do CRA de alunos de um período específico X
c) A mediana do CRA de todos os alunos X
d) A moda do CRA de todos os alunos X
e) O desvio padrão do CRA de todos os alunos X
f) A variância do CRA de todos os alunos X
g) O nome do aluno com o maior CRA dentre todos os alunos X
*/

package Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Aluno {
	private String nome;
	private String periodo;
	private double cra;

	public Aluno(String nome, String periodo, double cra) {
		this.nome = nome;
		this.periodo = periodo;
		this.cra = cra;
	}

	public String getNome() {
		return nome;
	}

	public String getPeriodo() {
		return periodo;
	}

	public double getCra() {
		return cra;
	}
}

public class ListaAlunos {

	public static void main(String[] args) {
		ArrayList<Aluno> alunos = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Insira os dados do aluno (nome, periodo e CRA):");

		while (true) {
			System.out.print("Digite o nome do aluno:");
			String nome = scanner.nextLine().trim();

			if (nome.isEmpty()) {
				break;
			}

			System.out.print("Periodo atual: ");
			String periodo = scanner.nextLine();

			System.out.print("CRA do aluno: ");
			double cra = Double.parseDouble(scanner.nextLine());

			Aluno aluno = new Aluno(nome, periodo, cra);
			alunos.add(aluno);
		}

		scanner.close(); // Certifique-se de fechar o scanner após o uso.

		double mediaCra = calcularMediaCra(alunos, "2023");
		System.out.println("Média do CRA dos alunos no período 2023: " + mediaCra);

		double medianaCra = encontrarMediana(alunos);
		System.out.println("Mediana do CRA de todos os alunos: " + medianaCra);

		List<Double> modaCRAs = encontrarModa(alunos);
		System.out.println("Moda do CRA dos alunos: " + modaCRAs);

		double desvioPadrao = calcularDesvioPadrao(alunos);
		System.out.println("Desvio Padrão do CRA dos alunos: " + desvioPadrao);

		double variancia = calcularVariancia(alunos);
		System.out.println("Variância do CRA dos alunos: " + variancia);

		Aluno alunoMaiorCRA = encontrarAlunoMaiorCRA(alunos);
		System.out.println("Aluno com o maior CRA: " + alunoMaiorCRA.getNome());
	}

	public static double calcularMediaCra(ArrayList<Aluno> alunos, String periodo) {
		double somaCra = 0.0;

		for (Aluno aluno : alunos) {
			if (aluno.getPeriodo().equals(periodo)) {
				somaCra += aluno.getCra();
			}
		}

		if (alunos.isEmpty()) return 0.0;
		else return somaCra / alunos.size();
	}

	public static double encontrarMediana(ArrayList<Aluno> alunos) {
		
		Collections.sort(alunos, (a1, a2) -> Double.compare(a1.getCra(), a2.getCra()));

		int tamanho = alunos.size();

		if (tamanho % 2 == 1) {
			return alunos.get(tamanho / 2).getCra();
		} else {
			int meio = tamanho / 2;
			double cra1 = alunos.get(meio - 1).getCra();
			double cra2 = alunos.get(meio).getCra();
			return (cra1 + cra2) / 2.0;
		}
	}

	public static List<Double> encontrarModa(ArrayList<Aluno> alunos) {
		// mapa para contar a frequência de CRA
		Map<Double, Integer> frequenciaCRA = new HashMap<>();

		// percorrer a lista e faz a contagem
		for (Aluno aluno : alunos) {
			double cra = aluno.getCra();
			frequenciaCRA.put(cra, frequenciaCRA.getOrDefault(cra, 0) + 1);
		}

		// Encontre o(s) CRA(s) com a maior frequência
		int maiorFrequencia = 0;
		List<Double> modaCRAs = new ArrayList<>();

		for (Map.Entry<Double, Integer> entry : frequenciaCRA.entrySet()) {
			int frequencia = entry.getValue();
			double cra = entry.getKey();

			if (frequencia > maiorFrequencia) {
				maiorFrequencia = frequencia;
				modaCRAs.clear();
				modaCRAs.add(cra);
			} else if (frequencia == maiorFrequencia) {
				modaCRAs.add(cra);
			}
		}
		return modaCRAs;
	}

	public static double calcularDesvioPadrao(ArrayList<Aluno> alunos) {
		double media = calcularMediaCra(alunos, "2023");
		double somaQuadradosDiferencas = 0.0;

		for (Aluno aluno : alunos) {
			double diferenca = aluno.getCra() - media;
			somaQuadradosDiferencas += diferenca * diferenca;
		}

		return Math.sqrt(somaQuadradosDiferencas / (alunos.size() - 1));
	}

	public static double calcularVariancia(ArrayList<Aluno> alunos) {
		double media = calcularMediaCra(alunos, "2023");
		double somaQuadradosDiferencas = 0.0;

		for (Aluno aluno : alunos) {
			double diferenca = aluno.getCra() - media;
			somaQuadradosDiferencas += diferenca * diferenca;
		}

		return somaQuadradosDiferencas / (alunos.size() - 1);
	}

	public static Aluno encontrarAlunoMaiorCRA(ArrayList<Aluno> alunos) {
		Aluno alunoMaiorCra = null;
		double maiorCra = Double.MIN_VALUE;

		for (Aluno aluno : alunos) {
			if (aluno.getCra() > maiorCra) {
				maiorCra = aluno.getCra();
				alunoMaiorCra = aluno;
			}
		}

		return alunoMaiorCra;
	}
}
