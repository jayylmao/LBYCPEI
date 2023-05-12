import acm.program.*;

public class ACMHello extends ConsoleProgram {
    public void run() {
        println("Hello, world!");
    }

    public static void main (String[] args) {
        (new ACMHello()).start(args);
    }
}
