package Pratica04;
//Classe registra os dados armazenados no vetor de Items
public class Item {
int chave;
public Item(int chave) {
this.chave = chave;
}
//Compara as chaves registradas do tipo Item
public int compara(Item it) {
Item item = it;
if (this.chave < item.chave)
return -1;
else if (this.chave > item.chave)
return 1;
return 0;
}
public int getChave() {
return chave;
}
}