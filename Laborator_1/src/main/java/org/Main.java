package org;

public class Main {

    public static void main(String[] args) {
        System.out.println("HELLO WORLD");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        System.out.println(languages[2]);
        int n = (int) (Math.random() * 1_000_000);
        System.out.println(n);
        n *= 3;
        String bin_string = "10101";
        int a = Integer.parseInt(bin_string, 2);
        n += a;
        String hex_string = "FF";
        int b = Integer.parseInt(hex_string, 16);
        n += b;
        n *= 6;
        while (n > 9) {
            int s = 0;
            while (n != 0) {
                int c = n % 10;
                n /= 10;
                s = s + c;
            }
            n = s;
        }
        System.out.println(n);
        System.out.print("Willy-nilly, this semester I will learn " + languages[n]);
    }
}
