package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob17256 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Cake a = getCake(new StringTokenizer(br.readLine()));
        Cake c = getCake(new StringTokenizer(br.readLine()));
        int x = c.x - a.z;
        int y = c.y / a.y;
        int z = c.z - a.x;
        System.out.println(x + " " + y + " " + z);
    }

    private static Cake getCake(StringTokenizer st) {
        Cake c = new Cake();
        c.x = Integer.valueOf(st.nextToken());
        c.y = Integer.valueOf(st.nextToken());
        c.z = Integer.valueOf(st.nextToken());
        return c;
    }

    static class Cake {
        int x, y, z;

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Cake)) {
                return false;
            }
            Cake c = (Cake) obj;
            return this.x == c.x && this.y == c.y && this.z == c.z;
        }
    }
}
