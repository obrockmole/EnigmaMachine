# Enigma Machine

My Java implementation of the Enigma Machine used for encrypting and decrypting messages.


## Description

The Enigma Machine was the cipher device used by Germany during World War II with most models implementing some or all  of the core mechanics including:
- Configurable rotors (5 types available)
- Reflector board (3 types available)
- Plugboard connections
- Ring settings
- Rotor positions


## Features

- Supports uppercase letters A-Z, lowercase letters are converted to uppercase
- Preserves non-alphabetic characters
- Implements historical rotor wirings
- Simulates mechanical stepping of rotors
- Messages can be both encoded and decoded using the same settings


## Technical Details

- The machine uses 3 rotors from a set of 5 historical rotor configurations
- Each rotor has a notch position that triggers the turnover of the next rotor
- The reflector ensures that encryption is reciprocal: decoding uses the same settings as encoding
- Plugboard connections swap letter pairs before and after the main encryption process


## Usage

Create an EnigmaMachine instance with the following parameters:

```java
EnigmaMachine enigma = new EnigmaMachine(
    int[] rotors,           // Rotor selection (1-5)
    char[] rotorPositions,  // Initial position of each rotor
    char[] ringSettings,    // Ring settings for each rotor
    char reflector,         // Reflector type (A, B, or C)
    String[] plugboard,     // Plugboard connections
    String message          // Message to encode
);

String encodedMessage = engima.encodeMessage();
```