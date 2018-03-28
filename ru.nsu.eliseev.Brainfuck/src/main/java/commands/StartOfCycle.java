package commands;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StartOfCycle implements Command {
    private static Logger log = Logger.getLogger(StartOfCycle.class.getName());
    @Override
    public void executionCommand(int[] index, char[] arr, String line){
        if(index[1] < 0)
            log.log(Level.SEVERE, "Exception: ");
        if(arr[index[0]] == 0) {
            int countLoop = 1;
            index[1]++;
            while(countLoop > 0 ) {
                if(line.charAt(index[1]) == '[') countLoop++;
                if(line.charAt(index[1]) == ']') countLoop--;
                index[1]++;
            }
        }
    }
}
