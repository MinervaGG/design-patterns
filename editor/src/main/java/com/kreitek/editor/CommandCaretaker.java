package com.kreitek.editor;

import java.util.ArrayList;
import java.util.List;

public class CommandCaretaker {
    List<Memento> mementos = new ArrayList<>();
    private static volatile CommandCaretaker instance = null;

    private CommandCaretaker(){
        if (instance != null){
            throw new RuntimeException("Usage getInstance() method to create");
        }
    }

    public static CommandCaretaker getInstance(){
        if (instance == null){
            synchronized (CommandCaretaker.class){
                if (instance == null){
                    instance = new CommandCaretaker();
                }
            }
        }
        return instance;
    }

    public void push(Memento memento){
        mementos.add(memento);
    }

    public Memento pop(){
        if (mementos.size() > 0){
            Memento memento = mementos.get(mementos.size() - 1);
            mementos.remove(mementos.size() - 1);
            return memento;
        }
        return null;
    }
}
