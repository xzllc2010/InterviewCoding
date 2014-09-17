package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by caolei.cl on 9/16/2014.
 */
public class TreeNodeMain {

    public static void main(String[] args){

        TreeNode rootA = initTreeA();
        TreeNode rootB = initTreeB();

        System.out.println(isSame(rootA, rootB));

    }

//    public static boolean isAVLRec(TreeNode rootA){
//        if(rootA == null){
//            return true;
//        }
//
//    }

    public static boolean isSame(TreeNode rootA, TreeNode rootB){
        if(rootA == null && rootB == null){
            return true;
        }else if(rootA == null || rootB == null){
            return false;
        }

        Queue<TreeNode> queueA = new LinkedList<TreeNode>();
        Queue<TreeNode> queueB = new LinkedList<TreeNode>();
        queueA.add(rootA);
        queueB.add(rootB);

        while (!queueA.isEmpty() && !queueB.isEmpty()){
            TreeNode tmpNodeA = queueA.remove();
            TreeNode tmpNodeB = queueB.remove();

            if(tmpNodeA == null && tmpNodeB == null){
                continue;
            }else if(tmpNodeA != null && tmpNodeB != null && tmpNodeA.value == tmpNodeB.value){
                queueA.add(tmpNodeA.leftNode);
                queueA.add(tmpNodeA.rightNode);
                queueB.add(tmpNodeB.leftNode);
                queueB.add(tmpNodeB.rightNode);
            }else{
                return false;
            }
        }
        return true;

    }

    public static boolean isSameRec(TreeNode rootA, TreeNode rootB){
        if(rootA == null && rootB == null){
            return true;
        }else if(rootA == null || rootB == null){
            return false;
        }
        if(rootA.value != rootB.value){
            return false;
        }

        return isSameRec(rootA.leftNode, rootB.leftNode) & isSameRec(rootA.rightNode, rootB.rightNode);
    }

    public static int getNodeNumLeaf(TreeNode root){
        if(root == null){
            return 0;
        }
        int leafNodeNum = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode tmpNode = queue.remove();
            if(tmpNode.leftNode == null && tmpNode.rightNode == null){
                leafNodeNum++;
            }
            if(tmpNode.leftNode != null){
                queue.add(tmpNode.leftNode);
            }
            if(tmpNode.rightNode != null){
                queue.add(tmpNode.rightNode);
            }
        }
        return leafNodeNum;
    }

    public static int getNodeNumLeafRec(TreeNode root){
        if(root == null){
            return 0;
        }else if(root.leftNode == null && root.rightNode == null){
            return 1;
        }
        return getNodeNumLeafRec(root.leftNode) + getNodeNumLeafRec(root.rightNode);
    }

    public static void levelTraversal(TreeNode root) {
        if(root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode curNode = queue.remove();
            System.out.print(curNode.value + " ");
            if (curNode.leftNode != null){
                queue.add(curNode.leftNode);
            }
            if (curNode.rightNode != null){
                queue.add(curNode.rightNode);
            }
        }
    }

    public static void postorderTraversalRec(TreeNode root){
        if(root == null){
            return;
        }
        preorderTraversalRec(root.leftNode);
        preorderTraversalRec(root.rightNode);
        System.out.print(root.value + " ");
    }

    public static void inorderTraversalRec(TreeNode root){
        if(root == null){
            return;
        }
        preorderTraversalRec(root.leftNode);
        System.out.print(root.value + " ");
        preorderTraversalRec(root.rightNode);
    }

    public static void preorderTraversalRec(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.value + " ");
        preorderTraversalRec(root.leftNode);
        preorderTraversalRec(root.rightNode);
    }

    public static int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int treeDepth = 0;
        int curLevelCount = 1;
        int nextLevelCount = 0;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode tmpNode = queue.remove();
            curLevelCount--;
            if(tmpNode.leftNode != null){
                nextLevelCount++;
                queue.add(tmpNode.leftNode);
            }
            if(tmpNode.rightNode != null){
                nextLevelCount++;
                queue.add(tmpNode.rightNode);
            }
            if(curLevelCount == 0){
                treeDepth++;
                curLevelCount = nextLevelCount;
                nextLevelCount = 0;
            }
        }
        return treeDepth;

    }

    public static int getDepthRec(TreeNode root){
        if(root == null){
            return 0;
        }else{
            return Math.max(getDepthRec(root.leftNode), getDepthRec(root.rightNode)) + 1;
        }
    }

    public static int getNodeNum(TreeNode root){
        if(root == null){
            return 0;
        }
        int nodeCount = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        nodeCount++;

        while (!queue.isEmpty()){
            TreeNode tmpNode = queue.remove();
            if(tmpNode.leftNode != null){
                nodeCount++;
                queue.add(tmpNode.leftNode);
            }
            if(tmpNode.rightNode != null){
                nodeCount++;
                queue.add(tmpNode.rightNode);
            }
        }
        return nodeCount;

    }

    public static int getNodeNumRec(TreeNode root){
        if(root == null){
            return 0;
        }else{
            return (getNodeNumRec(root.leftNode) + getNodeNumRec(root.rightNode) + 1);
        }
    }

    public static  TreeNode initTreeA(){

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        TreeNode t10 = new TreeNode(10);
        TreeNode t11 = new TreeNode(11);
        TreeNode t12 = new TreeNode(12);
        TreeNode t13 = new TreeNode(13);
        TreeNode t14 = new TreeNode(14);

        t1.leftNode = t2;
        t1.rightNode = t3;
        t2.leftNode = t4;
        t2.rightNode = t5;
        t3.leftNode = t6;
        t3.rightNode = t7;
        t4.leftNode = t8;
        t4.rightNode = t9;
        t5.leftNode = t10;
        t6.leftNode = t11;
        t7.rightNode = t12;
        t8.leftNode = t13;
        t8.rightNode = t14;

        return t1;

    }

    public static  TreeNode initTreeB(){

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        TreeNode t10 = new TreeNode(10);
        TreeNode t11 = new TreeNode(11);
        TreeNode t12 = new TreeNode(12);
        TreeNode t13 = new TreeNode(13);
        TreeNode t14 = new TreeNode(14);

        t1.leftNode = t2;
        t1.rightNode = t3;
        t2.leftNode = t4;
        t2.rightNode = t5;
        t3.leftNode = t6;
        t3.rightNode = t7;
        t4.leftNode = t8;
        t4.rightNode = t9;
        t5.leftNode = t10;
        t6.leftNode = t11;
        t7.rightNode = t12;
        t8.leftNode = t13;
        //t8.rightNode = t14;

        return t1;

    }
}
