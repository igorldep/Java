
package Pratica03;
// Essa classe armazena a chave de registro e possui o metodo compara
public class Item {
private int chave;
public Item(int chave) {
this.chave = chave;
}
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