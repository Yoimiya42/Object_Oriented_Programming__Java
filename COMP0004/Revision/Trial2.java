
public class Trial2<T extends Comparable<T>> {
    
    private T value;
    
    public Trial2(T value) {
        this.value = value;
    }
    
    public T getValue() {
        return value;
    }
    
    public void setValue(T value) {
        this.value = value;
    }
    
    public int compareTo(T other) {
        return value.compareTo(other);
    }
    
    public static void main(String[] args) {
        Trial2<Integer> trial = new Trial2<>(5);
        System.out.println("Value: " + trial.getValue());
        
        trial.setValue(10);
        System.out.println("Updated Value: " + trial.getValue());
        
        System.out.println("Comparison: " + trial.compareTo(8));
    }
    
}
