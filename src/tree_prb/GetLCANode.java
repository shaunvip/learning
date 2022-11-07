package tree_prb;

import java.util.ArrayList;
import java.util.List;

public class GetLCANode {
        public static void main(String[] args) {
                TreeNode treeNode = TreeNode.getTreeType2();
              TreeNode response=  getLCARoot(treeNode,new TreeNode(14),new TreeNode(50));
              System.out.println(response.val);
        }

        private static TreeNode getLCARoot(TreeNode treeNode, TreeNode treeNode1, TreeNode treeNode2) {
                List<TreeNode> pPath=new ArrayList<>();
                List<TreeNode> qPath=new ArrayList<>();
                traverse(treeNode, treeNode1,pPath);
                traverse(treeNode, treeNode2,qPath);
                for (int i = 0; i < Math.min(pPath.size(), qPath.size()); i++) {
                        if (pPath.get(i).val !=qPath.get(i).val){
                                return pPath.get(i-1);
                        }
                }
                return null;
        }

        private static boolean traverse(TreeNode treeNode, TreeNode treeNode1, List<TreeNode> path) {
                if (treeNode ==null){
                        return false;
                }
                path.add(treeNode);
                if (treeNode.val == treeNode1.val){
                        return true;
                }
                if(traverse(treeNode.left, treeNode1,path)){
                        return true;
                };
                if (traverse(treeNode.right, treeNode1,path)){
                        return true;
                }
                path.remove(path.size()-1);
                return false;
        }
}

