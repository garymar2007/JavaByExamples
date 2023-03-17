package java8.lambdaexpression;

public class Example {

    public int addNumbers(int num) {
        int sum = 0;
        for ( int i = num; i >= 1; i--) {
            sum += i;
        }
        return sum;
    }

    public int addNumRec(int num) {
        if(num == 1) {
            return num;
        } else {
            return num + addNumRec(num-1);
        }
    }

}
