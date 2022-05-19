package org.progcoa.os.Commands;

import org.progcoa.os.Commands.Frame.CommandInterface;
import org.progcoa.os.Lib.Console;

public class test extends CommandInterface {

    public test(){
        this.CommandName = "test";
    }

    @Override
    public void Run(String CommandName, String[] args) {
        Console.Log("TEST TEST");

        if(args[0].equals("ra")){
            Console.Log("AAAAAA");
        }
    }
}
