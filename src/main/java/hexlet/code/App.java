package hexlet.code;

import picocli.CommandLine;

import java.io.File;

@CommandLine.Command(name = "gendiff", mixinStandardHelpOptions = true, description = "Compares two configuration files and shows a difference.")
public class App implements Runnable{

    @CommandLine.Parameters(index = "0", description = "path to first file")
    private File filepath1;

    @CommandLine.Parameters(index = "0", description = "path to second file")
    private File filepath2;

    @CommandLine.Option(names = { "-f", "--format=format"}, description = "output format", defaultValue = "stylish")
    private String format = "stylish";

    @Override
    public void run() {

    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
//        System.out.println("Hello World!");
        System.exit(exitCode);
    }
}