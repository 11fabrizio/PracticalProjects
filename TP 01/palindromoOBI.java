public class palindromoOBI {
    public static int isPal(String str){
        //System.out.println("a "+str);
        for(int i=0;i<str.length()/2;i++){
            if(!(str.charAt(i)==str.charAt(str.length()-1-i))){
                return 1;
            }
        }
        //System.out.println(str.length());
        return (str.length());
    }
    public static void main(String[] args){
        int N = MyIO.readInt();
        String str = MyIO.readLine();
        int verifica = 1;
        for(int i=0;i<N;i++){
            for(int x=N-1;x>0+i;x--){
                int pal = isPal(str.substring(i,x+1));
                if(pal>verifica){
                    verifica=pal;
                }
            }
        }
        System.out.println(verifica);
    }
    
}
