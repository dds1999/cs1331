public class IntSet<E>{
    // E or T signals a generic meaning it will take on whatever implementation
    //given. Also you can isntasiate an E array
    E[] backingArray = (E[]) new Object[10];
    int indexPointer = 0;

    public void add(E e) {
        if (indexPointer < backingArray.length) {
            backingArray[indexPointer] = e;
            indexPointer++;
        } else {
            this.doubleSize();
            this.add(e);
        }
    }
    private void doubleSize() {
        E[] temp = (E[]) new Object[2 * backingArray.length];
        for (int i = 0; i < backingArray.length; i++) {
            temp[i] = backingArray[i];
        }
        backingArray = temp;
    }
    public E get(int i) {
        return backingArray[i];
    }
    @Override public String toString(){
        String result = "[";
        for (int i = 0; i < indexPointer; i++) {
            result += (backingArray[i] + ", ");
        }
        result = result.substring(0, result.length() - 2);
        result += "]";
        return result;
    }
    // would have to shift over everything
}