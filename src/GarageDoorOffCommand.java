public class GarageDoorOffCommand implements ICommand {

    private GarageDoor GarageDoor;

    public GarageDoorOffCommand(GarageDoor GarageDoor) {
        this.GarageDoor=GarageDoor;
    }

    @Override
    public void execute() {
        GarageDoor.down();
        GarageDoor.lightOff();
    }
}