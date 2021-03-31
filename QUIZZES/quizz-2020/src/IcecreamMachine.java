public class IcecreamMachine {
    private Icecream icecream;
    public IcecreamMachine(Icecream icecream) {
        this.icecream = icecream;
    }

    public IcecreamMachine executeCommand(Command command) {
        command.execute(icecream);
        return this;
    }

    public void undoLastCommand() {
        icecream.removeScoop();
    }
}
