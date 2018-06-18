/*	Autor: Igor Luciano de Paula
 *
 *	O programa realiza o cálculo de fibonacci, de acordo com a entrada, de maneira iterativa.
 */

#include <iostream>
#include <string>
#include <sstream>

using namespace std;

//Criando uma nova exceção
class InvalidArgException{
	public:
		InvalidArgException(int n);
		void Msg();
	private:
		int NLinha;
};

InvalidArgException::InvalidArgException(int n){
	NLinha = n;
}

void InvalidArgException::Msg(){
	cout << "Erro: " << NLinha << endl;

}

//Cálculo de Fibonacci na forma iterativa
unsigned long long int fibonacci_iterativo (unsigned long long int n){
	unsigned long long int i = 1, j = 1, soma;

	if(n == 0)
		return 0;

	for (int k = 3; k <= n; k++){
		soma = i + j;
		i = j;
		j = soma;
	}

	return j;	
};

int main(){
	int n;
	string x;

	cout << "Fibonacci" << endl;
	
	//unsigned long long int é capaz de representar no máximo fib(93)
	try{
		cout << "Digite um número (0-93): ";
		cin >> x;

		// Caso o usuário digite uma string ou character - evita abortar
		istringstream (x) >> n;

		if (n > 93 || n < 0)
			throw new InvalidArgException(n); //Lança Exceção


	} catch(InvalidArgException* E){
		int invalido = 1;
		E->Msg();
		do{
			cout << "Valor de entrada inválido. Tente um número entre 0 e 93: ";				
			cin >> x;
			
			istringstream (x) >> n;

			if(n >= 0 && n <= 93)
				invalido = 0;
			
		} while (invalido);
			
                delete E; //desaloca ponteiro E
	}
	

	cout << fibonacci_iterativo (n) << endl;

	return 0;
}
