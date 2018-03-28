package commands;

public class PrintLetter implements Command {
    @Override
    public void executionCommand(int[] index, char[] arr, String line){
        System.out.print(arr[index[0]]);
    }
}
