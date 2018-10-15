public class CuboSemantico {
    private static int[][][] cubo = new int[12][3][3];

    public static void iniciarCubo(){
        //cubo[]
        // "+" = 0, "-" = 1, "*" = 2, "/" = 3, "==" = 4, "<=" = 5, "<" = 6,
        // ">=" = 7, ">" = 8, "!=" = 9, "||" = 10, "&&" ==11
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

    public static int cuboSemantico(int operador, int ladoIzq, int ladoDer){
        //Nomeclatura de acuerdo a los tokens definidos en orden
        // "+" = 18, "-" = 19, "/" = 20, "*" = 21, ">" = 22, "<" = 23, "==" = 24, ">=" = 25, "<=" = 26, "!" = 27, "&&" = 28, "||" = 29
        // int = 30, float = 31, char = 32
        operador = operador - 18; //resta 18 para que 0 sea suma y de ahí en delante
        if(ladoIzq == 30 || ladoIzq == 6){
            ladoIzq = 0;
        }
        else if(ladoIzq == 31 || ladoIzq == 7){
            ladoIzq = 1;
        }
        else if(ladoIzq == 32 || ladoIzq == 8){
            ladoIzq = 2;
        }
        else{
            return -1;
        }

        if(ladoDer == 30 || ladoDer == 6){
            ladoDer = 0;
        }
        else if(ladoDer == 31 || ladoDer == 7){
            ladoDer = 1;
        }
        else if(ladoDer == 32 || ladoDer == 8){
            ladoDer = 2;
        }
        else{
            return -1;
        }
        return cubo[operador][ladoIzq][ladoDer];
    }
}
