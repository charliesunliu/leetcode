import java.util.HashSet;

class isEscapePossible {

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        HashSet<String> block = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        for (int[] xy : blocked){
            String s = xy[0] + "," + xy[1];
            block.add(s);
        }
        return search(block, visited, source[0], source[1], target[0]+","+target[1]) ||
                search(block, visited, target[0], target[1], source[0]+","+source[1]);
    }
    private boolean search(HashSet<String> block, HashSet<String> visted, int x, int y, String destination){
        String xy = x + "," + y;
        if(block.contains(xy) || x < 0 || x >= 1e6 || y < 0 || y >= 1e6 || visted.contains(xy)){
            return false;
        }
        if (destination.equals(xy)){
            return true;
        }
        visted.add(xy);
        if (visted.size() > 20000){
            return true;
        }
        return search(block, visted, x - 1, y - 1, destination) || search(block, visted, x + 1, y - 1, destination)
                || search(block, visted, x - 1, y + 1, destination) || search(block, visted, x + 1, y + 1, destination);
    }
}