package org.progcoa.os.Commands;

import org.apache.commons.io.FileUtils;
import org.progcoa.os.Commands.Frame.CommandInterface;
import org.progcoa.os.Lib.Console;
import org.progcoa.os.Main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
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

        try {
            download((String) Main.releases.get(args[0]), args[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void download(String FileUrl, String path) throws IOException {
        Console.Log("getting file: " + FileUrl);
        Console.Log("download file");
        Console.Log("Please wait...");

        URL url = new URL(FileUrl);
        File destFile = new File("downloads/" + path + ".zip");
        FileUtils.copyURLToFile(url, destFile);

        Console.Log("DOWNLOAD SUCCESS");
    }
}
