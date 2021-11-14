package fr.vadc.java.sandbox;
import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

/**
 * Hello world!
 *
 */
public class SandboxJansiApp
{
    public static void main( String[] args )
    {
        AnsiConsole.systemInstall();

        System.out.println( ansi().eraseScreen().fg(RED).a("Hello").fg(GREEN).a(" World").reset());
        System.out.println( "Hello World!" );
        AnsiConsole.systemUninstall();
    }
}
