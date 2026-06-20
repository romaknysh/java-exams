package exam7;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Registre {
    private LinkedHashMap<Character, Integer> registers;
    public Registre(){
        this.registers = new LinkedHashMap<>();
        this.registers.put('A', 0);
        this.registers.put('B', 0);
        this.registers.put('C', 0);
        this.registers.put('D', 0);
        this.registers.put('E', 0);
    }

    public int citaj(char register){
        return this.registers.get(register);
    }

    public void nastav(char register, int hodnota){
        this.registers.put(register, hodnota);
    }

    public void vypis() {
        for (Map.Entry<Character, Integer> entry : this.registers.entrySet()){
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
