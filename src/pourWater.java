import java.util.Stack;

class pourWater {
    public int[] pourWater(int[] heights, int V, int K) {
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();

        int leftWall = K;
        int rightWall = K;

        for (int i = 0; i < V; i++){
            while (leftWall > 0 && heights[leftWall - 1] <= heights[leftWall]){
                leftWall--;
                if (heights[leftWall] < heights[leftWall + 1]){
                    leftStack.push(leftWall);
                }
            }
            while (rightWall > 0 && heights[rightWall + 1] <= heights[rightWall]){
                rightWall++;
                if (heights[rightWall] < heights[rightWall - 1]){
                    rightStack.push(rightWall);
                }
            }

            if (!leftStack.empty()){
                int currentDrop = leftStack.peek();
                heights[currentDrop]++;
                if (heights[currentDrop] >= heights[currentDrop + 1]){
                    leftStack.pop();
                }
                if (heights[currentDrop] > heights[leftWall]){
                    leftStack.push(currentDrop - 1);
                }
            }
            else if(!rightStack.empty()){
                int currentDrop = rightStack.peek();
                heights[currentDrop]++;
                if (heights[currentDrop] >= heights[currentDrop - 1]){
                    rightStack.pop();
                }
                if (heights[currentDrop] > heights[rightWall]){
                    rightStack.push(currentDrop + 1);
                }
            } else {
                heights[K]++;
                if (K != leftWall){
                    leftStack.push(K - 1);
                }
                if (K != rightWall){
                    rightStack.push(K + 1);
                }
            }

        }


        return heights;
    }
}