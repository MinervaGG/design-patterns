package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.CommandCaretaker;
import com.kreitek.editor.Memento;

import java.util.ArrayList;

public class DeleteCommand implements Command {
    private final int lineNumber;

    public DeleteCommand(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        CommandCaretaker.getInstance().push(new Memento(documentLines));
        if (documentLines.size() > lineNumber) {
            documentLines.remove(lineNumber);
        }
    }
}
