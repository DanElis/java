package commands;

public class IncrementPoint implements Command {
    @Override
    public void executionCommand(int[] index, char[] arr, String line){
        index[0]++;

    }
}
