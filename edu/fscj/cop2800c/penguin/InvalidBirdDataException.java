// InvalidBirdDataException.java
// Brian Sosa
// 11/15/26
// Exception for invalid bird or penguin data

package edu.fscj.cop2800c.penguin;

public class InvalidBirdDataException extends Exception {
    public InvalidBirdDataException(String message) {
        super(message);
    }
}