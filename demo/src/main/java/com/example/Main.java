package com.example;

public class Main {
    public static void main(String[] args) {
        Empleado administrador = new Administrador();
        Empleado tecnico = new Tecnico();
        Empleado gerente = new Gerente();
        CalculadoraSalario calculadora = new CalculadoraSalario();

        System.out.println("Salario Administrador: " + calculadora.calcular(administrador));
        System.out.println("Salario Técnico: " + calculadora.calcular(tecnico));
        System.out.println("Salario Gerente: " + calculadora.calcular(gerente));
    }
}