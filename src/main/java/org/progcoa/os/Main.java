package org.progcoa.os;

import org.progcoa.os.Commands.Frame.CommandManager;
import org.progcoa.os.Commands.test;
import org.progcoa.os.Lib.Console;

public class Main {

    public static void main(String[] args) {
        Console.Log("Prog-OS");

        //import Commands
        CommandManager.setCommand(new test());

        String input = Console.ReadLine();

        while (!input.equals("/stop")) {
            CommandManager.onRun(input);

            input = Console.ReadLine();
        }

        Console.Log("saving data");
        Console.Log("Shutdown...");
    }
}
