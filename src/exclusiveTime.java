import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class exclusiveTime {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        int lastTime = 0;
        int[] starts = new int[n];



        for(String log : logs){

            String[] content = log.split(":");
            int index = Integer.parseInt(content[0]);
            String sOrE = content[1];
            int time = Integer.parseInt(content[1]);

            if (!stack.isEmpty()){
                int currentFunc = stack.peek();
                result[currentFunc] += time - lastTime;
            }

            if (sOrE.equals("start")) {
                stack.push(index);
                starts[index] = time;
            } else{
                starts[index] = -1;
            }

            while (!stack.isEmpty() && starts[stack.peek()] == -1){
                stack.pop();
            }

            lastTime = time;
        }

        return result;
    }
}