package scrabble;
import java.util.ArrayList;

/**
 * Created by vedsharma on 05-Aug-16.
 */
class Word {
    private ArrayList<Letter> word;
    private int points;

    public Word() {
        word=new ArrayList<>();
        points=0;
    }

    public Word(String wordCharacters) {
        word=new ArrayList<>();
        points=0;
        char[] characters = wordCharacters.toCharArray();
        for (char ch: characters) {
            Letter newLetter = new Letter(ch,getPoint(ch));
            points+=newLetter.getPoint();
            word.add(newLetter);
        }
    }

    public ArrayList<Letter> getWord() {
        return word;
    }

    public void setWord(ArrayList<Letter> word) {
        this.word = word;
    }

    public int getWordSize() {
        return word.size();
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoint(char ch) {
        Integer[] points = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
        if(ch==' ')
            return 0;
        return points[ch-'A'];
    }

    public String toString() {
        String str="Word :\n";
        for (Letter letter: word) {
            str+=letter.toString()+"\n";
        }
        return str;
    }

}
