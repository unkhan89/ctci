


public class Test2 {

    public static void main(String[] args) {

        int n = 10;

        int count = 0;
        
        for(int i = 0; i < n; i++) {

            for(int j = 0; j < n; j++) {

                count++;
            }
        }  

        System.out.println("Count is " + count);

        count = 0;

        for(int i = 0; i < n; i++) {

            for(int j = 0; j < i; j++) {

                count++;
            }
        }

        System.out.println("Count is " + count);

    }
}


