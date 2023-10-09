class Game{
    // Declaração de variáveis
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
    public Game() {
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
    // Construtor padrão
    public Game(int AppId,String nome,String data,String owner,int idade,float preco,int dlc,String linguas, String web,Boolean window,Boolean mec,Boolean lin,float upvotos,int avg,String develop,String gen){
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
    public void Imprime(){
        MyIO.print(getAppId()+" ");
        MyIO.print(getName()+" ");
        MyIO.print(getData()+" ");
        MyIO.print(getOwners()+" ");
        MyIO.print(getAge()+" ");
        MyIO.print(getPrice()+" ");
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
        else{
            MyIO.print(getAvgPt()/60+"h "+getAvgPt()%60+"m ");
        }
        MyIO.print(getDevelopers()+" ");
        MyIO.println(getGenres());

    }
    
}

public class TP02Q03 {
    public static void main(String[] args){
        Game[] jogo = new Game[1000];
        int cont=0;
        String ID = MyIO.readLine();
        while(ID.equals("FIM")==false){
            String linhaf="";
            Arq.openRead("/tmp/games.csv");
            int lixo=0;
            while(Arq.hasNext()&&lixo==0){
                String linha = Arq.readLine();
                int max = (linha.length() < ID.length()) ? linha.length() : ID.length();
                String verificaID = linha.substring(0, max);
                if(verificaID.equals(ID)==true){
                    linhaf=linha;
                    lixo=1;
                }
            }
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
            jogo[cont] = new Game();
            int appID = Integer.parseInt(ID);
            jogo[cont].setAppId(appID);
            String nome = linhaf.substring(V[0]+1, V[1]);
            jogo[cont].setName(nome);
            //MyIO.println(jogo[cont].getAppId()+" "+jogo[cont].getName());
            cont++;
            ID = MyIO.readLine();
        }
        String nome = MyIO.readLine();
        while(nome.equals("FIM")==false){
            Boolean vasco=false;
            for(int i=0;i<cont;i++){
                if(jogo[i].getName().equals(nome)){
                    vasco=true;
                    i=cont;
                }
            }
            if(vasco==true){
                MyIO.println("SIM");
            }
            else{
                MyIO.println("NAO");
            }
            nome=MyIO.readLine();
        }
    }
}
