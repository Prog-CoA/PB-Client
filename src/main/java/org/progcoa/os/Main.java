package org.progcoa.os;

import org.progcoa.os.Commands.Frame.CommandInterface;
import org.progcoa.os.Commands.Frame.CommandManager;
import org.progcoa.os.Commands.*;
import org.progcoa.os.Lib.Console;
import org.progcoa.os.Lib.Files.Resource;
import org.progcoa.os.Lib.Files.YamlData;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    public static YamlData data;
    public static YamlData releases;

    public static void main(String[] args) throws IOException, URISyntaxException {
        Console.Log("Prog-OS");

        Resource.loadFile("data.yml");
        Resource.loadFile("releases.yml");

        data = new YamlData("options/data.yml");
        releases = new YamlData("options/releases.yml");

        if((boolean) data.get("ShowData")){
            Console.Log("VERSION: " + data.get("VER"));
            Console.Log("ROOT-USER: " + data.get("ROOT-USER"));
        }

        //import Commands
        addCommand(new test());
        addCommand(new Help());
        addCommand(new Data());
        addCommand(new Get());

        Console.Log("RUN SUCCESS");

        String input = Console.ReadLine();

        while (!input.equals("/stop")) {
            if(!"".equals(input)) CommandManager.onRun(input);

            input = Console.ReadLine();
        }

        Console.Log("saving data");
        Console.Log("Shutdown...");
    }

    private static void addCommand(CommandInterface cmd){
        CommandManager.setCommand(cmd);
    }
}
