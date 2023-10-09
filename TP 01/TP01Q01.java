import java.util.Scanner;

class TP01Q01 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] palin = new String[1000];
    int a=0, i=0;
    boolean[] verifica = new boolean[1000];
    do{
      palin[i] = scanner.nextLine();
      
      if(palin[i].charAt(0)=='F'&&palin[i].charAt(1)=='I'&&palin[i].charAt(2)=='M'&& palin[i].length()==3){
        a=1;
      }
      else{
        int n=palin[i].length();
        for(int x=0;x<(palin[i].length()/2);x++){
          n--;
          if(palin[i].charAt(x)==palin[i].charAt(n)){
            if(x==(palin[i].length()/2)-1){
              verifica[i]=true;
            }
          }
          else{
              verifica[i]=false;
              x=palin[i].length();
            }     
      }
    }
    i++;
    }while(a==0);
    for(int x=0;x<i-1;x++){
      if(verifica[x]==true){
        System.out.println("SIM");
      }
      else{
        System.out.println("NAO");
      }
    }
    scanner.close();
  }
}