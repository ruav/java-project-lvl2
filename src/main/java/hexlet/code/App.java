package hexlet.code;

import picocli.CommandLine;

@CommandLine.Command(name = "gendiff", mixinStandardHelpOptions = true, description = "Compares two configuration files and shows a difference.")
public class App implements Runnable{
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
//        System.out.println("Hello World!");
        System.exit(exitCode);
    }

    @Override
    public void run() {

    }
}