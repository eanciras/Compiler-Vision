public class Function {
    private int return_type;
    private int[] params_list;
    private int[] params_Types;
    private int funcSize;
    private int funcStart;

    Function(int return_type, int[] params_list, int[] params_Types , int funcSize, int funcStart){
        this.return_type = return_type;
        this.params_list = params_list;
        this.params_Types = params_Types;
        this.funcSize = 0;
        this.funcStart = 0;
    }
}
