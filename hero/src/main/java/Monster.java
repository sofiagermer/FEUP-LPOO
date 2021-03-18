import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Monster extends Element{
    public Monster(int x, int y) {
        super(x, y);
    }
    public Position moveUp(){
        return new Position(super.getPosition().getX(), super.getPosition().getY() - 1);
    }
    public Position moveDown(){
        return new Position(super.getPosition().getX(), super.getPosition().getY() + 1);
    }
    public Position moveLeft(){
        return new Position(super.getPosition().getX() - 1, super.getPosition().getY());
    }
    public Position moveRight(){
        return new Position(super.getPosition().getX() + 1, super.getPosition().getY());
    }

    public void setPosition(Position pos){
        super.getPosition().setX(pos.getX());
        super.getPosition().setY(pos.getY());
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#000104 "));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(super.getPosition().getX(), super.getPosition().getY()), "M");
    }
}
