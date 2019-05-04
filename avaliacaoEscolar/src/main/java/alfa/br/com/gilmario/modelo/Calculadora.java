package alfa.br.com.gilmario.modelo;

public class Calculadora {
	
	public int soma(int a, int b){
		return a + b;
	}
	
	public int subtracao(int a, int b){
		return a - b;
	}
	
	public int multiplicacao(int a, int b){
		return a * b;
	}
	
	public int divisao(int a, int b) throws ArithmeticException{
		if (b != 0){
			return a / b;
		}else{
			throw new ArithmeticException("Não é possível divisão por zero.");
		}
	}
}
