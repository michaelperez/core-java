import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * This class demonstrates using the try-with-resources statement to ensure each resource is closed
 * at the end of the statement. The resources must implement the AutoClosable or Closable interfaces.
 *
 * When working with try-with-resources, you should look at both the exception thrown and any suppressed exceptions.
 */
public class TryWithResourcesRunner {

    public static void main(String[] args) {
        doTryWithSingleResource();
        doTryWithMultiResource();
    }

    /**
     * This method demonstrates using the try-with-resources statement on a single resource
     * by reading a text file using the Reader class and outputting the contents to the screen.
     */
    public static void doTryWithSingleResource() {
        char[] buff = new char[8];
        int length;
        try (Reader reader = FileIOHelper.openReader("file1.txt")){

            while((length = reader.read(buff)) >= 0) {
                System.out.println("\nlength: " + length);
                for(int i=0; i < length; i++)
                    System.out.print(buff[i]);
            }

        } catch (IOException ioe) {
            System.out.println(ioe.getClass().getSimpleName() + " - " + ioe.getMessage());

            for(Throwable t : ioe.getSuppressed())
                System.out.println("Suppressed: " + t.getMessage());
        }

    }

    /**
     * This method demonstrates using the try-with-resources statement on multiple resources
     * by reading a text file using the Reader class and outputting the contents into a second
     * text file.
     * Use a semi-colon to separate resources in the try statement.
     */
    public static void doTryWithMultiResource() {
        char[] buff = new char[8];
        int length;
        try (Reader reader = FileIOHelper.openReader("file1.txt");
             Writer writer = FileIOHelper.openWriter("file2.txt")){

            // length == the actual number of chars read into the buff array
            while((length = reader.read(buff)) >= 0) {
                System.out.println("\nlength: " + length);

                // writes only the actual chars in the buff array
                writer.write(buff, 0, length);
            }

        } catch (IOException ioe) {
            System.out.println(ioe.getClass().getSimpleName() + " - " + ioe.getMessage());

            for(Throwable t : ioe.getSuppressed())
                System.out.println("Suppressed: " + t.getMessage());
        }
    }
}
