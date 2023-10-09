class TP01Q11 {
    public static boolean isPal(String s){
        if(s.length()==1){
            return true;
        }
        else if(s.charAt(0)==s.charAt(s.length()-1)){
            if(s.length()==2){
                return true;
            }
            else{
                return isPal(s.substring(1,s.length()-1));
            }
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        //Boolean[] verifica = new Boolean[1000];
        //Boolean verifica;
        String palin = MyIO.readLine();
        while(palin.equals("FIM")==false){
            if(isPal(palin)==true){
                MyIO.println("SIM");
            }
            else{
                MyIO.println("NAO");
            }
            palin = MyIO.readLine();
        }
  }
}