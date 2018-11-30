import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> adn = new ArrayList<>();
        String linea;

        //leer todas las cadenas en la entrada
        while(sc.hasNextLine() && !(linea = sc.nextLine()).equals(""))
        {
            adn.add(linea);
        }

        var mut = Mutante.isMutant(adn);

        System.out.println(mut);
    }
}
