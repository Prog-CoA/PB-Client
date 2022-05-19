package org.progcoa.os.Commands;

import org.progcoa.os.Commands.Frame.CommandInterface;
import org.progcoa.os.Lib.Console;
import org.progcoa.os.Main;

import java.io.File;
import java.util.Set;

public class Get extends CommandInterface {

    public Get(){
        this.CommandName = "get";
    }

    @Override
    public void Run(String CommandName, String[] args){
        Set projects = Main.releases.getMap().keySet();

        if(!projects.contains(args[0])){
            Console.Log("not found: " + args[0]);
            return;
        }

        //URLからDLする処理
    }
}
