public class StereoOnWithCommand implements ICommand {
    private Stereo stereo;
    public  StereoOnWithCommand(Stereo stereo)
    {
        this.stereo=stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume("11");
    }
}
