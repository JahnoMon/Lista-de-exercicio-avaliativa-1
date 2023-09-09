/*
Escreva um programa em Java que leia dados referentes a alunos. Nessas
entradas, deve-se informar, através de uma string, o nome completo do aluno, o seu
período de entrada e o seu CRA. Entradas serão pedidas até que uma entrada vazia seja
fornecida. Escreva métodos que calculem as seguintes estatísticas:

a) A média aritmética do CRA de todos os alunos
b) A média aritmética do CRA de alunos de um período específico
c) A mediana do CRA de todos os alunos
d) A moda do CRA de todos os alunos
e) O desvio padrão do CRA de todos os alunos
f) A variância do CRA de todos os alunos
g) O nome do aluno com o maior CRA dentre todos os alunos
*/

import java.util.ArrayList;
import java.util.Scanner;

class listaAlunos {
    public static void main(String[] args){
        ArrayList<Aluno> alunos = new ArrayList<>();
        Scanner scanner = new Scanner(Systm.in);
        
        System.out.println("Insira os dados do aluno (nome, periodo e CRA):");
        
        while(true){
            
            System.out.print("Digite o nome do aluno:");
            String nome = scanner.nextLine().trim(); // tipo o split() do python
            
            if(nome.isEmpty()){
                break;
            }
            
            System.out.print("Periodo atual: ");
            String periodo = scanner.nextLine();
            
            System.out.print("CRA do aluno: ");
            double cra = Double.parseDouble(scanner.nextLine());
            
            Aluno aluno = new Aluno(nome, periodo, cra);
            alunos.add(aluno);
        }

        double somaDasNotas = 0.0;
        int quantidadeDeAlunos = alunos.size();

        for(Aluno aluno : alunos){
            somaDasNotas += aluno.getCra()
        }

        double mediaDasNotas = somaDasNotas / quantidadeDeAlunos;
    }  
}

class Alunos{
    private String nome;
    private String periodo;
    private double cra;
    
    public Aluno(String nome, String periodo, double cra){
        this.nome = nome;
        this.periodo = periodo;
        this.cra = cra;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getPeriodo(){
        return periodo;
    }
    
    public double getCra(){
        return cra;
    }
}
