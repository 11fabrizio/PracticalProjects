public class Questao11 {
    public static boolean Palindromo(String str, int i){
        if(i==str.length()-1){
            return true;
        }
        else{
            if(str.charAt(i)==str.charAt(str.length()-1-i)){
                return Palindromo(str, i+1);
            }
            else{
                return false;
            }
        }
    }
    public static void main(String[] args){
        String s = MyIO.readLine();
        while(s.equals("FIM")==false){
            if(Palindromo(s,0)==true){
                MyIO.println("SIM");
            }
            else{
                MyIO.println("NAO");
            }
            s = MyIO.readLine();
        }
    }
}
