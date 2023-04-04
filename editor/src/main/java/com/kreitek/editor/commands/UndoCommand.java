package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.CommandCaretaker;
import com.kreitek.editor.Memento;

import java.util.ArrayList;

public class UndoCommand implements Command {

    private CommandCaretaker caretaker;

    public UndoCommand() {
        caretaker = CommandCaretaker.getInstance();
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        Memento memento = caretaker.pop();
        if (memento != null) {
            documentLines.clear();
            documentLines.addAll(memento.getState());
        }
    }
}
