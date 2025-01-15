public class EnigmaMachine {
    public EnigmaMachine() {

    }

    private void setRotors() {

    }

    private void setRotorPositions() {

    }

    private void setRingSettings() {

    }

    private void setReflector() {

    }

    private void setPlugboard() {

    }

    private void setMessage() {

    }



    private void turnRotors() {

    }

    private char passThroughPlugboard(char letter) {
        return '0';
    }

    private char passThroughRotors(char letter) {
        return '0';
    }

    private char passThroughReflector(char letter) {
        return '0';
    }



    private String encodeMessage() {
        passThroughPlugboard('0');
        passThroughRotors('0');
        passThroughReflector('0');
        passThroughRotors('0');
        passThroughPlugboard('0');

        return null;
    }
}