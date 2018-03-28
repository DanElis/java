package commands;

public class DecrementData implements Command{
    @Override
    public void executionCommand(int[] index, char[] arr, String line){
        arr[index[0]]--;
    }
}
