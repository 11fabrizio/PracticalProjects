/**
 * @author Fabrizio Peragallo de Mello
 */
/*class Alvinegra {
    private NoAN raiz; // Raiz da arvore.
 
 
    public Alvinegra() {
       raiz = null;
    }
 
    public boolean pesquisar(String elemento) {
      System.out.println(elemento);
      System.out.print("raiz ");
       return pesquisar(elemento, raiz);
    }
 
    private boolean pesquisar(String elemento, NoAN i) {
       boolean resp;
       if (i == null) {
         System.out.println("NAO");
          resp = false;
       } else if (elemento.compareTo(i.elemento.getName())==0) {
         System.out.println("SIM");
          resp = true;
       } else if (elemento.compareTo(i.elemento.getName())<0) {
         System.out.print("esq ");
          resp = pesquisar(elemento, i.esq);
       } else {
         System.out.print("dir ");
          resp = pesquisar(elemento, i.dir);
       }
       return resp;
    }
 
    public void inserir(GameOficial elemento) throws Exception {
       // Se a arvore estiver vazia
       if (raiz == null) {
          raiz = new NoAN(elemento);
          //System.out.println("Antes, zero elementos. Agora, raiz(" + raiz.elemento + ").");
 
       // Senao, se a arvore tiver um elemento
       } else if (raiz.esq == null && raiz.dir == null) {
          if (elemento.getName().compareTo(raiz.elemento.getName())<0) {
             raiz.esq = new NoAN(elemento);
             //System.out.println("Antes, um elemento. Agora, raiz(" + raiz.elemento + ") e esq(" + raiz.esq.elemento + ").");
          } else {
             raiz.dir = new NoAN(elemento);
             //System.out.println("Antes, um elemento. Agora, raiz(" + raiz.elemento + ") e dir(" + raiz.dir.elemento + ").");
          }
 
       // Senao, se a arvore tiver dois elementos (raiz e dir)
       } else if (raiz.esq == null) {
          if (elemento.getName().compareTo(raiz.elemento.getName())<0) {
             raiz.esq = new NoAN(elemento);
             //System.out.println("Antes, dois elementos(A). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento + ") e dir(" + raiz.dir.elemento + ").");
 
          } else if (elemento.getName().compareTo(raiz.dir.elemento.getName())<0) {
             raiz.esq = new NoAN(raiz.elemento);
             raiz.elemento = elemento;
             //System.out.println("Antes, dois elementos(B). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento + ") e dir(" + raiz.dir.elemento + ").");
 
          } else {
             raiz.esq = new NoAN(raiz.elemento);
             raiz.elemento = raiz.dir.elemento;
             raiz.dir.elemento = elemento;
             //System.out.println("Antes, dois elementos(C). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento + ") e dir(" + raiz.dir.elemento + ").");
          }
          raiz.esq.cor = raiz.dir.cor = false;
 
       // Senao, se a arvore tiver dois elementos (raiz e esq)
       } else if (raiz.dir == null) {
          if (elemento.getName().compareTo(raiz.elemento.getName())>0) {
             raiz.dir = new NoAN(elemento);
             //System.out.println("Antes, dois elementos(D). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento + ") e dir(" + raiz.dir.elemento + ").");
 
          } else if (elemento.getName().compareTo(raiz.esq.elemento.getName())>0) {
             raiz.dir = new NoAN(raiz.elemento);
             raiz.elemento = elemento;
             //System.out.println("Antes, dois elementos(E). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento + ") e dir(" + raiz.dir.elemento + ").");
 
          } else {
             raiz.dir = new NoAN(raiz.elemento);
             raiz.elemento = raiz.esq.elemento;
             raiz.esq.elemento = elemento;
             //System.out.println("Antes, dois elementos(F). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento + ") e dir(" + raiz.dir.elemento + ").");
          }
          raiz.esq.cor = raiz.dir.cor = false;
 
       // Senao, a arvore tem tres ou mais elementos
       } else {
          //System.out.println("Arvore com tres ou mais elementos...");
          inserir(elemento, null, null, null, raiz);
       }
       raiz.cor = false;
    }
 
    private void balancear(NoAN bisavo, NoAN avo, NoAN pai, NoAN i) {
       // Se o pai tambem e preto, reequilibrar a arvore, rotacionando o avo
       if (pai.cor == true) {
          // 4 tipos de reequilibrios e acoplamento
          if (pai.elemento.getName().compareTo(avo.elemento.getName()) > 0) { // rotacao a esquerda ou direita-esquerda
             if (i.elemento.getName().compareTo(pai.elemento.getName()) > 0) {
                avo = rotacaoEsq(avo);
             } else {
                avo = rotacaoDirEsq(avo);
             }
          } else { // rotacao a direita ou esquerda-direita
             if (i.elemento.getName().compareTo(pai.elemento.getName()) < 0) {
                avo = rotacaoDir(avo);
             } else {
                avo = rotacaoEsqDir(avo);
             }
          }
          if (bisavo == null) {
             raiz = avo;
          } else if (avo.elemento.getName().compareTo(bisavo.elemento.getName()) < 0) {
             bisavo.esq = avo;
          } else {
             bisavo.dir = avo;
          }
          // reestabelecer as cores apos a rotacao
          avo.cor = false;
          avo.esq.cor = avo.dir.cor = true;
          //System.out.println("Reestabeler cores: avo(" + avo.elemento + "->branco) e avo.esq / avo.dir("
                //+ avo.esq.elemento + "," + avo.dir.elemento + "-> pretos)");
       } // if(pai.cor == true)
    }
 
    private void inserir(GameOficial elemento, NoAN bisavo, NoAN avo, NoAN pai, NoAN i) throws Exception {
       if (i == null) {
          if (elemento.getName().compareTo(pai.elemento.getName()) < 0) {
             i = pai.esq = new NoAN(elemento, true);
          } else {
             i = pai.dir = new NoAN(elemento, true);
          }
          if (pai.cor == true) {
             balancear(bisavo, avo, pai, i);
          }
       } else {
          // Achou um 4-no: eh preciso fragmeta-lo e reequilibrar a arvore
          if (i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true) {
             i.cor = true;
             i.esq.cor = i.dir.cor = false;
             if (i == raiz) {
                i.cor = false;
             } else if (pai.cor == true) {
                balancear(bisavo, avo, pai, i);
             }
          }
          if (elemento.getName().compareTo(i.elemento.getName()) < 0) {
             inserir(elemento, avo, pai, i, i.esq);
          } else if (elemento.getName().compareTo(i.elemento.getName()) > 0) {
             inserir(elemento, avo, pai, i, i.dir);
          } else {
             throw new Exception("Erro inserir (elemento repetido)!");
          }
       }
    }
 
    private NoAN rotacaoDir(NoAN no) {
       //System.out.println("Rotacao DIR(" + no.elemento + ")");
       NoAN noEsq = no.esq;
       NoAN noEsqDir = noEsq.dir;
 
       noEsq.dir = no;
       no.esq = noEsqDir;
 
       return noEsq;
    }
 
    private NoAN rotacaoEsq(NoAN no) {
       //System.out.println("Rotacao ESQ(" + no.elemento + ")");
       NoAN noDir = no.dir;
       NoAN noDirEsq = noDir.esq;
 
       noDir.esq = no;
       no.dir = noDirEsq;
       return noDir;
    }
 
    private NoAN rotacaoDirEsq(NoAN no) {
       no.dir = rotacaoDir(no.dir);
       return rotacaoEsq(no);
    }
 
    private NoAN rotacaoEsqDir(NoAN no) {
       no.esq = rotacaoEsq(no.esq);
       return rotacaoDir(no);
    }
 
    public void remover(String x) throws Exception {
      raiz = remover(x, raiz);
   }
 
   private NoAN remover(String x, NoAN i)  {
      if (i == null) {
         
      } else if (x.compareTo(i.elemento.getName())<0) {
         i.esq = remover(x, i.esq);
      } else if (x.compareTo(i.elemento.getName())>0) {
         i.dir = remover(x, i.dir);
      // Sem no a direita.
      } else if (i.dir == null) {
         i = i.esq;
      // Sem no a esquerda.
      } else if (i.esq == null) {
         i = i.dir;
      // No a esquerda e no a direita.
      } 
      return i;
   }
 }
 
 class NoAN {
  public boolean cor;
  public GameOficial elemento;
  public NoAN esq, dir;
 
  public NoAN() {
    this(null);
  }
 
  public NoAN(GameOficial elemento) {
    this(elemento, false, null, null);
  }
 
  public NoAN(GameOficial elemento, boolean cor) {
    this(elemento, cor, null, null);
  }
 
  public NoAN(GameOficial elemento, boolean cor, NoAN esq, NoAN dir) {
    this.cor = cor;
    this.elemento = elemento;
    this.esq = esq;
    this.dir = dir;
  }
 }
 
 class GameOficial{
   // DeclaraÃ§Ã£o de variÃ¡veis
   private int app_id;
   private String name;
   private String release_data;
   private String owners;
   private int age;
   private float price;
   private int dlcs;
   private String languages;
   private String website;
   private Boolean windows;
   private Boolean mac;
   private Boolean linux;
   private float upvotes;
   private int avg_pt;
   private String developers;
   private String genres;
   // Construtor vazio 
   public GameOficial() {
       setAppId(0);
       setName("");
       setData("");
       setOwners("");
       setAge(0);
       setPrice(0);
       setDlcs(0);
       setLanguages(null);
       setWebsite("");
       setWindows(true);
       setMac(true);
       setLinux(true);
       setUpVotes(0);
       setAvgPt(0);
       setDevelopers("");
       setGenres("");
   }
   // Construtor padrÃ£o
   public GameOficial(int AppId,String nome,String data,String owner,int idade,float preco,int dlc,String linguas, String web,Boolean window,Boolean mec,Boolean lin,float upvotos,int avg,String develop,String gen){
       setAppId(AppId);
       setName(nome);
       setData(data);
       setOwners(owner);
       setAge(idade);
       setPrice(preco);
       setDlcs(dlc);
       setLanguages(linguas);
       setWebsite(web);
       setWindows(window);
       setMac(mec);
       setLinux(lin);
       setUpVotes(upvotos);
       setAvgPt(avg);
       setDevelopers(develop);
       setGenres(gen);
   }
   // Sets e Gets
   public void setAppId(int AppId){
       app_id=AppId;
   }
   public int getAppId(){
       return app_id;
   }
   public void setName(String nome){
       name = nome;
   }
   public String getName(){
       return name;
   }
   public void setData(String data){
       release_data=data;
   }
   public String getData(){
       return release_data;
   }
   public void setOwners(String owner){
       owners=owner;
   }
   public String getOwners(){
       return owners;
   }
   public void setAge(int idade){
       age=idade;
   }
   public int getAge(){
       return age;
   }
   public void setPrice(float preco){
       price=preco;
   }
   public float getPrice(){
       return price;
   }
   public void setDlcs(int dlc){
       dlcs=dlc;
   }
   public int getDlcs(){
       return dlcs;
   }
   public void setLanguages(String linguas){
       languages=linguas;
   }
   public String getLanguages(){
       return languages;
   }
   public void setWebsite(String web){
       website=web;
   }
   public String getWebsite(){
       return website;
   }
   public void setWindows(Boolean window){
       windows=window;
   }
   public Boolean getWindows(){
       return windows;
   }
   public void setMac(Boolean mec){
       mac=mec;
   }
   public Boolean getMac(){
       return mac;
   }
   public void setLinux(Boolean lin){
       linux=lin;
   }
   public Boolean getLinux(){
       return linux;
   }
   public void setUpVotes(float upvotos){
       upvotes=upvotos;
   }
   public float getUpVotes(){
       return upvotes;
   }
   public void setAvgPt(int avg){
       avg_pt=avg;
   }
   public int getAvgPt(){
       return avg_pt;
   }
   public void setDevelopers(String develop){
       developers=develop;
   }
   public String getDevelopers(){
       return developers;
   }
   public void setGenres(String gen){
       genres=gen;
   }
   public String getGenres(){
       return genres;
   }
   public void Criador(String ID){
       setAppId(Integer.parseInt(ID));
       String linhaf="";
       Arq.openRead("/tmp/games.csv","UTF-8");
       int lixo=0; // Quebra a repetiÃ§Ã£o quando acha linha do ID do jogo
       while(Arq.hasNext()&&lixo==0){
           String linha = Arq.readLine();
           int max = (linha.length() < ID.length()) ? linha.length() : ID.length();
           String verificaID = linha.substring(0,max);
           if(verificaID.equals(ID)){
               linhaf=linha;
               lixo=1;
           }
       }
       // Achar posiÃ§Ã£o das vÃ­rgulas
       int[] V = new int[16];
       int a=0;
       for(int i=0;i<linhaf.length();i++){
           if(linhaf.charAt(i)==91){
               for(int x=i;x<linhaf.length();x++){
                   if(linhaf.charAt(x)==93){
                       i=x;
                       x=linhaf.length();
                   }
               }
           }
           else if(linhaf.charAt(i)==34){
               for(int x=i+1;x<linhaf.length();x++){
                   if(linhaf.charAt(x)==34){
                       i=x;
                       x=linhaf.length();
                   }
               }
           }
           else if(linhaf.charAt(i)==44){
               V[a]=i;
               a++;
           }
       }
       // Enviar o AppId
       int AppID = Integer.parseInt(ID);
       setAppId(AppID);
       //MyIO.print(jogo.getAppId()+" ");
       // Enviar nome do jogo
       String nome = linhaf.substring(V[0]+1, V[1]);
       setName(nome);
       //MyIO.print(jogo.getName()+" ");
       // Enviar data (terminar de fazer, falta transforma em Date pra mandar pro set)
       String data = linhaf.substring(V[1]+2,V[1]+5)+"/"+linhaf.substring(V[2]-5, V[2]-1);
       setData(data);
       //MyIO.print(jogo.getData()+" ");
       // Enviar owners
       String owners = linhaf.substring(V[2]+1, V[3]);
       setOwners(owners);
       //MyIO.print(jogo.getOwners()+" ");
       // Enviar age
       int age = Integer.parseInt(linhaf.substring(V[3]+1, V[4]));
       setAge(age);
       //MyIO.print(jogo.getAge()+" ");
       // Enviar preÃ§o
       float preco = Float.valueOf(linhaf.substring(V[4]+1,V[5]));
       setPrice(preco);
       //MyIO.print(jogo.getPrice()+" ");
       // Enviar dlc
       int dlc = Integer.parseInt(linhaf.substring(V[5]+1,V[6]));
       setDlcs(dlc);
       //MyIO.print(jogo.getDlcs()+" ");
       // Enviar vetor linguagens
       String[] linguas = new String[1000];
       String linhaG="";
       a=0;
       for(int x=V[6]+2;x<V[7];x++){
           if(linhaf.charAt(x)==39){
               if(a==0){
                   linguas[a]="[";
                   linhaG+="[";
               }
               else{
                   linguas[a]=" ";
                   linhaG+=" ";
               }
               for(int n=x+1;n<V[7];n++){
                   if(linhaf.charAt(n)==39){
                       linguas[a]+=linhaf.substring(x+1, n);
                       linhaG+=linhaf.substring(x+1, n);
                       if(linhaf.charAt(n+1)==44){
                           linguas[a]+=",";
                           linhaG+=",";
                       }
                       else{
                           linguas[a]+="]";
                           linhaG+="]";
                       }
                       //MyIO.print(linguas[a]);
                       a++;
                       x=n;
                       n=V[7];
                   }
               }
           }
       }
       setLanguages(linhaG);
       //MyIO.print(jogo.getLanguages());
       //MyIO.print(" ");
       // Enviar website
       String web = linhaf.substring(V[7]+1,V[8]);
       if(web.length()==0){
           setWebsite("null");
       }
       else{
           setWebsite(web);
       } 
       //MyIO.print(jogo.getWebsite()+" ");
       // Enviar windows
       Boolean windows;
       if((linhaf.substring(V[8]+1, V[9]).equals("True"))){
           windows=true;
           //MyIO.print("true ");
       }
       else{
           windows=false;
           //MyIO.print("false ");
       }
       setWindows(windows);
       // Enviar Mac
       Boolean mac;
       if((linhaf.substring(V[9]+1, V[10]).equals("True"))){
           mac=true;
           //MyIO.print("true ");
       }
       else{
           mac=false;
           //MyIO.print("false ");
       }
       setMac(mac);
       // Enviar Linux
       Boolean linux;
       if((linhaf.substring(V[10]+1, V[11]).equals("True"))){
           linux=true;
           //MyIO.print("true ");
       }
       else{
           linux=false;
           //MyIO.print("false ");
       }
       setLinux(linux);
       // Porcentagem votos positivos
       int positivo = Integer.parseInt(linhaf.substring(V[11]+1,V[12]));
       int negativo = Integer.parseInt(linhaf.substring(V[12]+1,V[13]));
       float media = (float)positivo/((float)positivo + (float)negativo);
       setUpVotes(media);
       //MyIO.printf("%.0f",jogo.getUpVotes()*100);
       //MyIO.print("% ");
       // Horas contabilizadas
       int hTotal = Integer.parseInt(linhaf.substring(V[13]+1, V[14]));
       int horas = hTotal/60;
       int min = hTotal%60;
       if(horas==0&&min==0){
           setAvgPt(0);
           //MyIO.print("null ");
       }
       else{
           setAvgPt(hTotal);
           //System.out.printf("%dh ",horas);
           //System.out.printf("%dm ",min);
       }
       // Empresa do jogo
       String empresa = linhaf.substring(V[14]+1, V[15]);
       if(empresa.charAt(0)!=34){
           setDevelopers(empresa);    
       }
       else{
           setDevelopers(empresa.substring(1,empresa.length()-1));
       }
       //MyIO.print(empresa+" ");
       // GenÃªro do jogo
       //String genero = "[";
       String generoG = "[";
       a=0;
       if(linhaf.charAt(V[15]+1)==34){
           for(int i=V[15]+2;i<linhaf.length();i++){
               for(int x=i;x<linhaf.length();x++){
                   if(linhaf.charAt(x)==44){
                       //genero+=linhaf.substring(i, x);
                       generoG+=linhaf.substring(i, x);
                       //genero+=", ";
                       generoG+=", ";
                       i=x;
                       x=linhaf.length();
                   }
                   else if(linhaf.charAt(x)==34){
                       //genero+=linhaf.substring(i, x);
                       generoG+=linhaf.substring(i, x);
                       //genero+="]";
                       generoG+="]";
                       i=linhaf.length();
                       x=linhaf.length();
                   }
               }
           }
       }
       else{
           generoG+=linhaf.substring(V[15]+1, linhaf.length());
           //genero+=linhaf.substring(V[15]+1, linhaf.length());
           generoG+="]";
           //genero+="]";
       }
       setGenres(generoG);
   }
   public void Imprime(){
       MyIO.print(getAppId()+" ");
       MyIO.print(getName()+" ");
       MyIO.print(getData()+" ");
       MyIO.print(getOwners()+" ");
       MyIO.print(getAge()+" ");
       if(getPrice()==0){
           MyIO.print(getPrice()+"0 ");
       }
       else{
           MyIO.print(getPrice()+" ");
       }
       MyIO.print(getDlcs()+" ");
       MyIO.print(getLanguages()+" ");
       MyIO.print(getWebsite()+" ");
       if(getWindows()==true){
           MyIO.print("true ");
       }
       else{
           MyIO.print("false ");
       }
       if(getMac()==true){
           MyIO.print("true ");
       }
       else{
           MyIO.print("false ");
       }
       if(getLinux()==true){
           MyIO.print("true ");
       }
       else{
           MyIO.print("false ");
       }
       MyIO.printf("%.0f",getUpVotes()*100);
       MyIO.print("% ");
       if(getAvgPt()==0){
           MyIO.print("null ");
       }
       else if(getAvgPt()<60){
           MyIO.print(getAvgPt()%60+"m ");
       }
       else if(getAvgPt()%60==0){
           MyIO.print(getAvgPt()/60+"h ");
       }
       else{
           MyIO.print(getAvgPt()/60+"h "+getAvgPt()%60+"m ");
       }
       if(getDevelopers().charAt(0)==34){
           MyIO.print(getDevelopers().substring(1, getDevelopers().length()-1)+" ");
       }
       else{
           MyIO.print(getDevelopers()+" ");
       }
       MyIO.println(getGenres());
   }
 }
 
 public class TP05Q04 {
   public static void main(String[] args){
       String ID = MyIO.readLine();
       Alvinegra arvore = new Alvinegra();
       while(!ID.equals("FIM")){
           GameOficial game = new GameOficial();
           game.Criador(ID);
           try {
               arvore.inserir(game);    
           } catch (Exception vasco) {
               System.out.println("Fabo lindo!");
           }
           ID=MyIO.readLine();
       }
       int N = MyIO.readInt();
       for(int i=0;i<N;i++){
           String nome = MyIO.readLine();
           if(nome.charAt(0)=='I'){
               GameOficial game = new GameOficial();
               game.Criador(nome.substring(2, nome.length()));
               try {
                   arvore.inserir(game);
               } catch (Exception vasco) {
                   System.out.println("Fabo gato!");
               }
           }
           else{
               try {
                   arvore.remover(nome);
               } catch (Exception vasco) {
                   //System.out.println("Fabo gostoso!");
               }
               
           }
       }
       String nome = MyIO.readLine();
       while(!nome.equals("FIM")){
           arvore.pesquisar(nome);
           nome=MyIO.readLine();
       }
   }
 }*/
 