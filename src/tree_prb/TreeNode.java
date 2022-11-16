package tree_prb;


public class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int item) {
        val = item;
        left = null;
        right = null;
    }
                //        1
    //             2           3
    //          4      5          7
    //      14   15  40 50    17      7
    //  1  3  7  7  71  17  2  5  50  40  4  15  14Mirror element is true
    public static TreeNode getTreeType2(){
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4); // 2 L
        root.left.right = new TreeNode(5); // 2 R
        root.right.right = new TreeNode(7); // 3R

        root.left.left.left = new TreeNode(14);
        root.left.left.right = new TreeNode(15);

        root.left.right.left = new TreeNode(40);
        root.left.right.right = new TreeNode(50);

        root.right.right.left = new TreeNode(17);
        root.right.right.right = new TreeNode(7);

      //  root.right.right.right.right = new TreeNode(71);
        return root;
    }
    public static TreeNode getTree(){
      TreeNode root = new TreeNode(20);
        root.left = new TreeNode(11);
        root.right = new TreeNode(9);
//        root.left.left = new TreeNode(7);
//        root.left.right = new TreeNode(49);
//        root.right.left = new TreeNode(5);
//        root.right.right = new TreeNode(44);
        return root;
        //            10
        //         /      \
        //        11       9
        //       /  \     / \
        //      7    49  5   44
    } public static TreeNode getPTree(){
      TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(1);
       // root.right.left = new Node(5);
        root.right.right = new TreeNode(1);
        return root;
        //            2
        //         /      \
        //        1        9
        //       /  \     / \
        //      1    4   5   4
    }



    public static TreeNode getBinary2() {

        TreeNode   tree_level = new TreeNode(1);
        tree_level.left = new TreeNode(2);
        tree_level.right = new TreeNode(3);
        tree_level.left.left = new TreeNode(4);
        tree_level.left.right = new TreeNode(5);
        tree_level.right.left = new TreeNode(6);
        return tree_level;
    }
    //              1
    //          13      3
    //                2    23
    //              4  5


}