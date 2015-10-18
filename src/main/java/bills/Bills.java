package bills;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Predicate;
import java.util.regex.Pattern;


public class Bills {

    public static final String BILLS_PATH = "C:\\Users\\sdrouard\\Dropbox\\EURL Linux et Vertex\\Factures";
    public static final String JUSTIFICATION_PATH = "C:\\Users\\sdrouard\\Dropbox\\EURL Linux et Vertex\\Notes de frais\\Justificatif a imprimer";

    private static Pattern universal = Pattern.compile("[a-zA-Z_0-9]*");
    private static Pattern day_month_year_name = Pattern.compile("([0-9]{2}_){3}[a-zA-Z_\\.]*");

    private static Predicate<String> BY_SEPTEMBER = fileName -> fileName.contains("_15_");
    private static Predicate<String> BY_PATTERN = fileName -> universal.matcher(fileName).matches();

    public void filterFilesByPattern() throws IOException {
        Path path = Paths.get(JUSTIFICATION_PATH);
        Files.list(path)
                .map(x -> x.getFileName().toString())
                .filter(BY_PATTERN)
                .forEach(System.out::println);
    }

    public void filterFilesBySeptember() throws IOException {
        Path path = Paths.get(JUSTIFICATION_PATH);
        Files.list(path)
                .map(x -> x.getFileName().toString())
                .map(x -> )
                .filter(BY_SEPTEMBER)
                .forEach(System.out::println);
    }

    public boolean matcher(String test){
        Splitter.on(".");
        Pattern universal = Pattern.compile("[a-zA-Z_0-9]*");
        return universal.matcher(test).matches();


    }

}


