import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    int width;
    int height;
    private Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        hero = new Hero(10, 10);
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonster();
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return coins;
    }

    private List<Monster> createMonster() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            monsters.add(new Monster(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return monsters;
    }

    public void draw(TextGraphics graphics) {
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width * 2, height * 2), ' ');
        hero.draw(graphics);
        for (Wall wall : walls)
            wall.draw(graphics);
        for (Coin coin : coins)
            coin.draw(graphics);
        for (Monster monster : monsters)
            monster.draw(graphics);
    }

    public boolean canHeroMove(Position position) {
        for (Wall wall : walls) {
            if (wall.getPosition().equals(position)) return false;
        }
        return true;
    }

    public boolean canMonsterMove(Position position) {
        for (Wall wall : walls) {
            if (wall.getPosition().equals(position)) return false;
        }

        return true;
    }

    public Position moveHeroUp() {
        return hero.moveUp();
    }

    public Position moverHeroDown() {
        return hero.moveDown();
    }

    public Position moveHeroLeft() {
        return hero.moveLeft();
    }

    public Position moveHeroRight() {
        return hero.moveRight();
    }

    public void serHeroPosition(Position position) {
        hero.setPosition(position);
        coins.removeIf(coin -> hero.getPosition().equals(coin.getPosition()));
    }

    public List<Monster> getMonsters() {
        return this.monsters;
    }

    public Position moveMonsterUp(Monster monster) {
        return monster.moveUp();
    }

    public Position moveMonsterDown(Monster monster) {
        return monster.moveDown();
    }

    public Position moveMonsterLeft(Monster monster) {
        return monster.moveLeft();
    }

    public Position moveMonsterRight(Monster monster) {
        return monster.moveRight();
    }

    public void setMonsterPosition(Position position, Monster monster) {
        monster.setPosition(position);
    }

    public boolean verifyMonsterCollisions() {
        for (Monster monster : monsters) {
            if (hero.getPosition().equals(monster.getPosition())) return true;
        }
        return false;
    }
}