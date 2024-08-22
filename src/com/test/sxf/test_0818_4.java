package com.test.sxf;

import java.util.ArrayList;
import java.util.Scanner;

public class test_0818_4 {
    public static class node {
        int src_ip, src_port, dest_ip, dest_port, protocol;

        public node(int src_ip, int src_port, int dest_ip, int dest_port, int protocol) {
            this.src_ip = src_ip;
            this.src_port = src_port;
            this.dest_ip = dest_ip;
            this.dest_port = dest_port;
            this.protocol = protocol;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<node> nodes = new ArrayList<>();
        ArrayList<node> rules=new ArrayList<>();
        for (int i = 0; i < n; i++) {

        }
    }
}
