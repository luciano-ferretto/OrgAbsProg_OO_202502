public class OperadorCurtoCircuito {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;
        if (num2 > 0 && num1 % num2 == 0)
            System.out.println("Num2 é fator de Num1");
        if (num2 > 0) {
            if (num1 % num2 == 0)
                System.out.println("Num2 é fator de Num1");
        }
    }
}
