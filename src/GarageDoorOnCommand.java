public class GarageDoorOnCommand implements ICommand {

    private GarageDoor GarageDoor;

    public GarageDoorOnCommand(GarageDoor GarageDoor) {
        this.GarageDoor=GarageDoor;
    }

    @Override
    public void execute() {
        GarageDoor.up();
        GarageDoor.lightOn();
    }
}
