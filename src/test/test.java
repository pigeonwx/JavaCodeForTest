package test;

import java.util.*;

public class test {

    public static int cx=12,cy=8,cz=5,target=6;
    public static void main(String[] args) {
        int m = 12, n = 0, l = 0;
        Map<Integer, Boolean> mp = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(hash(m, n, l));
        while (!q.isEmpty()) {
            int t = q.poll();
            int x = t / 10000;
            int y = (t % 10000) / 100;
            int z = t % 100;
            if(x==target||y==target||z==target){
                System.out.println("true");
            }
            transfer(x,y,z,q,mp);
        }
        System.out.println("false");
    }

    public static int hash(int x, int y, int z) {
        return x * 10000 + y * 100 + z;
    }

    public static void transfer(int x, int y, int z, Queue<Integer> q, Map<Integer, Boolean> mp) {
        int tx,ty,tz;
        // x->y
        if(x+y>cy){
            ty=cy;
            tx=x-cy;
            tz=z;
        }else{
            tx=0;
            ty=y+x;
            tz=z;
        }
        int hasht=hash(tx,ty,tz);
        if(!mp.containsKey(hasht)){
            q.offer(hasht);
        }
        // x->z

        // y->x

        // y->z

        // z->x

        // z->y

    }
}
