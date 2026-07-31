class Car {
    int pos;
    int speed;
    int target;
    double at;

    Car(int pos, int speed, int target) {
        this.pos = pos;
        this.speed = speed;
        this.target = target;
    }

    void calcAT() {
        this.at = (double)(target - pos) / (double)speed;
    }
}

class Solution {
    public int calcAT(int target, int spd, int pos) {
        return (target - pos) / spd;
    }

    public int carFleet(int target, int[] pos, int[] speed) {
        Car cars[] = new Car[pos.length];

        for(int i = 0; i < pos.length; i++) {
            cars[i] = new Car(pos[i], speed[i], target);
            cars[i].calcAT();
        }

        Arrays.sort(cars, (a,b) -> Integer.compare(a.pos, b.pos));

        Stack<Double> stack = new Stack<>();
        stack.push(cars[pos.length-1].at);
        int ctr = 1;

        for(int i = pos.length - 2; i >= 0; i--) {

            if (cars[i].at > stack.peek()) {
                stack.push(cars[i].at);
                ctr++;
            }
        }

        return ctr;
    }
}