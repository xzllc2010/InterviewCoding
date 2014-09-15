package beauty.math;

/**
 * Created by never on 14-9-15.
 */
public class HowManyOne {

    public static void main(String[] args) {

        System.out.println(count_3(13));

    }

    public static int count_3(int num) {
        int ret = 0;
        while(num != 0){

            num &= (num - 1);
            ret++;
        }
        return ret;
    }

    public static int count_2(int num) {
        int ret = 0;
        while(num != 0){

            ret += num & 1;
            num >>= 1;
        }
        return ret;
    }

    public static int count_1(int num) {
        int ret = 0;
        while(num != 0){
            if(num % 2 == 1){
                ret++;
            }
            num /= 2;
        }
        return ret;
    }


}
