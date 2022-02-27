package compulsory;

public class Main {

    public static void helloWorld() {
        System.out.println("HELLO WORLD");
    }

    public static int generateRandom() {
        int n = (int) (Math.random() * 1_000_000);
        System.out.println(n);
        return n;
    }

    public static int compute(int n) {
        n *= 3;
        String bin_string = "10101";
        int a = Integer.parseInt(bin_string, 2);
        n += a;
        String hex_string = "FF";
        int b = Integer.parseInt(hex_string, 16);
        n += b;
        n *= 6;
        System.out.println(n);
        return n;
    }

    public static int sumOfDigits(int n) {
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
        return n;
    }

    public static void print(int n, String[] languages) {
        System.out.print("Willy-nilly, this semester I will learn " + languages[n]);
    }

    public static void main(String[] args) {

        helloWorld();

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        System.out.println(languages[2]);

        int n;
        n = generateRandom();
        n = compute(n);
        n = sumOfDigits(n);
        print(n, languages);

    }
}
