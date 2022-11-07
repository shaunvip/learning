package tree_prb;

import java.util.Arrays;

//Total number of possible Binary Trees with n different keys (countBT(n)) = countBST(n) * n!
public class TotalPossibleBST {
    static int count=0;
    public static void main(String[] args) {
        TreeNode treeNode= TreeNode.getTreeType2();
       getSize(treeNode);
        System.out.println(count+" size is");
        posssibleBst(count);
        fullBst(7);
        fullBst(5);

       String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};
        compare(word1,word2);
    }

    private static void compare(String[] word1, String[] word2) {
        String[] strings = word1.length > word2.length ? word1 : word2;
        int pos=0;
        for (int i = 0; i < strings.length; i++) {
           String temp= strings[i];
           String temp2=word2[pos];
            for (int j = 0; j < temp.length(); j++) {

            }
        }
    }

    /**
     In a "full" tree, there are an odd number of nodes and every second node in order is a leaf.

     If you remove all these leaves, you are left with a binary tree that might not be full.
     For any (maybe not full) binary tree, there is exactly one way to add a leaf at the start, the end,
     and between each pair of nodes, to make a full binary tree.

     So there is a 1-1 correspondence between binary trees with n nodes, and full trees with 2n+1 codes.

     C(n) -- the catalan number -- is the number of binary trees with n nodes, and also therefore the number of "full" trees
     with 2n+1 nodes.

     The number of full binary trees with n nodes is therefore C((n-1)/2).
     Since you can't have half a node, the answer is 0 when n is even.
     * @param count
     */
    private static void fullBst(int count) {
      int result=  catlan((count-1)/2);
        System.out.println(count+"  >>"+result);
    }
    private static int catlan(int num){
        if (num==1){
            return 1;
        }
        int fact=1;
        for (int i = num; i >1 ; i--) {
            fact*=i;
        }
        return fact;
    }

    private static void posssibleBst(int count) {
        int[] arr= new int[count+1];
        arr[0]=arr[1]=1;
        for (int i = 2; i <count ; i++) {
            for (int j = 0; j < i; j++) {
                arr[i]+=arr[j]*arr[i-j-1];
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void getSize(TreeNode treeNode) {
        if (treeNode==null){
            return ;
        }
        getSize(treeNode.left);
        count++;
        getSize(treeNode.right);
    }
}
