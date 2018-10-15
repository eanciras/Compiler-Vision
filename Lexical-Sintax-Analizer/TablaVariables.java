import java.util.Hashtable;
import java.lang.String;
import java.util.ArrayList;

class TablaVariables {
	public int segunda = 0;

	public Hashtable tabla = new Hashtable();

	//Inserta una variable en la tabla actual de variables
	public boolean insertarVar(Token identificador, Variable varInfo) {
		if (tabla.containsKey(identificador.image)){
		    return false;
        }

        tabla.put(identificador.image, varInfo);
		return true;
	}

    //Actualiza una variable existente
    public boolean actualizarVar(Token identificador, Variable varInfo){
        if (!tabla.containsKey(identificador.image)){
            return false;
        }

        tabla.remove(identificador);
        tabla.put(identificador, varInfo);
        return true;
    }

    //Regresa el valor de la variable dado el nombre de la misma
    public Variable obtenerVar(Token identificador){
        if (!tabla.containsKey(identificador.image)) {
            return null;
        }
        return (Variable) tabla.get(identificador.image);
    }

	//Imprime en consola toda la table de variables
	public void verTabla() {
		System.out.print(tabla.toString());
	}
}