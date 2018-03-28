package commands;

public class DecrementPoint implements Command {
    @Override
    public void executionCommand(int[] index, char[] arr, String line) {
        index[0]--;
    }
}
