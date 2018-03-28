import commands.Command;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FactoryCommands {
    private static FactoryCommands f = null;
    private static Properties props = null;
    private static Logger log = Logger.getLogger(FactoryCommands.class.getName());
    private HashMap<String,Class> map = new HashMap<String, Class>();

    public static FactoryCommands instance(String fileConfig){
        try(InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(fileConfig)){
            props = new Properties();
            props.load(is);
        }
        catch (IOException e){
            log.log(Level.SEVERE, "Exception: ", e);
        }
        catch (NullPointerException e){
            log.log(Level.SEVERE, "Exception: ", e);
        }
        if(null == f){
            f = new FactoryCommands();
        }
        return f;
    }


    public Command get(String id) {
        Class c;
        Object o = null;
        String nameClass = props.getProperty(id);
        try {
            if (map.containsKey(id)) {
                o = map.get(id).newInstance();
                return (Command)o;
            }else {
                c = Class.forName(nameClass);
                o = c.newInstance();
                map.put(id, c);
            }
        }
        catch (ClassNotFoundException e){
            log.log(Level.SEVERE, "Exception: ", e);
        }
        catch (InstantiationException e){
            log.log(Level.SEVERE, "Exception: ", e);
        }
        catch (IllegalAccessException e){
            log.log(Level.SEVERE, "Exception: ", e);
        }
        return (Command) o;
    }
}
