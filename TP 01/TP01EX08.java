import java.io.*;
import java.net.*;

class TP01EX08 {
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

    public static void tagTable(String str) {
        int cont = 0;

        for(int i=0; i<str.length(); i++) {
            if(i+1 < str.length()) {
                if(str.charAt(i) == '<' && str.charAt(i+1) == 't' && str.charAt(i+2) == 'a' && str.charAt(i+3) == 'b'  && str.charAt(i+4) == 'l' && str.charAt(i+5) == 'e' && str.charAt(i+6) == '>') {
                    cont++;
                }
            }
        }

        MyIO.print("<table>("+ cont +") ");
    }

    public static void tagBr(String str) {
        int cont = 0;

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '<' && str.charAt(i+1) == 'b' && str.charAt(i+2) == 'r' && str.charAt(i+2) == '>') {
                cont++;
            }
        }

        MyIO.print("<br>("+ cont +") ");
    }

    public static void consoantes(String str) {
        char vet[] = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};
        int consoantes=0;

        for(int i=0; i<str.length(); i++) {
            for(int j=0; j<vet.length; j++) {
                if(str.charAt(i) == vet[j]) {
                    consoantes++;
                }
            }
        }

        MyIO.print("consoantes("+ consoantes +") ");
    }

    public static void vogais(String str) {
        int a = 0, e = 0, i = 0, o = 0, u = 0;
        int a1 =0, a2=0, a3=0, a4=0;
        int e1=0, e2=0, e3=0;
        int i1=0, i2=0, i3=0;
        int o1=0, o2=0, o3=0, o4=0;
        int u1=0, u2=0, u3=0;

        for(int j=0; j<str.length(); j++) {
            if(str.charAt(j) == (char)97){ 
                a++;
            }

            if(str.charAt(j) == (char)101){ 
                e++;
            }

            if(str.charAt(j) == (char)105){ 
                i++;
            }

            if(str.charAt(j) == (char)111){ 
                o++;
            }

            if(str.charAt(j) == (char)117){ 
                u++;
            }

            if(str.charAt(j) == (char)225){ 
                a1++;
            }

            if(str.charAt(j) == (char)233){ 
                e1++;
            }

            if(str.charAt(j) == (char)237){ 
                i1++;
            }

            if(str.charAt(j) == (char)243){ 
                o1++;
            }

            if(str.charAt(j) == (char)250){ 
                u1++;
            }

            if(str.charAt(j) == (char)224){ 
                a2++;
            }

            if(str.charAt(j) == (char)232){ 
                e2++;
            }

            if(str.charAt(j) == (char)236){ 
                i2++;
            }

            if(str.charAt(j) == (char)242){ 
                o2++;
            }

            if(str.charAt(j) == (char)249){ 
                u2++;
            }

            if(str.charAt(j) == (char)227){ 
                a3++;
            }

            if(str.charAt(j) == (char)245){ 
                o3++;
            }

           if(str.charAt(j) == (char)226){ 
                a4++;
            }

            if(str.charAt(j) == (char)234){ 
                e3++;
            }

            if(str.charAt(j) == (char)238){ 
                i3++;
            }

            if(str.charAt(j) == (char)244){ 
                o4++;
            }

            if(str.charAt(j) == (char)251){ 
                u3++;
            }
        }

        MyIO.print((char)97  + "("+ a +") ");
        MyIO.print((char)101 + "("+ e +") ");
        MyIO.print((char)105 + "("+ i +") ");
        MyIO.print((char)111 + "("+ o +") ");
        MyIO.print((char)117 + "("+ u +") ");
        MyIO.print((char)225 + "("+ a1 +") ");
        MyIO.print((char)233 + "("+ e1 +") ");
        MyIO.print((char)237 + "("+ i1 +") ");
        MyIO.print((char)243 + "("+ o1 +") ");
        MyIO.print((char)250 + "("+ u1 +") ");
        MyIO.print((char)224 + "("+ a2 +") ");
        MyIO.print((char)232 + "("+ e2 +") ");
        MyIO.print((char)236 + "("+ i2 +") ");
        MyIO.print((char)242 + "("+ o2 +") ");
        MyIO.print((char)249 + "("+ u2 +") ");
        MyIO.print((char)227 + "("+ a3 +") ");
        MyIO.print((char)245 + "("+ o3 +") ");
        MyIO.print((char)226 + "("+ a4 +") ");
        MyIO.print((char)234 + "("+ e3 +") ");
        MyIO.print((char)238 + "("+ i3 +") ");
        MyIO.print((char)244 + "("+ o4 +") ");
        MyIO.print((char)251 + "("+ u3 +") ");
    }

    public static void lerCaracter(String str, String nome) {
        vogais(str);
        consoantes(str);
        tagBr(str);
        tagTable(str);
        MyIO.println(nome);
    }

    public static boolean isFim(String str) {
        boolean resp = false;

        if(str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M') {
            resp = true;
        }

        return resp;
    }
    public static void main(String[] args) {
        String html, aux;
        String[] entradas = new String[1000];
        String[] nomes = new String[100];
        int cont = 0, contNome=0;

        MyIO.setCharset("UTF-8");

        do {
            aux  = MyIO.readLine();

            if(aux.indexOf("http") != -1) {
                entradas[cont] = aux;
                cont++;
            } 
            else {
                nomes[contNome] = aux;
                contNome++;
            }
        }while(isFim(aux) != true);

        for(int i=0; i<cont; i++) {
            html = getHtml(entradas[i]);
            lerCaracter(html, nomes[i]);
        }
   }
}