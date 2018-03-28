
import commands.Command;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Interpreter {

    private static Logger log = Logger.getLogger(FactoryCommands.class.getName());

    public void run(){
        char[] mem = new char[30000];
        int[] indexs = new int[2];          //!!!
        String fileBrainfuck = null;
        //Scanner sc = new Scanner(System.in);
       // if(sc.hasNextLine())
          //  fileBrainfuck = sc.nextLine();
       // else {
          //  log.log(Level.SEVERE, "Exception: ");
            //return;
        //}


        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream("build/resources/main/"+"t.txt"), StandardCharsets.UTF_8))){
            String line = reader.readLine();
            FactoryCommands f = FactoryCommands.instance("/ru.nsu.eliseev.Brainfuck/build/resources/main/MyConfig.cfg");
            for(;indexs[1] < line.length(); indexs[1]++){

                String idCommand = String.valueOf(line.charAt(indexs[1]));
                Command cmd = f.get(idCommand);
                cmd.executionCommand(indexs,mem,line);
            }
        } catch (IOException e) {
            log.log(Level.SEVERE, "Exception: ", e);
        }
    }
}
