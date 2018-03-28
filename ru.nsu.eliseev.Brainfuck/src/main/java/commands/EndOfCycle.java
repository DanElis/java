package commands;

public class EndOfCycle implements Command {
    @Override
    public void executionCommand(int[] index, char[] arr, String line){

        if(arr[index[0]] != 0) {
            int countLoop = 1;
            index[1]--;
            while(countLoop > 0) {
                if(line.charAt(index[1]) == ']') countLoop++;
                if(line.charAt(index[1]) == '[') countLoop--;
                index[1]--;
            }
        }
    }
}
