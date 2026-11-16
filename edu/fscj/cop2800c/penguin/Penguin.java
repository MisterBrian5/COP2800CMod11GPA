// Penguin.java
// Brian Sosa
// 11/15/26
// Represents a Palmer Penguin based on the works

package edu.fscj.cop2800c.penguin;

// Penguin class extends the Bird base class
public class Penguin extends Bird {
    // private fields
    private String species;
    private double flipperLength;

    // Constructor validates penguin data
    public Penguin(int sampleNum, String species,
                   double culmenLength, double culmenDepth,
                   double bodyMass, String sex, double flipperLength)
                   throws InvalidBirdDataException {
        super(sampleNum, culmenLength, culmenDepth, bodyMass, sex);

        if (flipperLength < 0 || species == null || species.isEmpty()) {
            throw new InvalidBirdDataException(
                    "Invalid Penguin data encountered.");
        }

        this.species = species;
        this.flipperLength = flipperLength;
    }

    // Returns the penguin's species
    public String getSpecies() {
        return species;
    }

    // Returns the penguin's flipper length
    public double getFlipperLength() {
        return flipperLength;
    }

    // Returns the penguin's data as a string
    @Override
    public String toString() {
        return super.toString() +
               ", species='" + species + '\'' +
               ", flipperLength=" + flipperLength;
    }

    // Compares birds and, when possible, penguins
    @Override
    public int compareTo(Bird other) {
        int result = super.compareTo(other);
        if (result != 0) {
            return result;
        }

        // Compare penguin fields when other is a Penguin
        if (other instanceof Penguin) {
            Penguin otherPenguin = (Penguin) other;

            result = Double.compare(
                    this.flipperLength, otherPenguin.flipperLength);
            if (result != 0) {
                return result;
            }

            if (this.species == null && otherPenguin.species == null) {
                return 0;
            }
            if (this.species == null) {
                return -1;
            }
            if (otherPenguin.species == null) {
                return 1;
            }

            return this.species.compareTo(otherPenguin.species);
        }

        return result;
    }
}