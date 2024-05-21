public class PartyModOnCommand implements ICommand {

    private PartyMod  partyMod;

    public PartyModOnCommand(PartyMod partyMod) {
        this.partyMod=partyMod;
    }

    @Override
    public void execute() {
        partyMod.PartyOn();
    }
}
