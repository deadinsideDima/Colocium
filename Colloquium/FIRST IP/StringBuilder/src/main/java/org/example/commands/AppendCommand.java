package org.example.commands;

public class AppendCommand implements Command {
    private final String appendedString;

    public AppendCommand(String appendedString) {
        this.appendedString = appendedString;
    }

    @Override
    public void undo(StringBuilder stringBuilder) {
        stringBuilder.delete(stringBuilder.length() - appendedString.length(), stringBuilder.length());
    }
}
