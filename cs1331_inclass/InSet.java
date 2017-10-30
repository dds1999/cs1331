public class IntSet<E>{
    // E or T signals a generic meaning it will take on whatever implementation
    //given. Also you can isntasiate an E array
    E[] backingArray = new (E[]) Object[10];
    int indexPointer = 0;

    public void add(E t) {
        if (indexPointer < backingArray.length()) {
            backingArray[indexPointer] = t;
            indexPointer++;
        } else {
            this.copyOneLarger();
            this.add(t);
        }
    }
    private void copyOneLarger() {
        E[] temp = new (E[]) Object[2 * backingArray.length];
        for (int i = 0; i < backingArray.length; i++) {
            temp[i] = backingArray[i];
        }
        backingArray = temp;
    }
    public E get(int i) {
        return backingArray[i];
    }
    public string toString(){
        String result = "[";
        for (E e : backingArray) {
            result += (e + ", ");
        }
        result = result.substring(0, result.length() - 2);
        result += "]";
        return result;
    }
}