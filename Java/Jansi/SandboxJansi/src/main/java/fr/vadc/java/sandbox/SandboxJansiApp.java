package fr.vadc.java.sandbox;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.text.MessageFormat;
import org.fusesource.jansi.AnsiConsole;

import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;
import org.jline.terminal.*;

/**
 *Test Jansi and jLine3!
 *
 */
public class SandboxJansiApp
{
    public static void main( String[] args )
    {
        AnsiConsole.systemInstall();
        Scanner scanner = new Scanner(System.in);

        System.out.println( ansi().eraseScreen().fg(RED).a("Hello").fg(GREEN).a(" World").reset());
        System.out.println( "Hello World!" );
        String unicodeMessage = "\u4e16\u754c\u4f60\u597d\uff01";
        System.out.println(unicodeMessage);
        int height = 0;
        
        int width = 0 ;

        try {
            Terminal terminal = TerminalBuilder.builder().system(true).signalHandler(new TerminalSignalHandler()).build();
            height = terminal.getHeight();
            width = terminal.getWidth();
            System.out.print(ansi().cursor(height/2, width/2).a( MessageFormat.format("Columns: {0} | Rows: {1}", width, height)));

            String text = scanner.nextLine();
            height = terminal.getHeight();
            width = terminal.getWidth();
            System.out.print(ansi().cursor(height/2, width/2).a( MessageFormat.format("Columns: {0} | Rows: {1}", width, height)));

        } catch (java.io.IOException ex) {
            System.out.println( "Can't init terminal" );
        }
        System.out.println(Charset.defaultCharset().name());
        byte[] b = new byte[]{0x25,0x50,0x00};
        StringBuilder sb = new StringBuilder();
        sb.append("\u2550");
        System.out.print("\u2550");
        String value = sb.toString();
        for (int i=0; i<width; i++) {

            System.out.print( ansi().cursor(0, i).fg(RED).a(value).reset());
            System.out.print( ansi().cursor(height-1, i).fg(RED).a(value).reset());
        }
        for (int i=1; i<height; i++) {
            System.out.print( ansi().cursor(i, 0).fg(BLUE).a("*").reset());
            System.out.print( ansi().cursor(i, width-1).fg(BLUE).a("*").reset());
        }
        String text = scanner.nextLine();
        try {
            Terminal terminal = TerminalBuilder.terminal();
            height = terminal.getHeight();
            width = terminal.getWidth();

            System.out.print(ansi().cursor(height/2, width/2).a( MessageFormat.format("Columns: {0} | Rows: {1}", width, height)));
        } catch (java.io.IOException ex) {
            System.out.println( "Can't init terminal" );
        }
        scanner.nextLine();
        AnsiConsole.systemUninstall();
    }
}
