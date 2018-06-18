/*	Autor: Igor Luciano de Paula
 *
 *	O programa verifica na sequência de 1 até N(entrada) se o valor de cada número é multiplo de 3, 5 ou de ambos.
 *	Caso o número seja multiplo de 3 -> imprime Take; Caso o número seja multiplo de 5 -> imprime Net;
 *	Caso o número seja multiplo de 3 e de 5 -> imprime TakeNet.
 */

#include <iostream>
#include <string>
#include <sstream>

#define MAX 2147483646 // Valor máximo possível em um inteiro

int multiple(int num, int op);

using namespace std;

int main(){
	int n;
	string x, InvalidArgs;
	
	try {
		cout << "Digite um número: ";
		cin >> x;

		istringstream (x) >> n; // Caso o usuário digite uma string ou character - evita abortar
		
		// Verifica valores válidos - int até 2.147.483.647
		if(n < 1 || n > MAX)
			throw InvalidArgs;
	} catch (string e){ // Caso o valor de entrada tenha saído da faixa válida
		int invalido = 1;
		cout << "Valor Inválido!" << endl;
		do{
			cout << "Tente um valor entre 1 e 2147483646: ";
			cin >> x;
		
			istringstream (x) >> n;

			if(n >= 1 && n <= MAX)
				invalido = 0;
			
		} while (invalido);
	}

	for (int i = 1; i <= n; i++){
		if(multiple(i, 15)){ //Os números que são multiplos de 3 e 5 são os multiplos de 15;
			cout << "TakeNet" << " ";
		}
		else if(multiple(i, 3)){ //Verifica: multiplo de 3
			//outra possível solução seria verificar aqui se o número é multiplo de 5, se sim TakeNet
			cout << "Take" << " ";	
		}
		else if(multiple(i, 5)){ //Verifica: multiplo de 5
			cout << "Net" << " ";
		}
		else{
			cout << i << " ";
		}
	}
	cout << endl;
	
	return 0;
}

int multiple(int num, int op){
	if(!(num % op))
		return 1;

	return 0;
}

