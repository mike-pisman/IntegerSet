
/*
 * Mikhail Pisman
 * mpisman@pengo.cabrillo.edu
 * peaceman.michael@gmail.com
 * IntegerSet.java
 */
import java.util.Random;

public class IntegerSet
{
    private final static int MAXSETVALUE = 1000;
	private boolean data[];
	public static int getMaxSetValue(){ return MAXSETVALUE; }

    // Constructor with any number of initial values
    public IntegerSet(int... numbers) {
        data = new boolean[MAXSETVALUE];
        for (int i : numbers)
            insertElement(i);
    }
    // Function to add the element to the set
    public void insertElement(int element) {
        if(element > 0 && element < MAXSETVALUE)
            data[element] = true;
    }
    // Function to delete the element from the set
    public void deleteElement(int element) {
        if(element > 0 && element < MAXSETVALUE)
            data[element] = false;
    }
    // toString function to print out a set as a whole
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < MAXSETVALUE; i++)
            if (hasElement(i))
                result += i + ", ";
        result = result.substring(0, result.length() - 2);

        return "{" + result + "}";
    }
    // Function to compare to sets
    public boolean equals(IntegerSet set) {
        for (int i = 0; i < MAXSETVALUE; i++)
            if (data[i] != set.data[i])
                return false;
        return true;
    }
    // Function to check if the element is the set
    public boolean hasElement(int element) {
        if (element > 0 && element < MAXSETVALUE)
            if (data[element] == true)
                return true;
        return false;
    }
    // Function makes the set a union of two sets in arguments
    public void unionOf(IntegerSet set1, IntegerSet set2) {
        for (int i = 0; i < MAXSETVALUE; i++)
            this.data[i] = set1.data[i] || set2.data[i];
    }
    // Function makes the set an intersection of two sets in arguments
    public void intersectionOf(IntegerSet set1, IntegerSet set2) {
        for (int i = 0; i < MAXSETVALUE; i++)
            this.data[i] = set1.data[i] && set2.data[i];
    }
}
