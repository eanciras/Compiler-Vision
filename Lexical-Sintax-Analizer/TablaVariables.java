import java.util.Hashtable;

class TablaVariables {

	public Hashtable tabla = new Hashtable();

	//Inserta una variable en la tabla actual de variables
	public boolean insertarVar(String identificador, Objeto varInfo) {
	    if (tabla.containsKey(identificador)){
            return false;
        }

        tabla.put(identificador, varInfo);
		return true;
	}

    //Actualiza una variable existente dado el nombre de la variable y el objeto Variable
    public boolean actualizarVar(String identificador, Objeto varInfo){

	    //Si la variable no ha sido declarada entonces regresa falso para manejo de errores
	    if (!tabla.containsKey(identificador)){
            return false;
        }

        tabla.remove(identificador);
        tabla.put(identificador, varInfo);
        return true;
    }

    //Regresa el valor de la variable dado el nombre de la misma
    public Objeto obtenerVar(String identificador){
        if (!tabla.containsKey(identificador)) {
            return null;
        }
        return (Objeto) tabla.get(identificador);
    }

    public boolean definirFuncion(String identificador, Objeto varInfo){
        if(tabla.containsKey(identificador)){
            return false;
        }

        tabla.put(identificador, varInfo);
        return true;
    }

	//Imprime en consola toda la table de variables
	public void verTabla() {
		System.out.print(tabla.toString()+"\n");
	}
}