public class Main {
    public static void main(String[] args) {
        String message = "Hello World";

        EnigmaMachine enigma = new EnigmaMachine(
            new int[] {1, 2, 3},
            new char[] {'A', 'A', 'A'},
            new char[] {'A', 'A', 'A'},
            'B',
            new String[] {},
            message
        );

        System.out.printf("Original message: %s\n", message);
        System.out.printf("New message: %s\n", enigma.encodeMessage());
    }
}
