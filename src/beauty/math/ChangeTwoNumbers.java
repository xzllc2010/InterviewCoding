package beauty.math;

/**
 * Created by never on 14-9-15.
 */
public class ChangeTwoNumbers {

    public static void main(String[] args){

        System.out.println(change(13, 7));
    }

    public static int change(int a, int b){
        int ret = 0;
        int tmp = a ^ b;
        while (tmp != 0){
            tmp &= (tmp - 1);
            ret++;
        }
        return ret;
    }
}
