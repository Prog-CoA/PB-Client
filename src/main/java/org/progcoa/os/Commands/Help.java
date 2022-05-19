package org.progcoa.os.Commands;

import org.progcoa.os.Commands.Frame.CommandInterface;
import org.progcoa.os.Lib.Console;

public class Help extends CommandInterface {

    public Help(){
        this.CommandName = "help";
    }

    @Override
    public void Run(String CommandName, String[] args){
        Console.Log("This command is not implemented...");
    }
}
