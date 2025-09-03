public class ExemploFuncao {
    static int somar(int a, int b) {
        return a + b;
    }
    static void ola(){
        System.out.println("Olá");
        //return "Olá";
    }


    public static void main(String[] args) {
        ola();
        somar(3,5);
        //somar(2.5,3);
        //somar("2","3");
        //somar(3,"2");
        //somar(2);
    }
}
