package challenges;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class CarStation {

    @Test
    public void test() {
        int [] a = {2, 8, 4, 3, 2};
        this.solution(a, 7, 11, 3);
    }


    public int solution(int[] cars, int X, int Y, int Z) {


        Queue dispenser1 = new LinkedList();
        Queue dispenser2 = new LinkedList();
        Queue dispenser3 = new LinkedList();


        int carNumber = 0;
        Queue<Integer> carQueue = new LinkedList<Integer>();

        for(int i =0; i < cars.length; i++) {
            carQueue.add(cars[i]);
        }

        int xCar = -1;
        int yCar = -1;
        int zCar = -1;
        int time = 0;

        while(true) {


            while(!carQueue.isEmpty()) {
                Integer car = carQueue.peek();

                if(car > X && car > Y && car > Z) {
                    return -1;
                }

                if(car <= X && xCar <= 0) {
                    xCar = carQueue.remove();
                    continue;
                } else if(car <= Y && yCar <= 0) {
                    yCar = carQueue.remove();
                    continue;
                } else if(car <= Z && zCar <= 0) {
                    zCar = carQueue.remove();
                    continue;
                }
                break;
            }

            if(carQueue.isEmpty()) {
                return time;
            }


            time++;

            if(xCar > 0) {
                X--;
                xCar--;
            }

            if(yCar > 0) {
                Y--;
                yCar--;
            }

            if(zCar > 0) {
                Z--;
                zCar--;
            }

        }

    }
}
