package fr.vadc.java.sandbox;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import java.io.IOException;
import java.text.MessageFormat;

/**
 * Terminal !
 *
 */
public class App 
{
    public static void main( String[] args )    {

        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            SomeTerminalStaticText(terminal);
        } catch (java.io.IOException e) {
            System.out.println("Can not initialize Default Terminal");
        }
    }

    private static void SomeTerminalStaticText(Terminal terminal) throws IOException {
        terminal.setCursorPosition(10, 5);
        terminal.setForegroundColor(TextColor.ANSI.RED);
        terminal.setBackgroundColor(TextColor.ANSI.BLUE);
        terminal.putCharacter('H');
        terminal.putCharacter('e');
        terminal.putCharacter('l');
        terminal.putCharacter('l');
        terminal.putCharacter('o');
        terminal.putCharacter('!');
        terminal.setCursorPosition(0, 0);
        TerminalSize screenSize = terminal.getTerminalSize();
        terminal.putString(MessageFormat.format("Screen size : rows = {0} columns = {1}", screenSize.getRows(), screenSize.getColumns()));
    }
}
