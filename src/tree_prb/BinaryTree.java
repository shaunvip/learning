package tree_prb;

import java.util.*;

public class BinaryTree {
        TreeNode root;
        private static BinaryTree getBinaryTree() {
                BinaryTree tree_level = new BinaryTree();
                tree_level.root = new TreeNode(1);
                tree_level.root.left = new TreeNode(13);
                tree_level.root.right = new TreeNode(3);
                tree_level.root.right.left = new TreeNode(2);
                tree_level.root.right.right = new TreeNode(23);
                tree_level.root.right.left.left = new TreeNode(4);
                tree_level.root.right.left.right = new TreeNode(5);
                return tree_level;
        }

        //              1
        //          13      3
        //                2    23
        //              4  5
        public static void main(String[] args) {
                BinaryTree tree_level = getBinaryTree();
                System.out.println("LEVEL ORDEr");
                tree_level.printLevelOrder();
                tree_level.getLCA(4,3);
                tree_level.printLeftView();
                tree_level.printLeftViewRec();
                tree_level.printKDistance(2);
                TreeNode root= TreeNode.getTreeType2();
                System.out.println("PRINT K DISTANCE 2");
                tree_level.printKDistance(root,2);
                System.out.println("RIGHT VIEW  ");
                tree_level.printRightView();
                System.out.println("\n\n CHILDREN SUM \n\n");
                TreeNode root2= TreeNode.getTree();
                boolean answer=  tree_level.childrenSum(root2);
                System.out.println(answer);
                System.out.println("Max element is "+tree_level.maximum(root2));
                System.out.println("Max element isw "+tree_level.maximumIte(root2));
                System.out.println("Width element is "+tree_level.width(TreeNode.getTreeType2()));
                System.out.println("SPIRAL element is "+tree_level.spiral(TreeNode.getTreeType2()));
                System.out.println("LEVEL ORDEr");
                tree_level.printLevelOrder();
                System.out.println("Mirror element is "+tree_level.mirror(TreeNode.getTreeType2()));

        }

        private boolean mirror(TreeNode root) {
                getMirror(root);
                return true;
        }
        // 1
         //2 3
        // 4 5 7
        public void getMirror(TreeNode root){
                if (root==null){
                        return;
                }
                Queue<TreeNode> queue= new LinkedList<>();
                queue.add(root);
                while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int i = 0; i < size; i++) {
                                TreeNode temp = queue.poll();
                                System.out.print("  " + temp.val);
                                TreeNode tempN=temp.left;
                                temp.left=temp.right;
                                temp.right=tempN;
                                if (temp.left!=null){
                                        queue.add(temp.left);
                                } if (temp.right!=null){
                                        queue.add(temp.right);
                                }

                        }

                }
        }


        private int spiral(TreeNode root2) {
                Queue<TreeNode> queue= new LinkedList<>();
                queue.add(root2);
                int width=1;
                boolean ltr=true;
                while (!queue.isEmpty()){
                        int size= queue.size();
                        width=Math.max(width, size);
                        ltr= !ltr;
                        for (int i=0; i < size; i++) {
                                TreeNode ele=queue.poll();
                                System.out.print(ele.val +" ");
                                if (ltr) {
                                        if (ele.left != null) queue.add(ele.left);
                                        if (ele.right != null) queue.add(ele.right);
                                }
                                else {
                                        if (ele.right != null) queue.add(ele.right);
                                        if (ele.left != null) queue.add(ele.left);
                                }
                        }
                        System.out.println();
                }
                return width;
        }
        private int width(TreeNode root2) {
                Queue<TreeNode> queue= new LinkedList<>();
                queue.add(root2);
                int width=1;
                while (!queue.isEmpty()){
                        int size= queue.size();
                        width=Math.max(width, size);
                        for (int i=0; i < size; i++) {
                                TreeNode ele=queue.poll();
                                System.out.print(ele.val +" ");
                                if (ele.left!=null) queue.add(ele.left);
                                if (ele.right!=null) queue.add(ele.right);
                        }
                        System.out.println();
                }
                return width;
        }

        private void printLevelOrder() {
                Queue<TreeNode> queue= new LinkedList<>();
                queue.add(root);
                while (!queue.isEmpty()){

                        TreeNode temp=queue.poll();
                        System.out.println(temp.val);
                        if (temp.left!=null){
                                queue.add(temp.left);
                        }
                        if (temp.right!=null){
                                queue.add(temp.right);
                        }
                }
        }
        private int maximumIte(TreeNode root2) {
               Queue<TreeNode> queue= new LinkedList<>();
                queue.add(root2);
                int max=Integer.MIN_VALUE;
               while (!queue.isEmpty()){
                       TreeNode ele= queue.poll();
                       if (ele.val >max) max=ele.val;
                       if (ele.left!=null){
                               queue.add(ele.left);
                       }if (ele.right!=null){
                               queue.add(ele.right);
                       }
               }
               return max;
        }

        private int maximum(TreeNode root2) {
                if (root2==null) return Integer.MIN_VALUE;
                return Math.max(root2.val, Math.max(maximum(root2.left),maximum(root2.right)));
        }



        private boolean childrenSum(TreeNode root) {
                if (root==null)
                        return true;
                if (root.left==null && root.right==null)
                        return true;
                int sum=0;
                if (root.right!=null)
                        sum+=root.right.val;
                if (root.left!=null)
                        sum+=root.left.val;
                return sum == root.val && childrenSum(root.left) && childrenSum(root.right);
        }

        private void printRightView() {
                Queue<TreeNode> queue= new LinkedList<>();
                queue.add(root);
                while (!queue.isEmpty()){
                        int size=queue.size();
                        for (int i = 0; i < size; i++) {
                                TreeNode temp=queue.poll();
                                if (i==size-1){
                                        System.out.print(temp.val +"  ");
                                }
                                if (temp.left!=null){
                                        queue.add(temp.left);
                                }
                                if (temp.right!=null){
                                        queue.add(temp.right);
                                }
                        }
                }
        }


        private void printKDistance(int i) {
                System.out.println("PRINT K DISTANCE");
                printKDistance(root,i);
        }

        private void printKDistance(TreeNode root, int i) {
                if (root==null){
                        return;
                }if (i==0){
                        System.out.println(root.val);
                }
                printKDistance(root.left,i-1);
                printKDistance(root.right,i-1);
        }

        static int max=0;
        private void printLeftView() {
                System.out.println("Left view");
                printLeftView(root,1);
        }
        private void printLeftViewRec(){
                System.out.println("LEFT VIEW REC");
                Queue<TreeNode> queue= new LinkedList<>();
                queue.add(root);
                while (!queue.isEmpty()){
                        int size= queue.size();
                        for (int i = 0; i < size; i++) {
                                TreeNode temp = queue.poll();
                                if (i==0)
                                 System.out.println(temp.val);
                                if (temp.left != null) {
                                        queue.add(temp.left);
                                }
                                if (temp.right != null) {
                                        queue.add(temp.right);
                                }
                        }
                }
        }

        private void printLeftView(TreeNode root, int level) {
                if (root==null) return;
                if (max<level){
                        System.out.println(root.val +" "+max+" "+level);
                        max=level;
                }
                printLeftView(root.left,level+1);
                printLeftView(root.right,level+1);
        }


        private void getLCA(int num1,int num2){
                List<Integer> p1=new ArrayList<>();
                List<Integer> p2=new ArrayList<>();
                pathToNum(root,num1,p1);
                pathToNum(root,num2,p2);
                int i;
                for (i = 0; i < p1.size() && i < p2.size(); i++) {

                        if (!p1.get(i).equals(p2.get(i)))
                                break;
                }

                System.out.println("HIHHI+"+p1.get(i-1));
        }

        private boolean pathToNum(TreeNode root , int num, List<Integer> p1) {
                if (root==null) return false ;
                p1.add(root.val);
                if (root.val ==num)
                        return true;
                if (pathToNum(root.left, num, p1)) {
                        return true;
                }
                if (pathToNum(root.right, num, p1)) {
                        return true;
                }
                System.out.println("Will remove"+p1.get(p1.size() - 1));
                p1.remove(p1.size() - 1);
                return false;

        }
}

