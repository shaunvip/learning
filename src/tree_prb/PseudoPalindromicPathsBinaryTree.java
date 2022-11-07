package tree_prb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PseudoPalindromicPathsBinaryTree {
  static   int result= 0;

    public static void main(String[] args) {
        List<List<Integer>> my= new ArrayList<>();
        getPaths(TreeNode.getTree(),my,new ArrayList<>());
        Map<Integer,Integer> map= new HashMap<>();
        isPsudoPanlindromic(TreeNode.getPTree());

        bottomLeftView(TreeNode.getTree(),new ArrayList<Integer>());
        System.out.println("ele>>"+element);
        System.out.println(">>"+result);
        System.out.println(my);
    }
   static int maxHt=0;
   static int element=0;

    private static void bottomLeftView(TreeNode root, ArrayList<Integer> tempList) {
        if (root==null){
            return;
        }
        tempList.add(root.val);
        if (root.left!=null){
            bottomLeftView(root.left,tempList);
        }
        if (root.right!=null){
            bottomLeftView(root.right,tempList);
        }
        if (root.left==null && root.right==null)
        {
           if (tempList.size()>maxHt){
               element=root.val;
               maxHt=tempList.size();
           }
        }
        tempList.remove(tempList.size()-1);
    }

    private static int isPsudoPanlindromic(TreeNode root) {
        int[] arr=new int[10];
        helper(root,arr);
        return result;

    }
    public static void helper(TreeNode root, int[] arr){
        if (root==null){
            return;
        }
        arr[root.val]=arr[root.val]+1;
        if (root.left!=null){
            helper(root.left,arr);
        }
        if (root.right!=null){
            helper(root.right,arr);
        }
        if (root.left==null && root.right==null)
        {
            int miss=0;
            for (int j : arr) {
                if (j % 2 != 0) {
                    miss++;
                }
            }
            if (miss<=1){
                result++;
            }
        }
        arr[root.val]=arr[root.val]-1;
    }

    private static void getPaths(TreeNode root, List<List<Integer>> my, List<Integer> tempList) {
        if (root==null){
            return;
        }
        tempList.add(root.val);
        if (root.left!=null){
            getPaths(root.left,my,tempList);
        }
        if (root.right!=null){
            getPaths(root.right,my,tempList);
        }
        if (root.left==null && root.right==null)
        {
            my.add(new ArrayList<>(tempList));
        }
        tempList.remove(tempList.size()-1);

    }
}
