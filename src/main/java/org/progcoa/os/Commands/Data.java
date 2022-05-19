package org.progcoa.os.Commands;

import org.progcoa.os.Commands.Frame.CommandInterface;
import org.progcoa.os.Lib.Console;
import org.progcoa.os.Main;

public class Data extends CommandInterface {

    public Data(){
        this.CommandName = "data";
    }

    @Override
    public void Run(String CommandName, String[] args){
        switch (args[0]){
            case  "save": {
                Main.data.Save();
                Console.Log("data saved: options/data.yml");
                break;
            }

            case "load":{
                Main.data.Load();
                Console.Log("data reloaded: options/data.yml");
                break;
            }

            case "content":{
                Console.Log(Main.data.getMap().toString());
                break;
            }

            default:{
                Console.Log("this args in not found: " + args[0]);
                break;
            }
        }
    }
}
