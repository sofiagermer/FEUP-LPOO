import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;

public class Game {
    private Screen screen;
    private Arena arena;
    private int x = 10;
    private int y = 10;

    public Game() {
        try {
            TerminalSize terminalSize = new TerminalSize(50, 25);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                    .setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary
            arena = new Arena (50,25);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void draw() throws IOException {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#ff8486"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(arena.width, arena.height), ' ');
        screen.clear();
        arena.draw(graphics);
        screen.refresh();
    }

    private void processKey(KeyStroke key) {
        System.out.println(key);
    }

    public void moveHero(Position position) {
        if (arena.canHeroMove(position))
            arena.serHeroPosition(position);
    }

    public void moveMonster(Position position, Monster monster) {
        if (!arena.canMonsterMove(position)) return;
        int counter = 0;
        for(Monster monster1 : arena.getMonsters()){
            if(monster.getPosition().equals(monster1.getPosition())) counter++;
        }
        System.out.println(counter);
        if(counter == 1) arena.setMonsterPosition(position, monster);
    }

    public void run() throws IOException {
        KeyStroke key;
        Position position;
        while (true) {
            draw();
            key = screen.readInput();
            if(key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') screen.close();
            if(key.getKeyType() == KeyType.EOF) break;
            switch (key.getKeyType()) {
                case ArrowUp:
                    moveHero(arena.moveHeroUp());
                    if(arena.verifyMonsterCollisions()) screen.close();
                    for(Monster monster : arena.getMonsters()){
                        position = arena.moveMonsterUp(monster);
                        moveMonster(position,monster);
                    }
                    if(arena.verifyMonsterCollisions()) screen.close();
                    break;
                case ArrowDown:
                    moveHero(arena.moverHeroDown());
                    if(arena.verifyMonsterCollisions()) screen.close();
                    for(Monster monster : arena.getMonsters()){
                        position = arena.moveMonsterDown(monster);
                        moveMonster(position,monster);
                    }
                    if(arena.verifyMonsterCollisions()) screen.close();
                    break;
                case ArrowRight:
                    moveHero(arena.moveHeroRight());
                    if(arena.verifyMonsterCollisions()) screen.close();
                    for(Monster monster : arena.getMonsters()){
                        position = arena.moveMonsterRight(monster);
                        moveMonster(position,monster);
                    }
                    if(arena.verifyMonsterCollisions()) screen.close();
                    break;
                case ArrowLeft:
                    moveHero(arena.moveHeroLeft());
                    if(arena.verifyMonsterCollisions()) screen.close();
                    for(Monster monster : arena.getMonsters()){
                        position = arena.moveMonsterLeft(monster);
                        moveMonster(position,monster);
                    }
                    if(arena.verifyMonsterCollisions()) screen.close();
                    break;
                default:
                    break;
            }
            processKey(key);
        }
    }
}
