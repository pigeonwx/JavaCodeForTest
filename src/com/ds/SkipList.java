package com.ds;

import java.util.Random;

class Node {
    int value;
    Node[] forward;

    public Node(int value, int level) {
        this.value = value;
        this.forward = new Node[level + 1];
    }
}

public class SkipList {
    private static final double P = 0.5;
    private Node header;
    private int maxLevel;
    private int currentLevel;
    private Random random;

    public SkipList(int maxLevel) {
        this.maxLevel = maxLevel;
        this.currentLevel = 0;
        this.header = new Node(-1, maxLevel);
        this.random = new Random();
    }

    private int randomLevel() {
        int level = 0;
        while (level < maxLevel && random.nextDouble() < P) {
            level++;
        }
        return level;
    }

    public void insert(int value) {
        Node[] update = new Node[maxLevel + 1];
        Node current = header;

        for (int i = currentLevel; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value < value) {
                current = current.forward[i];
            }
            update[i] = current;
        }

        current = current.forward[0];

        if (current == null || current.value != value) {
            int newLevel = randomLevel();

            if (newLevel > currentLevel) {
                for (int i = currentLevel + 1; i <= newLevel; i++) {
                    update[i] = header;
                }
                currentLevel = newLevel;
            }

            Node newNode = new Node(value, newLevel);
            for (int i = 0; i <= newLevel; i++) {
                newNode.forward[i] = update[i].forward[i];
                update[i].forward[i] = newNode;
            }
        }
    }

    public boolean search(int value) {
        Node current = header;
        for (int i = currentLevel; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value < value) {
                current = current.forward[i];
            }
        }
        current = current.forward[0];

        return current != null && current.value == value;
    }

    public boolean delete(int value) {
        Node[] update = new Node[maxLevel + 1];
        Node current = header;

        for (int i = currentLevel; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value < value) {
                current = current.forward[i];
            }
            update[i] = current;
        }

        current = current.forward[0];

        if (current != null && current.value == value) {
            for (int i = 0; i <= currentLevel; i++) {
                if (update[i].forward[i] != current) {
                    break;
                }
                update[i].forward[i] = current.forward[i];
            }

            while (currentLevel > 0 && header.forward[currentLevel] == null) {
                currentLevel--;
            }
            return true;
        }
        return false;
    }

    public void printList() {
        System.out.println("Skip List:");
        for (int i = 0; i <= currentLevel; i++) {
            Node node = header.forward[i];
            System.out.print("Level " + i + ": ");
            while (node != null) {
                System.out.print(node.value + " ");
                node = node.forward[i];
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList(3);

        skipList.insert(3);
        skipList.insert(6);
        skipList.insert(7);
        skipList.insert(9);
        skipList.insert(12);
        skipList.insert(19);
        skipList.insert(17);

        skipList.printList();

        System.out.println("Search for 7: " + skipList.search(7));
        System.out.println("Delete 3: " + skipList.delete(3));
        skipList.printList();
    }
}

