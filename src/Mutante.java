import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Mutante {
    public static boolean isMutant(@NotNull List<String> adn) {
        //Obtener el tamaño de la matriz de NxN (misma cantidad de letras que de filas)
        int largo = adn.get(0).length();
        //No puede haber un patrón de 4 caracteres iguales si no hay al menos 4 caracteres
        if (largo <= 3) {
            return false;
        }
        //La matriz debe ser cuadrada
        if (adn.size() != largo) {
            return false;
        }
        for (String s : adn)
        {
            if(!s.matches("[ATCG]+"))
            {
                return false;
            }
        }


        int cont = 0;
        boolean resultado;
        //Recorrer todas las cadenas
        for(String s : adn)
        {

            //Recorrer letra por letra de la cadena
            //Si al menos una cadena contiene las 4 letras eso significa que el adn es mutante
            for(int i = 0; i<largo-3; i++)
            {
                if(CompararCaracteres(s.charAt(i), s.charAt(i+1), s.charAt(i+2), s.charAt(i+3)))
                {
                    cont++;
                    if(cont == 2)
                    {
                        return true;
                    }
                }
            }
        }

        //Verifico de forma vertical
        for(int i = 0; i < largo; i++)
        {
            for(int j = 0; j < largo-3; j++)
            {
                if(CompararCaracteres(adn.get(j).charAt(i), adn.get(j+1).charAt(i), adn.get(j+2).charAt(i), adn.get(j+3).charAt(i)))
                {
                    cont++;
                    if(cont == 2)
                    {
                        return true;
                    }
                }
            }
        }

        //Recorro las diagonales hacia la derecha (mismo sentido que la diagonal principal)
        for(int i = 0; i< largo-3; i++)
        {
            for(int j = 0; j<largo-3 ; j++)
            {
                if(CompararCaracteres(adn.get(i).charAt(j), adn.get(i+1).charAt(j+1), adn.get(i+2).charAt(j+2), adn.get(i+3).charAt(j+3)))
                {
                    cont++;
                    if(cont == 2)
                    {
                        return true;
                    }
                }
            }
        }

        //Recorro las diagonales hacia la izquierda (mismo sentido que la diagonal secundaria)
        for(int i = 0; i < largo-3; i++)
        {
            for(int j = 0; j <= largo-4; j++)
            {
                if(CompararCaracteres(adn.get(i).charAt(largo-j-1), adn.get(i+1).charAt(largo-j-2),adn.get(i+2).charAt(largo-j-3), adn.get(i+3).charAt(largo-j-4)))
                {
                    cont++;
                    if(cont == 2)
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean CompararCaracteres(char A, char B, char C, char D)
    {
        if(A == B && A == C && A == D)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
