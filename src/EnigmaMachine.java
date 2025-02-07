import java.util.ArrayList;

public class EnigmaMachine {
    String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String[][] rotorList = {
            {"EKMFLGDQVZNTOWYHXUSPAIBRCJ", "R"},
            {"AJDKSIRUXBLHWTMCQGZNPYFVOE", "F"},
            {"BDFHJLCPRTXVZNYEIWGAKMUSQO", "W"},
            {"ESOVPZJAYQUIRHXLNFTGKDCMWB", "K"},
            {"VZBRGITYUPSDNHLXAWMJQOFECK", "A"}
    };
    String[] reflectors = {
            "EJMZALYXVBWFCRQUONTSPIKHGD",
            "YRUHQSLDPXNGOKMIEBFZCWVJAT",
            "FVPJIAOYEDRZXWGCTKUQSBNMHL"
    };

    ArrayList<String[]> rotors;
    ArrayList<Integer> rotorPositions;
    String reflector;
    ArrayList<String> plugboard;
    String message;

    public EnigmaMachine(int[] rotors, char[] rotorPositions, char[] ringSettings,  char reflector, String[] plugboard, String message) {
        setRotors(rotors);
        setRotorPositions(rotorPositions);
        setRingSettings(ringSettings);
        setReflector(reflector);
        setPlugboard(plugboard);
        setMessage(message);
    }

    private void setRotors(int[] rotors) {
        for (int rotor : rotors) {
            this.rotors.add(rotorList[rotor - 1]);
        }
    }

    private void setRotorPositions(char[] rotorPositions) {
        for (char position : rotorPositions) {
            this.rotorPositions.add(ALPHABET.indexOf(position));
        }
    }

    private void setRingSettings(char[] ringSettings) {
        for (int i = 0; i < ringSettings.length; i++) {
            int dotPosition = this.rotors.get(i)[1].indexOf('A');
            int shiftAmount = ALPHABET.indexOf(ringSettings[i]);

            for (int j = 0; j < rotors.get(i)[0].length(); j++) {
                rotors.get(i)[0] = rotors.get(i)[0].substring(0, j) + ALPHABET.charAt((ALPHABET.indexOf(rotors.get(i)[0].charAt(j)) + shiftAmount) % 26) + rotors.get(i)[0].substring(j + 1);
            }

            while (rotors.get(i)[0].indexOf(ringSettings[i]) != (dotPosition + shiftAmount) % 26) {
                rotors.get(i)[0] = rotors.get(i)[0].substring(1) + rotors.get(i)[0].charAt(0);
            }
        }
    }

    private void setReflector(char reflector) {
        this.reflector = reflectors[ALPHABET.indexOf(reflector) % 3];
    }

    private void setPlugboard(String[] plugboard) {
        for (String pair : plugboard) {
            this.plugboard.add(pair.toUpperCase());
        }
    }

    public void setMessage(String message) {
        this.message = message.toUpperCase();
    }



    private void turnRotors() {
        //TODO
    }

    private char passThroughPlugboard(char letter) {
        for (String pair : plugboard) {
            if (pair.indexOf(letter) != -1) {
                letter = pair.charAt((pair.indexOf(letter) + 1) % 2);
                break;
            }
        }

        return letter;
    }

    private char passThroughRotors(char letter, boolean reverse) {
        //TODO
        return '0';
    }

    private char passThroughReflector(char letter) {
        int letterIndex = ALPHABET.indexOf(letter);
        letter = reflector.charAt(letterIndex);
        return letter;
    }

    public String encodeMessage(String message) {
        if (message == null) {
            return null;
        }

        setMessage(message);
        return encodeMessage();
    }

    public String encodeMessage() {
        if (message == null) {
            return null;
        }

        StringBuilder encodedMessage = new StringBuilder();

        for (char letter : message.toCharArray()) {
            if (ALPHABET.indexOf(letter) == -1) {
                encodedMessage.append(letter);
                continue;
            }

            turnRotors();
            letter = passThroughPlugboard(letter);
            letter = passThroughRotors(letter, false);
            letter = passThroughReflector(letter);
            letter = passThroughRotors(letter, true);
            letter = passThroughPlugboard(letter);
            encodedMessage.append(letter);
        }

        return encodedMessage.toString();
    }
}