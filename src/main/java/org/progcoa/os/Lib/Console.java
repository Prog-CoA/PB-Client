package org.progcoa.os.Lib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Console {
    public static String ReadLine(){
        return new Scanner(System.in).nextLine();
    }

    public static void WriteLine(Object message){
        System.out.println(message);
    }

    public static void Log(Object message){
        SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
        System.out.println("[" + sdf1.format(new Date()) + ": Prog-OS]" + message);
    }
}
