package org.progcoa.os.Commands;

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
        if(!commands.contains(cmd)) {
            Console.Log("command not found :CommandName " + cmd);
            return;
        }

        List<String> list = Arrays.asList(cmd.split(" "));
        list.remove(0);

        interfaceMap.get(cmd).Run(cmd, list.toArray(new String[0]));
    }

}
