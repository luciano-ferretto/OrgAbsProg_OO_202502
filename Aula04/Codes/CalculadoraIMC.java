
public class CalculadoraIMC {
    public static void main(String[] args) {

        char genero = 'm';
        double imc = 39.995;
        System.out.println(classificaIMC(genero, imc));

    }

    static String classificaIMC(char genero, double imc) {
        return switch (genero) {
            case 'M', 'm':
                if (imc >= 40)
                    yield "Obesidade Mórbida";
                else if (imc >= 30)
                    yield "Obesidade Moderada";
                else if (imc >= 25)
                    yield "Obesidade Leve";
                else if (imc >= 20)
                    yield "Normal";
                else
                    yield "Abaixo do Normal";
            case 'F', 'f', 'N', 'n':
                if (imc >= 39)
                    yield "Obesidade Mórbida";
                else if (imc >= 29)
                    yield "Obesidade Moderada";
                else if (imc >= 24)
                    yield "Obesidade Leve";
                else if (imc >= 19)
                    yield "Normal";
                else
                    yield "Abaixo do Normal";
            default:
                yield "";
        };
    }
}
