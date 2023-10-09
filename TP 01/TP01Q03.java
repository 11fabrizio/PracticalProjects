class TP01Q03 {
  public static String resultado(String cifra){
    String frase = "";
    for(int i=0;i<cifra.length();i++){
      frase += (char)((int)cifra.charAt(i)+3);
    }
    return frase;
  }
  public static void main(String[] args) {
    String[] cifra = new String[1000];
    int i=0, a=0;
    do{
      cifra[i]=MyIO.readLine();
      if(cifra[i].charAt(0)=='F'&&cifra[i].charAt(1)=='I'&&cifra[i].charAt(2)=='M'&& cifra[i].length()==3){
        a=1;
      }
      i++;
    }while(a==0);
    for(int x=0;x<i-1;x++)
      {
        MyIO.println(resultado(cifra[x]));
      }
  }
}