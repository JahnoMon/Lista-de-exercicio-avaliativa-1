/*
Crie uma classe Java que representa figuras geométricas genéricas. Forneça
uma maneira estática de sabermos quantas figuras geométricas foram instanciadas ao
longo do programa. Faça com que essa classe seja a base para figuras geométricas mais
específicas. Para cada figura geométrica, forneça uma maneira de calcular a sua área e
obter seu número de lados. Por fim, crie um programa que contenha uma coleção dessas
figuras e, através de um laço for-each, imprima a área de todas as figuras contidas nesta
coleção.
*/

import java.util.ArrayList;
import java.util.List;

class FiguraGeometrica {
    private static int contador = 0;

    public FiguraGeometrica() {
        contador++;
    }

    public double calcularArea() {
        return 0.0;
    }

    public int getNumeroDeLados() {
        return 0;
    }

    public static int getNumeroDeFigurasCriadas() {
        return contador;
    }
}

class Retangulo extends FiguraGeometrica {
    private double altura;
    private double largura;

    public Retangulo(double altura, double largura) {
        this.altura = altura;
        this.largura = largura;
    }

    @Override
    public double calcularArea() {
        return altura * largura;
    }

    @Override
    public int getNumeroDeLados() {
        return 4;
    }
}

class Triangulo extends FiguraGeometrica {
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return (base * altura) / 2;
    }

    @Override
    public int getNumeroDeLados() {
        return 3;
    }
}

public class ProgramaFiguras {
    public static void main(String[] args) {
        List<FiguraGeometrica> figuras = new ArrayList<>();
        figuras.add(new Retangulo(5.0, 3.0));
        figuras.add(new Triangulo(4.0, 6.0));

        for (FiguraGeometrica figura : figuras) {
            System.out.println("Área: " + figura.calcularArea());
            System.out.println("Número de Lados: " + figura.getNumeroDeLados());
        }

        System.out.println("Total de figuras criadas: " + FiguraGeometrica.getNumeroDeFigurasCriadas());
    }
}

