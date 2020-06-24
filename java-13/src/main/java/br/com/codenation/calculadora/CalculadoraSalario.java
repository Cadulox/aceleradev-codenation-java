package br.com.codenation.calculadora;

public class CalculadoraSalario {

	private final double SALARIOMINIMO = 1039.00;

	public long calcularSalarioLiquido(double salarioBase) {
		if (salarioBase < SALARIOMINIMO) {
			return 0;
		}
		salarioBase = calcularInss(salarioBase);
		salarioBase = calcularIrff(salarioBase);

		return Math.round(salarioBase);
	}

	private double calcularInss(double salarioBase) {
		if (salarioBase <= 1500.00) {
			return salarioBase * .92;
		} else if (salarioBase <= 4000.00) {
			return salarioBase * .91;
		}
		return salarioBase * .89;
	}

	private double calcularIrff(double salarioBase) {
		if (salarioBase <= 3000.00) {
			return salarioBase;
		} else if (salarioBase <= 6000.00) {
			return salarioBase * .925;
		}
		return salarioBase * .85;
	}

}