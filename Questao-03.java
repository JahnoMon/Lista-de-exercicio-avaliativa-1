/*
Escreva um programa em Java que leia dados referentes a alunos. Nessas
entradas, deve-se informar, através de uma string, o nome completo do aluno, o seu
período de entrada e o seu CRA. Entradas serão pedidas até que uma entrada vazia seja
fornecida. Escreva métodos que calculem as seguintes estatísticas:

a) A média aritmética do CRA de todos os alunos X
b) A média aritmética do CRA de alunos de um período específico X
c) A mediana do CRA de todos os alunos 
d) A moda do CRA de todos os alunos
e) O desvio padrão do CRA de todos os alunos
f) A variância do CRA de todos os alunos
g) O nome do aluno com o maior CRA dentre todos os alunos
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections; // c)

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

        public static double calcularMediaDasNotas(ArrayList<Aluno> alunos){
            double somaDasNotas = 0.0;
            int quantidadeDeAlunos = alunos.size();
    
            for(Aluno aluno : alunos){
                somaDasNotas += aluno.getCra()
            }
    
             return somaDasNotas / quantidadeDeAlunos;
        }
        
        public double calcularMediaCra(ArrayList<Aluno> alunos, int periodo) {
            double somaCra = 0.0;
            int numAlunos = 0;
        
            for (Aluno aluno : alunos) {
                if (aluno.getPeriodo() == periodo) {
                    somaCra += aluno.getCra();
                    numAlunos++;
                }
            }
        
            if (numAlunos == 0) {
                // Evita divisão por zero se não houver alunos no período
                return 0.0;
            } else {
                return somaCRA / numAlunos;
            }
        }

        public static double encontrarMediana(ArrayList<Aluno> alunos){

            Collections.sort(alunos, (a1, a2) -> Double.compare(a1.getCra(), a2.getCra()));

            private int tamanho = alunos.size();
            
            if(tamanho % 2 == 1){
                return alunos.get(tamanho / 2).getCra();
            }else{
                int meio = tamanho / 2;
                double cra1 = alunos.get(meio -1).getCra();
                double cra2 = alunos.get(meio).getCra();
                return (cra1 + cra2) / 2.0;
            }
        }

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
