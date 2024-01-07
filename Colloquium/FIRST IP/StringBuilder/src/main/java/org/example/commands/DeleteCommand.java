package org.example.commands;

public class DeleteCommand implements Command {
    private final int start;
    private final String deletedString;

    public DeleteCommand(int _start, String _deletedString) {
        start = _start;
        deletedString = _deletedString;
    }

    @Override
    public void undo(StringBuilder stringBuilder) {
        stringBuilder.insert(start, deletedString);
    }
}
