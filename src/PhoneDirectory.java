import java.util.List;

public class PhoneDirectory {
    private int[] segTree;
    private int base;
    private int max;

    //

    public PhoneDirectory(int maxNumbers) {
        this.max = maxNumbers;
        int powN = (int)Math.ceil(Math.log(maxNumbers)/Math.log(2));
        this.base = (int)Math.pow(2, powN);

        segTree = new int[2 * base];

        for (int i = base + maxNumbers; i < base * 2; i++){
            set(i);
        }
    }

    private void setAvailiable(int index){
        while (index > 0){
            segTree[index] = 0;
            index /= 2;
            if (segTree[index] == 0){
                break;
            }
        }
    }

    private void set(int index){
        segTree[index] = 1;

        while (index > 0){
            int neighbor;
            if (index % 2 == 0){
                neighbor = index + 1;
            } else {
                neighbor = index - 1;
            }

            if (segTree[neighbor] == 0){
                break;
            }

            index /= 2;
            segTree[index] = 1;
        }
    }



    private int findAvailiable(){
        int index = 1;

        while (index < base){
            index *= 2;
            int leftNode = index;
            int rightNode = index + 1;

            if (segTree[leftNode] == 0){
                index = leftNode;
            } else {
                index = rightNode;
            }
        }

        return index;
    }

    public int get(){
        if (segTree[1] == 1) return -1;

        int result = findAvailiable();
        set(result);

        return result % base;
    }

    public boolean check(int number){
        return segTree[base + number] == 0;
    }

    public void release(int number){
        setAvailiable(base + number);
    }
}
