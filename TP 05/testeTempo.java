public class testeTempo {
    public static void main(String[] args){
        long tempoInicial = System.currentTimeMillis();
        // Código
        long tempoFinal = System.currentTimeMillis();
        System.out.println("Tempo gasto: "+(tempoFinal-tempoInicial)/1000); // Retorna em segundos
    }
}
