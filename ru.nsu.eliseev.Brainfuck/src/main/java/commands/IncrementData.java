package commands;

public class IncrementData implements Command {
    @Override
    public void executionCommand(int[] index, char[] arr, String line){
        arr[index[0]]++;
    }
}
