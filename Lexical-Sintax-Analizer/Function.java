import java.util.ArrayList;

//clase que refleja los aspectos que tienen las funciones en el compilador
public class Function {
    //valor que retorna la funcion 0= entero, 1=flotante, 2=char y el -1 correponde a void
    private int return_type = -1;
    //valor que representa el id(nombre) de la funcion
    private String id = " ";
    //arreglo de enteros que representa las direcciones de los parametros
    private ArrayList<Integer> params_list = new ArrayList<>();
    //arreglo de enteros que representa los tipos de los parametros
    private ArrayList<Integer> params_Types = new ArrayList<>();
    private int funcSize = 0;
    //representa el nummero del cuadruplo donde incia la funcion
    private int funcStart = 0;

    public Function(){

    }
    //metodos de acceso y retorno de las variables ya mencionadas
    public int getReturn_type() {
        return return_type;
    }

    public String toString(){
        return id+" in pos "+funcStart;
    }

    public void setReturn_type(int return_type) {
        this.return_type = return_type;
    }

    public ArrayList<Integer> getParams_list() {
        return params_list;
    }

    public void addParams_list(Integer params_list) {
        this.params_list.add(params_list);
    }

    public ArrayList<Integer> getParams_Types() {
        return params_Types;
    }

    public void addParams_Types(int params_Types) {
        this.params_Types.add(params_Types);
    }

    public int getFuncSize() {
        return funcSize;
    }

    public void setFuncSize(int funcSize) {
        this.funcSize = funcSize;
    }

    public int getFuncStart() {
        return funcStart;
    }

    public void setFuncStart(int funcStart) {
        this.funcStart = funcStart;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
