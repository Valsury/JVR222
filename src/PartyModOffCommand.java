public class PartyModOffCommand implements  ICommand {
    private PartyMod  partyMod;

    public PartyModOffCommand(PartyMod partyMod) {
        this.partyMod=partyMod;
    }

    @Override
    public void execute() {
        partyMod.PartyOff();
    }
}
