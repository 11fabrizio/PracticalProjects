import java.io.*;
import java.net.*;

class ExemploURL {
   public static String getHtml(String endereco){
      URL url;
      InputStream is = null;
      BufferedReader br;
      String resp = "", line;

      try {
         url = new URL(endereco);
         is = url.openStream();  // throws an IOException
         br = new BufferedReader(new InputStreamReader(is));

         while ((line = br.readLine()) != null) {
            resp += line + "\n";
         }
      } catch (MalformedURLException mue) {
         mue.printStackTrace();
      } catch (IOException ioe) {
         ioe.printStackTrace();
      } 

      try {
         is.close();
      } catch (IOException ioe) {
         // nothing to see here

      }

      return resp;
   }
   public static void main(String[] args) {
      String endereco, html;
      endereco = "http://maratona.crc.pucminas.br/series/Friends.html";
      html = getHtml(endereco);
      System.out.print(html);
   }
}
public class TP01Q08 {
    public static int contaA(String fra){
        int a=0;
        for(int i=0;i<fra.length();i++){
            if(fra.charAt(i)=='a'){
                a++;
            }
        }
        return a;
    }
    public static int contaE(String fra){
        int a=0;
        for(int i=0;i<fra.length();i++){
            if(fra.charAt(i)=='e'){
                a++;
            }
        }
        return a;
    }
    public static int contaI(String fra){
        int a=0;
        for(int i=0;i<fra.length();i++){
            if(fra.charAt(i)=='i'){
                a++;
            }
        }
        return a;
    }
    public static int contaO(String fra){
        int a=0;
        for(int i=0;i<fra.length();i++){
            if(fra.charAt(i)=='o'){
                a++;
            }
        }
        return a;
    }
    public static int contaU(String fra){
        int a=0;
        for(int i=0;i<fra.length();i++){
            if(fra.charAt(i)=='u'){
                a++;
            }
        }
        return a;
    }
    public static int contaAA(String fra){
        int a=0;
        for(int i=0;i<fra.length();i++){
            if(fra.charAt(i)==160){
                a++;
            }
        }
        return a;
    }
    public static int contaEE(String fra){
        int a=0;
        for(int i=0;i<fra.length();i++){
            if(fra.charAt(i)==130){
                a++;
            }
        }
        return a;
    }
    public static int contaII(String fra){
        int a=0;
        for(int i=0;i<fra.length();i++){
            if(fra.charAt(i)==161){
                a++;
            }
        }
        return a;
    }
    public static int contaOO(String fra){
        int a=0;
        for(int i=0;i<fra.length();i++){
            if(fra.charAt(i)==162){
                a++;
            }
        }
        return a;
    }
    public static int contaUU(String fra){
        int a=0;
        for(int i=0;i<fra.length();i++){
            if(fra.charAt(i)==163){
                a++;
            }
        }
        return a;
    }
    public static int contaAAA(String fra){
        int a=0;
        for(int i=0;i<fra.length();i++){
            if(fra.charAt(i)==133){
                a++;
            }
        }
        return a;
    }
    public static int contaEEE(String fra){
        int a=0;
        for(int i=0;i<fra.length();i++){
            if(fra.charAt(i)==138){
                a++;
            }
        }
        return a;
    }
    public static int contaIII(String fra){
        int a=0;
        for(int i=0;i<fra.length();i++){
            if(fra.charAt(i)==141){
                a++;
            }
        }
        return a;
    }
    public static int contaOOO(String fra){
        int a=0;
        for(int i=0;i<fra.length();i++){
            if(fra.charAt(i)==149){
                a++;
            }
        }
        return a;
    }
    public static int contaUUU(String fra){
        int a=0;
        for(int i=0;i<fra.length();i++){
            if(fra.charAt(i)==151){
                a++;
            }
        }
        return a;
    }
    public static int contaAAAA(String fra){
        int a=0;
        for(int i=0;i<fra.length();i++){
            if(fra.charAt(i)==198){
                a++;
            }
        }
        return a;
    }
    public static int contaOOOO(String fra){
        int a=0;
        for(int i=0;i<fra.length();i++){
            if(fra.charAt(i)==228){
                a++;
            }
        }
        return a;
    }
    public static int contaAAAAA(String fra){
        int a=0;
        for(int i=0;i<fra.length();i++){
            if(fra.charAt(i)==131){
                a++;
            }
        }
        return a;
    }
    public static int contaEEEEE(String fra){
        int a=0;
        for(int i=0;i<fra.length();i++){
            if(fra.charAt(i)==136){
                a++;
            }
        }
        return a;
    }
    public static int contaIIIII(String fra){
        int a=0;
        for(int i=0;i<fra.length();i++){
            if(fra.charAt(i)==140){
                a++;
            }
        }
        return a;
    }
    public static int contaOOOOO(String fra){
        int a=0;
        for(int i=0;i<fra.length();i++){
            if(fra.charAt(i)==147){
                a++;
            }
        }
        return a;
    }
    public static int contaUUUUU(String fra){
        int a=0;
        for(int i=0;i<fra.length();i++){
            if(fra.charAt(i)==150){
                a++;
            }
        }
        return a;
    }
    public static int contaConsoante(String fra){
        int a=0;
        for(int i=0;i<fra.length();i++){
            if(fra.charAt(i)!='a'&&fra.charAt(i)!='e'&&fra.charAt(i)!='i'&&fra.charAt(i)!='o'&&fra.charAt(i)!='u'&&fra.charAt(i)!='A'&&fra.charAt(i)!='E'&&fra.charAt(i)!='I'&&fra.charAt(i)!='O'&&fra.charAt(i)!='U'){
                if((fra.charAt(i)>=97&&fra.charAt(i)<=122)){
                    a++;
                }                       
            }
        }
        return a;
    }
    public static int contaBR(String fra){
        int a=0;
        for(int i=0;i<fra.length();i++){
            if(i<=fra.length()-4){
                if(fra.charAt(i)==60&&fra.charAt(i+1)=='b'&&fra.charAt(i+2)=='r'&&fra.charAt(i+3)==62){
                    a++;
                }
            }           
        }
        return a;
    }
    public static int contaTABLE(String fra){
        int a=0;
        for(int i=0;i<fra.length();i++){
            if(i<=fra.length()-8){
                if(fra.charAt(i)==60&&fra.charAt(i+1)=='t'&&fra.charAt(i+2)=='a'&&fra.charAt(i+3)=='b'&&fra.charAt(i+4)=='l'&&fra.charAt(i+5)=='e'&&fra.charAt(i+6)==62){
                    a++;
                }
            }           
        }
        return a;
    }
    public static void main(String[] args){
        String[] nome = new String[1000];
        String url;
        String[] html = new String[1000];
        int i=0;
        nome[i] = MyIO.readLine();
        while(nome[i].equals("FIM")==false){
            url = MyIO.readLine();
            if(url.equals("FIM")){
                nome[i]="FIM";
            }
            else{
                html[i] = ExemploURL.getHtml(url);
                i++;
                nome[i] = MyIO.readLine();
            } 
        }
        for(int x=0;x<i;x++){
            MyIO.println("a("+contaA(html[x])+") e("+contaE(html[x])+") i("+contaI(html[x])+") o("+contaO(html[x])+") u("+contaU(html[x])+") á("+contaAA(html[x])+") é("+contaEE(html[x])+") í("+contaII(html[x])+") ó("+contaOO(html[x])+") ú("+contaUU(html[x])+") à("+contaAAA(html[x])+") è("+contaEEE(html[x])+") ì("+contaIII(html[x])+") ù("+contaUUU(html[x])+") ã("+contaAAAA(html[x])+") õ("+contaOOOO(html[x])+") â("+contaAAAAA(html[x])+") ê("+contaEEEEE(html[x])+") î("+contaIIIII(html[x])+") ô("+contaOOOOO(html[x])+") û("+contaUUUUU(html[x])+") consoante("+contaConsoante(html[x])+") <br>("+contaBR(html[x])+") <table>("+contaTABLE(html[x])+") "+nome[x]+" ");
        }
    }
}
