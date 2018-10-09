import java.io.PrintStream;
import java.util.Hashtable;
import java.lang.String;
import java.util.ArrayList;

class ValidadorSemantico
{
	  public static int segunda = 0;

	  private static Hashtable tabla = new Hashtable();
	  
	  private static ArrayList<Integer> arrInt = new ArrayList();
	  private static ArrayList<Integer> arrFloat = new ArrayList();
	  private static ArrayList<Integer> arrChar = new ArrayList();
	  
	public static void InsertarSimbolo(Token identificador, int tipo)
	{
		tabla.put(identificador.image, tipo);
	 }
	  
	public static void SetTables()
	{
		arrInt.add(6);
		arrInt.add(18);
		
		arrFloat.add(7);
		arrFloat.add(19);
		arrFloat.add(6);
		arrFloat.add(18);
		
		arrChar.add(8);
		arrChar.add(21);
		
	}
 
	public static String checkAsing(Token TokenIzq, Token TokenAsig)
	{
		int tipoVarID1;
		int tipoVarID2;		
		if(TokenIzq.kind != 18 && TokenIzq.kind != 19)		
		{
			try 
			{
				tipoVarID1 = (Integer)tabla.get(TokenIzq.image);	
			}
			catch(Exception e)
			{
				return "Error: El identificador " + TokenIzq.image + " No ha sido declarado \r\nLinea: " + TokenIzq.beginLine;
			}
		}
		else 		
			tipoVarID1 = 0;
		if(TokenAsig.kind == 20)	
		{
			try
			{
				tipoVarID2 = (Integer)tabla.get(TokenAsig.image);
			}
			catch(Exception e)
			{
				return "Error: El identificador " + TokenAsig.image + " No ha sido declarado \r\nLinea: " + TokenIzq.beginLine;
			}
		}
		else if(TokenAsig.kind == 18 || TokenAsig.kind == 19 || TokenAsig.kind == 51 || TokenAsig.kind == 21)
			tipoVarID2 = TokenAsig.kind;
		else 
			tipoVarID2 = 0; 

			
	  
		
		if(tipoVarID1 == 6) //Int
		{
			if(arrInt.contains(tipoVarID2))
				return " ";
			else 
				return "Error: No se puede convertir " + TokenAsig.image + " a Entero \r\nLinea: " + TokenIzq.beginLine;
		}
		else if(tipoVarID1 == 7) //double
		{
			if(arrFloat.contains(tipoVarID2))
				return " ";
			else
				return "Error: No se puede convertir " + TokenAsig.image + " a Decimal \r\nLinea: " + TokenIzq.beginLine;
		}
		else if(tipoVarID1 == 8) //char
		{
			segunda++;
			if(segunda < 2)
			{
				if(arrChar.contains(tipoVarID2))
					return " ";				
				else
					return "Error: No se puede convertir " + TokenAsig.image + " a Caracter \r\nLinea: " + TokenIzq.beginLine;	
			}
			else //Si se esta asignando mas de un caracter manda el error 			
				return "Error: No se puede asignar mas de un valor a un caracter \r\nLinea: " + TokenIzq.beginLine;
			
		}
		else
		{
			return "El Identificador " + TokenIzq.image + " no ha sido declarado" + " Linea: " + TokenIzq.beginLine;
		}
	}	  
	
	
	public static String checkVariable(Token checkTok)
	{
		try
		{
			int tipoVarID1 = (Integer)tabla.get(checkTok.image);
			return " ";
		}
		catch(Exception e)
		{
			return "Error: El identificador " + checkTok.image + " No ha sido declarado \r\nLinea: " + checkTok.beginLine;
		}
	}

 }
  
  
  
  
  
  
  