package org.example;

import org.example.commands.AppendCommand;
import org.example.commands.Command;
import org.example.commands.DeleteCommand;

public class StringBuilderUndo {

    private CommandHistory commandHistory;

    private StringBuilder stringBuilder;

    public StringBuilderUndo(StringBuilder stringBuilder) {
        commandHistory = new CommandHistory();
        this.stringBuilder = stringBuilder;
    }

    public StringBuilderUndo append(String str) {
        stringBuilder.append(str);
        commandHistory.push(new AppendCommand(str));

        return this;
    }

    public StringBuilderUndo delete(int start, int end) {
        String deletedString = stringBuilder.substring(start, end);
        stringBuilder.delete(start, end);
        commandHistory.push(new DeleteCommand(start, deletedString));

        return this;
    }

    public StringBuilderUndo undo() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
            lastCommand.undo(stringBuilder);
        }

        return this;
    }

    public String build() {
        return stringBuilder.toString();
    }

    public void popCommandFromHistory() {
        if (!commandHistory.isEmpty())
            commandHistory.pop();
    }
}
