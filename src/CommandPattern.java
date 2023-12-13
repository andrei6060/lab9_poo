import java.util.ArrayList;
import java.util.List;

// Interfața pentru comenzi
interface Command {
    void execute();
    void undo();
}

// Clase care implementează o comandă specifică
class LightOnCommand implements Command {
    private Light light;
    private boolean previousState;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        previousState = light.getState();
        light.turnOn();
    }

    @Override
    public void undo() {
        if (!previousState) {
            light.turnOff();
        }
    }
}

class LightOffCommand implements Command {
    private Light light;
    private boolean previousState;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        previousState = light.getState();
        light.turnOff();
    }

    @Override
    public void undo() {
        if (previousState) {
            light.turnOn();
        }
    }
}

// Clasa de lumină care va fi controlată de comenzile de lumină
class Light {
    private boolean state = false;

    public void turnOn() {
        state = true;
        System.out.println("Light is ON");
    }

    public void turnOff() {
        state = false;
        System.out.println("Light is OFF");
    }

    public boolean getState() {
        return state;
    }
}

// Clasa invocator care primește și execută comenzile
class RemoteControl {
    private Command command;
    private List<Command> commandHistory = new ArrayList<>();
    private int currentCommandIndex = -1;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
        commandHistory.add(command);
        currentCommandIndex++;
    }

    public void undo() {
        if (currentCommandIndex >= 0) {
            Command lastCommand = commandHistory.get(currentCommandIndex);
            lastCommand.undo();
            currentCommandIndex--;
        }
    }
}

public class CommandPattern {
    public static void main(String[] args) {
        Light light = new Light();

        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);

        // Invocator
        RemoteControl remoteControl = new RemoteControl();

        remoteControl.setCommand(lightOnCommand);
        remoteControl.pressButton();

        remoteControl.setCommand(lightOffCommand);
        remoteControl.pressButton();

        // Undo
        remoteControl.undo();
    }
}
