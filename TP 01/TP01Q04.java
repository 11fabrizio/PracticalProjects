import java.util.Scanner;
import java.util.Random;
class TP01Q04 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    char char1;
    char char2;

    String[] frase = new String [1000];
    random.setSeed(4);
    int a=0,i=0;

    do{
      char1 = (char)('a'+(Math.abs(random.nextInt())%26));
      char2 = (char)('a'+(Math.abs(random.nextInt())%26));
      frase[i]=scanner.nextLine();
      if(frase[i].charAt(0)=='F'&&frase[i].
charAt(1)=='I'&&frase[i].charAt(2)=='M'&&frase[i].length()==3){
        a=1;
}
      else{
        frase[i]=frase[i].replace(char1,char2);
      }
      i++;
    }while(a==0);
    for(int x=0;x<i-1;x++){
      System.out.println(frase[x]);
    }
    scanner.close();
  }
}