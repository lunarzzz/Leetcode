package leetcodedaily;

public class T466 {


    public static void main(String[] args) {

    }

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < n1; i++) {
            sb1.append(s1);
        }
        String ss1 = sb1.toString();

        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < n2; i++) {
            sb2.append(s2);
        }
        String ss2 = sb2.toString();

        // acb 4 -> acbacbacbacb
        // ab 2  -> abab
        // abab M --> get from acbacbacbacb
//        for (int i = 0; i < ; i++) {
//
//        }
        return 0;
    }

}
