import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileIOHelper {
    static public Reader openReader(String fileName) throws IOException {

        // See the absolute classpath used and modify the Paths.get() arguments as needed.
//        Path pathToFile = Paths.get(fileName);
//        System.out.println(pathToFile.toAbsolutePath());

        // the input file is in the core-java/files folder
       return Files.newBufferedReader(Paths.get("files", fileName));
    }

    static public Writer openWriter(String fileName) throws IOException {
        return Files.newBufferedWriter(Paths.get("files", fileName));
    }
}
