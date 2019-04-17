# TMPS_lab №3
##### java version "1.8.0_201"
##### Java SE Runtime Environment (build 1.8.0_201-b09)
##### Java HotSpot 64-Bit Server VM (build 25.201-b09, mixed mode)
*Command, Memento, Observer, State, Mediator.*

The main idea of the project:
We have have a Command pattern as a proper way to work with the Observer class.
Command class works as the ExecutableClass with method 'run', other classes are extended from it, with overrided method 'run'. Namely, we can send these classes to the method which need params ExecutableClass. Doing by this we can easily create an Array List where we can save all the commands which we need us, and than execute them when we need it.

```
     ArrayList<Command.ExecCommand> commandArrayList = new ArrayList<>();
     commandArrayList.add(new Command.SubscribeCommand(0, "Ion", "31.12.1995", "Mobile App"));
    commandArrayList.add(new Command.SubscribeCommand(1, "Irina", "30.12.1995", "Mobile App"));
        commandArrayList.add(new Command.SubscribeCommand(Illay));

    for (Command.ExecCommand command : commandArrayList) {
            command.run();
    }
```
That introduct us the next pattern Memento.
Memento gives us possibility to save state of Array List by command and restore it if thst's need.

```
    Memento.Backup.makeOneBackup(commandArrayList);
    commandArrayList = Memento.Backup.getBackup(0);
```
So, Observer class implements 'observer' pattern where this class has Array List of Subscribers and has a method which sends messages for every subscriber. Work with this class goes throw using the pattern State and than implements 'state' pattern.

State has multiple classes which extends class 'state'. To make It more clear I also implement 'composite' pattern. Every state class has methods run() and by switching  state between classes we are also switching the executable code.

Example:
```
    State.Runnable runnableState = new State.Runnable();
    runnableState.setState(new State.PrintAllSubscribers());
    runnableState.run(Observer.InfoCenter.getArrayList());

    runnableState.setState(new State.PrintSize());
    runnableState.run(Observer.InfoCenter.getArrayList());

    runnableState.setState(new State.PrintAllSubscribersAdvanced());
    runnableState.run(Observer.InfoCenter.getArrayList());
```

Example of code:
```
     Observer.SubUser Illay = new Observer.SubUser(22, "Illay", "05.03.1993", "Browser");

        ArrayList<Command.ExecCommand> commandArrayList = new ArrayList<>();
```
![alt text](https://pp.userapi.com/c845217/v845217586/1e4e48/M7PZWyl6u4Y.jpg "Users and Admin")
       
```
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
```

