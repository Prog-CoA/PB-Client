package org.progcoa.os.Commands.Frame;

import org.progcoa.os.Lib.Console;

import java.util.*;

public class CommandManager {

    public static List<String> commands = new ArrayList<>();
    public static Map<String, CommandInterface> interfaceMap = new HashMap<>();

    public static void setCommand(CommandInterface commandInterface){
        commands.add(commandInterface.CommandName);
        interfaceMap.put(commandInterface.CommandName, commandInterface);
    }

    public static void onRun(String cmd){
        if(cmd.contains(" ")){
            String name = cmd.split(" ")[0];

            if(!commands.contains(name)) {
                Console.Log("command not found :CommandName " + name);
                return;
            }

            String args = cmd.replace(name + " ", "");

            if(args.contains(" ")){
                interfaceMap.get(name).Run(name, args.split(" "));
                return;
            }

            interfaceMap.get(name).Run(name, new String[]{args});
            return;
        }

        if(!commands.contains(cmd)){
            Console.Log("command not found :CommandName " + cmd);
            return;
        }

        interfaceMap.get(cmd).Run(cmd, new String[]{"null", "null", "null", "null", "null"});
    }

}
