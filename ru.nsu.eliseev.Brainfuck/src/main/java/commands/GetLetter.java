package commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetLetter implements Command {

    private static Logger log = Logger.getLogger(GetLetter.class.getName());
    @Override
    public void executionCommand(int[] index, char[] arr, String line)
    {


        try( BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            arr[index[0]] = (char) br.read();
        }
        catch (IOException e){
            log.log(Level.SEVERE, "Exception: ", e);
        }
    }
}

