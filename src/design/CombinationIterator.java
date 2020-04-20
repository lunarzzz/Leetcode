package design;

public class CombinationIterator {

    String characters;
    int len;
    int[] index;
    public CombinationIterator(String characters, int combinationLength) {
        this.characters = characters;
        this.len = combinationLength;
        index = new int[len];
        for (int i = 0; i < len; i++) {
            index[i] = i;
        }
        index[len-1]--;
    }


    public String next() {            //
        // abc len=2 [0,1]--> [0,2]---> [1,2]  //
        // abc len=3 [0,1,2]
        // 01,02,03,12,13,23 len=2 c=4
        //
        for (int i = len-1; i >=0; i--) {
            // i = 1; (2)
            // i = 0; (1)
//            if (index[i]< characters.length()-1 - (len-1 - i)) {
            if (index[i]< characters.length() - len + i) {
                index[i]++;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i:index) {
            sb.append(characters.charAt(i));
        }
        return sb.toString();
    }

    /**                  0  1
     * a b c d  len = 3, [2,3] 2 = 4-i = 4-2 =2;  012 013 023 1230----
     * @return
     */
    public boolean hasNext() {
        for (int i = 0; i < len; i++) {
            // 0 + 4 - 2 = 2.
            if (index[i] < i + characters.length() - len) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        CombinationIterator iterator = new CombinationIterator("abc", 2);
        // 创建迭代器 iterator

        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
