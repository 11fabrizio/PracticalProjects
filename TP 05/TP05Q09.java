/**
 * @author Fabrizio Peragallo de Mello
 */
/*import java.util.Scanner;
class ArvoreBinaria {
	private No raiz; // Raiz da arvore.

	public ArvoreBinaria() {
		raiz = null;
	}

	public boolean pesquisar(int x) {
		return pesquisar(x, raiz);
	}

	private boolean pesquisar(int x, No i) {
      boolean resp;
		if (i == null) {
         resp = false;

      } else if (x == i.elemento) {
         resp = true;

      } else if (x < i.elemento) {
         resp = pesquisar(x, i.esq);

      } else {
         resp = pesquisar(x, i.dir);
      }
      return resp;
	}

	public void caminharCentral() {
		caminharCentral(raiz);
		System.out.println();
	}

	private void caminharCentral(No i) {
		if (i != null) {
			caminharCentral(i.esq); // Elementos da esquerda.
			System.out.print((char)i.elemento + " "); // Conteudo do no.
			caminharCentral(i.dir); // Elementos da direita.
		}
	}

	public void caminharPre() {
		caminharPre(raiz);
        System.out.println();
	}

	private void caminharPre(No i) {
		if (i != null) {
			System.out.print((char)i.elemento + " "); // Conteudo do no.
			caminharPre(i.esq); // Elementos da esquerda.
			caminharPre(i.dir); // Elementos da direita.
		}
	}

	public void caminharPos() {
		caminharPos(raiz);
        System.out.println();
	}

	private void caminharPos(No i) {
		if (i != null) {
			caminharPos(i.esq); // Elementos da esquerda.
			caminharPos(i.dir); // Elementos da direita.
			System.out.print((char)i.elemento + " "); // Conteudo do no.
		}
	}

	public void inserir(char x) throws Exception {
		raiz = inserir(x, raiz);
	}

	private No inserir(char x, No i) throws Exception {
		if (i == null) {
         i = new No(x);

      } else if (x < i.elemento) {
         i.esq = inserir(x, i.esq);

      } else if (x > i.elemento) {
         i.dir = inserir(x, i.dir);

      } else {
         throw new Exception("Erro ao inserir!");
      }

		return i;
	}

	public void inserirPai(char x) throws Exception {
      if(raiz == null){
         raiz = new No(x);
      } else if(x < raiz.elemento){
		   inserirPai(x, raiz.esq, raiz);
      } else if(x > raiz.elemento){
		   inserirPai(x, raiz.dir, raiz);
      } else {
         throw new Exception("Erro ao inserirPai!");
      }
	}

	private void inserirPai(char x, No i, No pai) throws Exception {
		if (i == null) {
         if(x < pai.elemento){
            pai.esq = new No(x);
         } else {
            pai.dir = new No(x);
         }
      } else if (x < i.elemento) {
         inserirPai(x, i.esq, i);
      } else if (x > i.elemento) {
         inserirPai(x, i.dir, i);
      } else {
         throw new Exception("Erro ao inserirPai!");
      }
	}

	public void remover(int x) throws Exception {
		raiz = remover(x, raiz);
	}

	private No remover(int x, No i) throws Exception {

		if (i == null) {
         throw new Exception("Erro ao remover!");

      } else if (x < i.elemento) {
         i.esq = remover(x, i.esq);

      } else if (x > i.elemento) {
         i.dir = remover(x, i.dir);

      // Sem no a direita.
      } else if (i.dir == null) {
         i = i.esq;

      // Sem no a esquerda.
      } else if (i.esq == null) {
         i = i.dir;

      // No a esquerda e no a direita.
      } else {
         i.esq = maiorEsq(i, i.esq);
		}

		return i;
	}

	private No maiorEsq(No i, No j) {

      // Encontrou o maximo da subarvore esquerda.
		if (j.dir == null) {
			i.elemento = j.elemento; // Substitui i por j.
			j = j.esq; // Substitui j por j.ESQ.

      // Existe no a direita.
		} else {
         // Caminha para direita.
			j.dir = maiorEsq(i, j.dir);
		}
		return j;
	}

   public int getMaior(){
      int resp = -1;

      if(raiz != null){
         No i;
         for(i = raiz; i.dir != null; i = i.dir);
         resp = i.elemento;
      }

      return resp;
   }

   public int getMenor(){
      int resp = -1;

      if(raiz != null){
         No i;
         for(i = raiz; i.esq != null; i = i.esq);
         resp = i.elemento;
      }

      return resp;
   }

   public int getAltura(){
      return getAltura(raiz, 0);
   }

   public int getAltura(No i, int altura){
      if(i == null){
         altura--;
      } else {
         int alturaEsq = getAltura(i.esq, altura + 1);
         int alturaDir = getAltura(i.dir, altura + 1);
         altura = (alturaEsq > alturaDir) ? alturaEsq : alturaDir;
      }
      return altura;
   }

	public void remover2(int x) throws Exception {
      if (raiz == null) {
         throw new Exception("Erro ao remover2!");
      } else if(x < raiz.elemento){
         remover2(x, raiz.esq, raiz);
      } else if (x > raiz.elemento){
         remover2(x, raiz.dir, raiz);
      } else if (raiz.dir == null) {
         raiz = raiz.esq;
      } else if (raiz.esq == null) {
         raiz = raiz.dir;
      } else {
         raiz.esq = maiorEsq(raiz, raiz.esq);
      }
   }

	private void remover2(int x, No i, No pai) throws Exception {
		if (i == null) {
         throw new Exception("Erro ao remover2!");
      } else if (x < i.elemento) {
         remover2(x, i.esq, i);
      } else if (x > i.elemento) {
         remover2(x, i.dir, i);
      } else if (i.dir == null) {
         pai = i.esq;
      } else if (i.esq == null) {
         pai = i.dir;
      } else {
         i.esq = maiorEsq(i, i.esq);
		}
	}

   public int getRaiz() throws Exception {
      return raiz.elemento;
   }

   public static boolean igual (ArvoreBinaria a1, ArvoreBinaria a2){
      return igual(a1.raiz, a2.raiz);
   }

   private static boolean igual (No i1, No i2){
      boolean resp;
      if(i1 != null && i2 != null){
         resp = (i1.elemento == i2.elemento) && igual(i1.esq, i2.esq) && igual(i1.dir, i2.dir);
      } else if(i1 == null && i2 == null){
         resp = true;
      } else {
         resp = false; 
      }
      return resp;
   }

   public int soma(){
      return soma(raiz);
   }

   public int soma(No i){
      int resp = 0;
      if(i != null){
         resp = i.elemento + soma(i.esq) + soma(i.dir);
      }
      return resp;
   }

   public int quantidadePares(){
      return quantidadePares(raiz);
   }

   public int quantidadePares(No i){
      int resp = 0;
      if(i != null){
         resp = ((i.elemento % 2 == 0) ? 1 : 0) + quantidadePares(i.esq) + quantidadePares(i.dir);
      }
      return resp;
   }

   public boolean hasDiv11(){
      return hasDiv11(raiz);
   }

   public boolean hasDiv11(No i){
      boolean resp = false;
      if(i != null){
         resp = (i.elemento % 11 == 0) || hasDiv11(i.esq) || hasDiv11(i.dir);
      }
      return resp;
   }
}
class No {
    public char elemento; // Conteudo do no.
    public No esq, dir;  // Filhos da esq e dir.

    public No(char elemento) {
        this(elemento, null, null);
    }

    public No(char elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}
public class TP05Q09{
    public static void solve(){
        Scanner sc = new Scanner(System.in);
        ArvoreBinaria arvore = new ArvoreBinaria();
        while(sc.hasNext()){
            String str = sc.nextLine();
            try{
                String[] aux = new String[2];
                aux = str.split(" ");
                char c = aux[1].charAt(0);
                if(aux[0].equals("I")){                   
                    arvore.inserir(c);
                }
                else{
                    if(arvore.pesquisar(c)){
                        System.out.println(c+" existe");
                    }
                    else{
                        System.out.println(c+" nao existe");
                    }
                }
            } catch (Exception vasco){
                if(str.equals("INFIXA")){
                    arvore.caminharCentral();
                }
                else if(str.equals("PREFIXA")){
                    arvore.caminharPre();
                }
                else{
                    arvore.caminharPos();
                }
            }
        }
        sc.close();
    }
    public static void main(String[] args){
        solve();
    }
}*/