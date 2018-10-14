public class CuboSemantico {
    private static int[][][] cubo = new int[12][3][3];

    public static void iniciarCubo(){
        //cubo[]
        // "+" = 0, "-" = 1, "*" = 2, "/" = 3, "==" = 4, "<=" = 5, "<" = 6,
        // ">=" = 7, ">" = 8, "!=" = 9, "||" = 10, "&&" ==11
        //cubo[][]
        //int= 0,float=1,char=2
        //cubo[][][]
        //int= 0,float=1,char=2

        //suma
        cubo[0][0][0] = 0;
        cubo[0][0][1] = 1;
        cubo[0][0][2] = 0;
        cubo[0][1][0] = 1;
        cubo[0][1][1] = 1;
        cubo[0][1][2] = 1;
        cubo[0][2][0] = 0;
        cubo[0][2][1] = 1;
        cubo[0][2][2] = 2;

        //resta
        cubo[1][0][0] = 0;
        cubo[1][0][1] = 1;
        cubo[1][0][2] = 0;
        cubo[1][1][0] = 1;
        cubo[1][1][1] = 1;
        cubo[1][1][2] = 1;
        cubo[1][2][0] = 0;
        cubo[1][2][1] = 1;
        cubo[1][2][2] = 2;

        //Multiplicacion
        cubo[2][0][0] = 0;
        cubo[2][0][1] = 1;
        cubo[2][0][2] = 0;
        cubo[2][1][0] = 1;
        cubo[2][1][1] = 1;
        cubo[2][1][2] = 1;
        cubo[2][2][0] = 0;
        cubo[2][2][1] = 1;
        cubo[2][2][2] = 2;

        //Diviison
        cubo[3][0][0] = 1;
        cubo[3][0][1] = 1;
        cubo[3][0][2] = 1;
        cubo[3][1][0] = 1;
        cubo[3][1][1] = 1;
        cubo[3][1][2] = 1;
        cubo[3][2][0] = 1;
        cubo[3][2][1] = 1;
        cubo[3][2][2] = 1;

    }

    public static int cuboSemantico(int operador, int ladoIzq, int ladoDer){
        operador = operador - 22;
        if(ladoIzq == 18 || ladoIzq == 6){
            ladoIzq = 0;
        }
        else if(ladoIzq == 19 || ladoIzq == 7){
            ladoIzq = 1;
        }
        else if(ladoIzq == 21 || ladoIzq == 8){
            ladoIzq = 2;
        }
        else{
            return -1;
        }

        if(ladoDer == 18 || ladoDer == 6){
            ladoDer = 0;
        }
        else if(ladoDer == 19 || ladoDer == 7){
            ladoDer = 1;
        }
        else if(ladoDer == 21 || ladoDer == 8){
            ladoDer = 2;
        }
        else{
            return -1;
        }
        return cubo[operador][ladoIzq][ladoDer];
    }


}
