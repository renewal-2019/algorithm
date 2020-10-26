package leecode.tree;

import java.util.*;

public class 目标和的路径 {
    //路径结果集
    List<List<Integer>> result = new ArrayList<>();
    //value是key的父节点,这样的目的是在找到符合要求的叶子节点后可以少花空间来追溯到根节点
    Map<TreeNode,TreeNode> map = new HashMap();

    /**
     * 广度优先
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null)
            return result;

        Queue<TreeNode> nodeQueue = new LinkedList();
        Queue<Integer> sumQueue = new LinkedList();
        nodeQueue.offer(root);
        sumQueue.offer(0);

        while (!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.poll();
            int rec = sumQueue.poll() + node.val;

            if(node.left == null && node.right == null){//判断是否到达叶子节点
                if(rec == sum){//判断是否符合条件
                    getPath(node);
                }
            }else {//没有到达叶子节点
                if(node.left != null){
                    map.put(node.left, node);
                    nodeQueue.offer(node.left);
//                    sumQueue.offer(node.left.val);
                    sumQueue.offer(rec);
                }
                if(node.right != null){
                    map.put(node.right, node);
                    nodeQueue.offer(node.right);
//                    sumQueue.offer(node.right.val);
                sumQueue.offer(rec);
                }
            }
        }

        return result;
    }

    //将符合条件的路径放到结果集中
    public void getPath(TreeNode node){
        List<Integer> list = new ArrayList<>();
//        list.add(node.val);
//        while (map.containsKey(node)){
//            TreeNode nodeX = map.get(node);
//            list.add(nodeX.val);
//            node = nodeX;
//        }
        while (node != null){
            list.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(list);
        result.add(new ArrayList<>(list));
    }
//===============================================================================================

    /**
     * 深度优先dfs
     */
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSumX(TreeNode root, int sum) {
        dfs(root,sum);
        return result;
    }

    public void dfs(TreeNode node, int sum){
        if(node == null)
            return;
        path.addLast(node.val);
        sum -= node.val;

        if(node.left == null && node.right == null && sum == 0){
            result.add(new LinkedList<>(path));
        }

        dfs(node.left,sum);
        dfs(node.right,sum);

        path.pollLast();
    }

}
