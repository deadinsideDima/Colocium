package org.example.commands;

import org.example.StringBuilderUndo;

public interface Command {

    void undo(StringBuilder stringBuilder);
}
