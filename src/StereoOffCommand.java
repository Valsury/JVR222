public class StereoOffCommand implements ICommand{

    private Stereo stereo;
    public  StereoOffCommand(Stereo stereo)
    {
        this.stereo=stereo;
    }

    @Override
    public void execute() {
        stereo.off();
    }
}
