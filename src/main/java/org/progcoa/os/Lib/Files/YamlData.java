package org.progcoa.os.Lib.Files;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.nodes.Tag;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

@SuppressWarnings("all")
public class YamlData {
    private final Yaml yaml = new Yaml();
    private final String path;
    private Map<String, Object> map;

    public YamlData(String path){
        this.path = path;
        Load();
    }

    public Object get(String key){
        return map.get(key);
    }

    public void set(String key, Object value){
        map.put(key, value);
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map){
        this.map = map;
    }

    public void Load(){
        Path input = Paths.get(path);
        try (InputStream in = Files.newInputStream(input)) {
            Yaml yaml = new Yaml();
            map = yaml.loadAs(in, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Save(){
        String yamlData = yaml.dumpAs(map, Tag.YAML, DumperOptions.FlowStyle.BLOCK);

        FileWriter filewriter = null;
        try {
            filewriter = new FileWriter(new File(path));
            filewriter.write(yamlData);
            filewriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
