package challenges;

import org.junit.Test;

public class RobotCleaner {



    @Test
    public void test() {
        String[] s = {"...X..", "....XX", "..X..."};
        this.solution(s);
    }


    public enum Direction {
        RIGHT,
        LEFT,
        UP,
        DOWN;

        public Direction getNext() {
            switch(this) {
                case RIGHT:
                    return DOWN;
                case DOWN:
                    return LEFT;
                case LEFT:
                    return UP;
                case UP:
                    return RIGHT;
                default:
                    return null;
            }
        }
    }
    public int solution(String[] R) {

        int line = 0;
        int column = 0;

        int numberOfLines = R.length;
        int numberOfColumns = R[0].length();

        Direction direction = Direction.RIGHT;
        Boolean[][] hasCleaned = new Boolean[numberOfLines][numberOfColumns];

        int maxStepsPossible = numberOfColumns * numberOfLines;
        int step = 0;

        do{

            Character c = R[line].charAt(column);

            if(c == '.') {
                hasCleaned[line][column] = true;
            }

            if(c == 'X') {
                direction = direction.getNext();
            }

            if(direction == Direction.RIGHT) {
                column++;
            }

            if(direction == Direction.LEFT) {
                column--;
            }

            if(direction == Direction.DOWN) {
                line++;
            }

            if(direction == Direction.UP) {
                line--;
            }

            step++;
        }while(maxStepsPossible > step);

        return hasCleaned.length;
    }

}
