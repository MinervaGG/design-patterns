package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.CommandCaretaker;
import com.kreitek.editor.Memento;

import java.util.ArrayList;

public class AppendCommand implements Command {
    private final String text;

    public AppendCommand(String text) {
        this.text = text;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        CommandCaretaker.getInstance().push(new Memento(documentLines));
        documentLines.add(text);
    }
}
