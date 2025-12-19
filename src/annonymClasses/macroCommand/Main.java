package annonymClasses.macroCommand;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Command command1 = new Command() {
            @Override
            public void execute() {
                System.out.println("Execute logic of command 1");
            }
        };

        Command command2 = new Command() {
            @Override
            public void execute() {
                System.out.println("Execute logic of command 2");
            }
        };
        Command command3 = new Command() {
            @Override
            public void execute() {
                System.out.println("Execute logic of command 3");
            }
        };

        Command command4 = new Command() {
            @Override
            public void execute() {
                System.out.println("Execute logic of command 4");
            }
        };
        MacroCommand macroCommand = new MacroCommand() {
            private List<Command> commandList = new ArrayList<>();

            @Override
            public void addCommand(Command c) {
                commandList.add(c);
            }

            @Override
            public void execute() {
                for (Command c : commandList) {
                    c.execute();
                    System.out.println("Execute logic of macro command 1");
                }
            }
        };

        MacroCommand macroCommand2 = new MacroCommand() {
            List<Command> commandList = new ArrayList<>();

            @Override
            public void addCommand(Command c) {
                commandList.add(c);
            }

            @Override
            public void execute() {
                for (Command c : commandList) {
                    c.execute();
                    System.out.println("Execute logic of macro command 2");
                }
            }
        };
        macroCommand.addCommand(command1);
        macroCommand.addCommand(command2);
        macroCommand2.addCommand(command3);
        macroCommand2.addCommand(command4);
        macroCommand.addCommand(macroCommand2);
        macroCommand.execute();
        //есть массив стрингов, отсортировать его во уменьшению длин этих стрингов
        ArrayList<String> array = new ArrayList<>();
        Collections.addAll(array, "t", "text", "12", "t123", "9898", "qwerty", "qwertyText123", "1234d", "text01", "q89");
        Comparator<String> lengthComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        };
        Collections.sort(array, lengthComparator);
        System.out.println(array);


    }

}
