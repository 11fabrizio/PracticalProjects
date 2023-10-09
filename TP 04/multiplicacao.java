public class multiplicacao {
    public static void main(String[] args){
        int[][] M1 = new int[2][2];
        int[][] M2 = new int[2][2];
        for(int ln=0;ln<M1.length;ln++){
            for(int col=0;col<M1.length;col++){
                M1[ln][col]=MyIO.readInt();
            }
        }
        for(int ln=0;ln<M1.length;ln++){
            for(int col=0;col<M1.length;col++){
                M2[ln][col]=MyIO.readInt();
            }
        }
        for(int ln=0;ln<M1.length;ln++){
            for(int col=0;col<M1.length;col++){
                int soma=0;
                for(int i=0;i<M1.length;i++){
                    soma+=M1[ln][i]*M2[i][col];
                }
                System.out.print(soma+" ");
            }
            System.out.println();
        }
    }
}