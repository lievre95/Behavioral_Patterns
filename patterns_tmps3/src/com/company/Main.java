package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
System.out.println("Start proceeding...");
        Observer.SubUser Illay = new Observer.SubUser(22, "Illay", "05.03.1993", "Browser");

        ArrayList<Command.ExecCommand> commandArrayList = new ArrayList<>();

        commandArrayList.add(new Command.SubscribeCommand(0, "Ion", "31.12.1995", "Mobile App"));
        commandArrayList.add(new Command.SubscribeCommand(1, "Irina", "30.12.1995", "Mobile App"));
        commandArrayList.add(new Command.SubscribeCommand(Illay));


        Memento.Backup.makeOneBackup(commandArrayList);
        Memento.Backup.getInfoAboutOneBackup(Memento.Backup.execCommands.size() - 1);

        commandArrayList.add(new Command.UnsubscribeCommand(0));
        commandArrayList.add(new Command.UnsubscribeCommand(Illay));

        Memento.Backup.makeOneBackup(commandArrayList);
        Memento.Backup.getInfoAboutOneBackup(Memento.Backup.execCommands.size() - 1);

        commandArrayList = Memento.Backup.getBackup(0);

        for (Command.ExecCommand command : commandArrayList) {
            command.run();
        }


        Observer.InfoCenter.sendMessages();


        State.Runnable runnableState = new State.Runnable();
        runnableState.setState(new State.PrintAllSubscribers());
        runnableState.run(Observer.InfoCenter.getArrayList());

        runnableState.setState(new State.PrintSize());
        runnableState.run(Observer.InfoCenter.getArrayList());

        runnableState.setState(new State.PrintAllSubscribersAdvanced());
        runnableState.run(Observer.InfoCenter.getArrayList());
    }
}
