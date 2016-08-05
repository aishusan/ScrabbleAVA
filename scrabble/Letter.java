package scrabble;

/**
 * Created by vedsharma on 05-Aug-16.
 */
class Letter {
    private char character;
    private int point;
    public Letter(char character) {
        this.character = character;
        point=0;
    }
    public Letter(char character, int point) {
        this.character=character;
        this.point=point;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
    public String toString() {
        return "character : "+character+" point : "+point;
    }
}