/*
Escreva a classe Circulo em Java, definindo seus atributos e criando dois
métodos, no mínimo, para ela: circunferencia() e area().
*/

public class Circulo {
    private double raio = 10;
    private double circunferencia;
    private double area;
    
    public void area(){
        area =  Math.PI*raio*raio;
    }
    public double getArea(){
        return area;
    }
    
    public void circunferencia(){
        circunferencia = Math.PI*raio*2;
    }
    public double getCircunferencia(){
        return circunferencia;
    }
    
    public static void main(String[] args) {
        Circulo circulo = new Circulo();
        
        circulo.area();
        circulo.circunferencia();
        
        System.out.printf("Area: %.2f%n", circulo.getArea());
        System.out.printf("Circunferencia: %.2f%n", circulo.getCircunferencia());
    }
}
