package Extensions;
import org.junit.jupiter.api.extension.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The LoggingExtension class is a custom JUnit extension that logs
 * the execution of tests. It implements the JUnit 5 extension callbacks
 * for managing log file creation, writing log entries before and after
 * each test, and cleaning up resources after all tests have been executed.
 * <p>
 * The log is written to a file named "test-log.txt", and entries
 * are appended to the file if it already exists.
 * </p>
 */
public class LoggingExtension implements BeforeAllCallback, AfterAllCallback, BeforeEachCallback, AfterEachCallback {

    // The name of the log file
    private static final String LOG_FILE_NAME = "test-log.txt";
    private BufferedWriter writer;

    /**
     * Called once before all tests are executed.
     * Initializes the log file and writes a start message.
     *
     * @param context the current extension context, never {@code null}
     * @throws Exception if any setup error occurs
     */
    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        createLogFile();
        writeLog("Log started before all tests");
        System.out.println("Before all tests: log initialized.");
    }

    /**
     * Called before each test is executed.
     * Writes an entry to the log indicating the test being executed.
     *
     * @param context the current extension context, never {@code null}
     * @throws Exception if any setup error occurs
     */
    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        writeLog("Before test: " + context.getDisplayName());
        System.out.println("Before each test: " + context.getDisplayName());
    }

    /**
     * Called after each individual test is executed.
     * Writes an entry to the log indicating the completion of the test.
     *
     * @param context the current extension context, never {@code null}
     * @throws Exception if any cleanup error occurs
     */
    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        writeLog("After test: " + context.getDisplayName());
        System.out.println("After each test: " + context.getDisplayName());
    }

    /**
     * Called once after all tests have been executed.
     * Writes a completion message to the log and closes the log file.
     *
     * @param context the current extension context, never {@code null}
     * @throws Exception if any cleanup error occurs
     */
    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        writeLog("Log ended after all tests");
        System.out.println("After all tests: log cleaned.");
        closeLogFile(); // Close the log file at the end of the tests
    }

    /**
     * Creates the log file and prepares a BufferedWriter to write to it.
     * If the log file already exists, it appends to the existing file.
     */
    private void createLogFile() {
        try {
            // Create the log file writer
            File logFile = new File(LOG_FILE_NAME);
            // true allows appending to existing content
            writer = new BufferedWriter(new FileWriter(logFile, true));
        } catch (IOException e) {
            System.err.println("Error creating log file: " + e.getMessage());
        }
    }

    /**
     * Writes a message to the log file.
     *
     * @param message the message to be logged
     */
    private void writeLog(String message) {
        try {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }

    /**
     * Closes the BufferedWriter to release system resources.
     * If the writer is null, no action is taken.
     */
    private void closeLogFile() {
        try {
            if (writer != null) {
                writer.close(); // Close the log writer
            }
        } catch (IOException e) {
            System.err.println("Error closing log file: " + e.getMessage());
        }
    }

}
