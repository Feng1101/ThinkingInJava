package feng.S_Annotations.A_基本语法;

import feng.atunit.Test;

import java.sql.SQLOutput;

public class Testable {
    public void execute(){
        System.out.println("Executing..");
    }
    @Test
    void testExecute(){ execute();}
}
