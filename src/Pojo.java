import java.util.*;
// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Pojo{
    private String value;
    private Integer length;

    public String getValue(){
        return value;
    }

    public void setValue(String value){
        this.value = value;
    }

    public void setLength(Integer length){
        this.length = length;
    }

    //getter, setter for length

    public static void main(String[] args){
        Map<Pojo, Integer> map = new HashMap();
        Pojo key = new Pojo();
        key.setValue("abc");
        map.put(key, 1);
        key.setLength(3);
        Integer result = map.get(key);
        System.out.println(result);

    }
}
