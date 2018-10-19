public class CuboSemantico {
    private static int[][][] cubo = new int[12][3][3];

    public static void cuboSemantico(){
        //cubo[]
        // "+" = 0, "-" = 1, "*" = 2, "/" = 3, "==" = 4, "<=" = 5, "<" = 6,
        // ">=" = 7, ">" = 8, "!=" = 9, "||" = 10, "&&" == 11
        //cubo[][]
        //int= 0,float=1,char=2, ERR = -1

        //Suma
        cubo[0][0][0] = 0;
        cubo[0][0][1] = 1;
        cubo[0][0][2] = 2;
        cubo[0][1][0] = 1;
        cubo[0][1][1] = 1;
        cubo[0][1][2] = -1;
        cubo[0][2][0] = 2;
        cubo[0][2][1] = -1;
        cubo[0][2][2] = 2;

        //Resta
        cubo[1][0][0] = 0;
        cubo[1][0][1] = 1;
        cubo[1][0][2] = 2;
        cubo[1][1][0] = 1;
        cubo[1][1][1] = 1;
        cubo[1][1][2] = -1;
        cubo[1][2][0] = 2;
        cubo[1][2][1] = -1;
        cubo[1][2][2] = 2;

        //Multiplicacion
        cubo[2][0][0] = 0;
        cubo[2][0][1] = 1;
        cubo[2][0][2] = -1;
        cubo[2][1][0] = 1;
        cubo[2][1][1] = 1;
        cubo[2][1][2] = -1;
        cubo[2][2][0] = -1;
        cubo[2][2][1] = -1;
        cubo[2][2][2] = -1;

        //Division
        cubo[3][0][0] = 1;
        cubo[3][0][1] = 1;
        cubo[3][0][2] = -1;
        cubo[3][1][0] = 1;
        cubo[3][1][1] = 1;
        cubo[3][1][2] = -1;
        cubo[3][2][0] = -1;
        cubo[3][2][1] = -1;
        cubo[3][2][2] = -1;
    }

    public static int getValidacion(int operador, int ladoIzq, int ladoDer){
        //Nomeclatura de acuerdo a los tokens definidos en orden
        // "+" = 18, "-" = 19, "/" = 20, "*" = 21, ">" = 22, "<" = 23, "==" = 24, ">=" = 25, "<=" = 26, "!" = 27, "&&" = 28, "||" = 29
        // int = 36, float = 37, char = 38
        if(ladoIzq<35){ladoIzq+=35;} //Las palabras reservadas int, float y char están en el rango de 6 a 8, se les suma 24 para su validación semantica sin modificar el cubo
        if(ladoDer<35){ladoDer+=35;} //

        operador -= 18; //resta 18 para que 0 sea suma y de ahí en delante
        ladoIzq -= 35;  //resta 36 para que 0 sea int y de ahí en delante
        ladoDer -= 35;  //resta 36 para que 0 sea int y de ahí en delante

        if(ladoIzq < 0 || ladoIzq > 2 || ladoDer < 0 || ladoDer > 2) {
            return -1;
        }

        return cubo[operador][ladoIzq][ladoDer];
    }
}
