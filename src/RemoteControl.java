public class RemoteControl {
    private ICommand[] onCommands;

    private ICommand[] offCommands;


    public RemoteControl() {

        onCommands = new ICommand[Supervisor.buttonsCount];
        offCommands = new ICommand[Supervisor.buttonsCount];
        ICommand noCommand = new NoCommands();
        for (int i = 0; i < Supervisor.buttonsCount; i++) {

            onCommands[i] = noCommand;
            offCommands[i] = noCommand;

        }

    }


    public void setCommand(int slot, ICommand onCommand, ICommand offCommand) {

        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {

        onCommands[slot].execute();

    }


    public void offButtonWasPushed(int slot) {

        offCommands[slot].execute();

    }

    public String toString(String message) {

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n-----Remote Control----- " + message + "\n");

        for (int i = 0; i < offCommands.length; i++) {
            stringBuffer.append("[slot " + i + "] " +
                    offCommands[i].getClass().getName()
                    + "   " + offCommands[i].getClass().getName()+ "\n");
        }

        return stringBuffer.toString();

    }
}
