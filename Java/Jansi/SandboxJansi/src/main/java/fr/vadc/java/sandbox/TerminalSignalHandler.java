package fr.vadc.java.sandbox;
import org.jline.terminal.*;
import org.jline.terminal.Terminal;

public class TerminalSignalHandler implements Terminal.SignalHandler {

    @Override
    public void handle(Terminal.Signal signal) {
        if (signal == Terminal.Signal.WINCH) {
            System.out.print("Windows Size Changed");

        }
    }
}
