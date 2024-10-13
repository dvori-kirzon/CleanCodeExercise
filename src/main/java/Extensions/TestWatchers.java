package Extensions;

import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.Optional;



/**
 * The TestWatchers class implements the {@link org.junit.jupiter.api.extension.TestWatcher} interface,
 * which provides callbacks for tracking the result of individual tests in a test suite.
 *
 * <p>Methods in this class are called by the JUnit 5 framework depending on the outcome of a test:
 * successful, failed, aborted, or disabled.</p>
 *
 * <p>This extension can be used to log test results or perform additional actions based on the result of each test.</p>
 *
 * <p>Implemented callbacks:</p>
 * <ul>
 *     <li>{@link #testSuccessful(ExtensionContext)} - Called when a test successfully completes.</li>
 *     <li>{@link #testFailed(ExtensionContext, Throwable)} - Called when a test fails with an exception.</li>
 *     <li>{@link #testAborted(ExtensionContext, Throwable)} - Called when a test is aborted, typically when a precondition fails.</li>
 *     <li>{@link #testDisabled(ExtensionContext, Optional)} - Called when a test is disabled, with an optional reason.</li>
 * </ul>
 */
public class TestWatchers implements org.junit.jupiter.api.extension.TestWatcher {

    /**
     * Called when a test has successfully completed.
     *
     * @param context the extension context for the test that was executed
     */
    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("The test Successful");
    }

    /**
     * Called when a test fails due to an exception.
     *
     * @param context the extension context for the test that was executed
     * @param cause the exception that caused the test to fail
     */
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("The test Failed");
    }

    /**
     * Called when a test is aborted, meaning it did not complete execution.
     * This can happen if a test's assumptions are not met.
     *
     * @param context the extension context for the test that was aborted
     * @param cause the reason the test was aborted (if available)
     */
    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        System.out.println("The test Aborted");
    }

    /**
     * Called when a test is disabled, either programmatically or through configuration.
     *
     * @param context the extension context for the test that was disabled
     * @param reason the reason for disabling the test (if provided)
     */
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        System.out.println("Test " + context.getDisplayName() + " was disabled. Reason: " + reason.orElse("No reason provided"));
    }
}

