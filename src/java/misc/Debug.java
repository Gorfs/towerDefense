package misc;

public class Debug {
    public static boolean isDebugging = true;

    /** 
     * @return boolean
     */
    public static boolean isDebugging() {
        return isDebugging;
    }
    public static void toggleDebugging(){
        isDebugging = !isDebugging;
    }

    /** 
     * @param str string to print
     */
    public static void out(String str){
        if(isDebugging) System.out.println("DEBUG>>> " + str);
    }
}
