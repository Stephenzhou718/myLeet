package com.company.Tree.Trie5;


/**
 * 实现一个 Trie，用来实现前缀和
 * 要求：
 * 难度：Medium
 * 第一次是否做出：否，
 */
public class P2_677 {
    class MapSum {

        private class Node{
            Node[] child = new Node[26];
            int value;
        }

        private Node root = new Node();

        /** Initialize your data structure here. */
        public MapSum() {

        }

        public void insert(String key, int val) {
            insert(key, val, root);
        }

        private void insert(String key, int val, Node node){
            if(node == null) return;
            if(key.length() == 0){
                node.value = val;
                return;
            }
            int index = indexForChar(key.charAt(0));
            if(node.child[index] == null){
                node.child[index] = new Node();
            }

            insert(key.substring(1), val, node.child[index]);
        }

        public int sum(String prefix) {
            return sum(prefix, root);
        }

        private int sum(String prefix, Node node){
            if(node == null) return 0;
            if(prefix.length() != 0){
                int index = indexForChar(prefix.charAt(0));
                return sum(prefix.substring(1), node.child[index]);
            }

            int sum = node.value;
            for(Node child : node.child){
                sum += sum(prefix, child);
            }
            return sum;
        }

        private int indexForChar(char c){
            return c - 'a';
        }
    }
}
