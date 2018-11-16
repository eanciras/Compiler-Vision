import java.util.ArrayList;

public class Function {
    private int return_type = -1;
    private String id = " ";
    private ArrayList<String> params_list = new ArrayList<>();
    private ArrayList<Integer> params_Types = new ArrayList<>();
    private int funcSize = 0;
    private int funcStart = 0;

    public Function(){

    }

    public int getReturn_type() {
        return return_type;
    }

    public String toString(){
        return id+" in pos "+funcStart;
    }

    public void setReturn_type(int return_type) {
        this.return_type = return_type;
    }

    public ArrayList<String> getParams_list() {
        return params_list;
    }

    public void addParams_list(String params_list) {
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
