import java.io.IOException;
import java.util.*;

public class KvStore {

    int nextTransactionID;
    HashMap<Integer, Integer> keyValueTable;
    HashMap<Integer, Integer> keyTransactionLockTable;
    //HashMap<Integer, List<Integer>> transactionLockTable;
    HashMap<Integer, HashMap<Integer, Integer>> transactionOriginalValue;


    KvStore(){
        nextTransactionID = 1;
        keyValueTable = new HashMap<>();
        keyTransactionLockTable = new HashMap<>();
        //transactionLockTable = new HashMap<>();
        transactionOriginalValue = new HashMap<>();
    }


    public int start(){
        //transactionLockTable.put(nextTransactionID, new LinkedList<>());
        transactionOriginalValue.put(nextTransactionID, new HashMap<>());
        return nextTransactionID++;
    }

    public boolean get(int transactionID, int key){

        if (!keyValueTable.containsKey(key) || !transactionOriginalValue.containsKey(transactionID)){
            return false;
        }

        if (keyTransactionLockTable.containsKey(key) && keyTransactionLockTable.get(key) != transactionID){
            rollback(transactionID);
            return false;
        }
        if (!keyTransactionLockTable.containsKey(key)){
            keyTransactionLockTable.put(key, transactionID);
        }
        if (!transactionOriginalValue.get(transactionID).containsKey(key)){
            transactionOriginalValue.get(transactionID).put(key, keyValueTable.get(key));
        }

        return true;
    }

    public boolean set(int transactionID, int key, int newValue){

        if (!transactionOriginalValue.containsKey(transactionID)){
            return false;
        }

        if (!keyValueTable.containsKey(key)){
            keyValueTable.put(key, newValue);
            transactionOriginalValue.get(transactionID).put(key, newValue);
            keyTransactionLockTable.put(key, transactionID);
            return true;
        }

        if (keyTransactionLockTable.containsKey(key) && keyTransactionLockTable.get(key) != transactionID){
            rollback(transactionID);
            return false;
        }

        if (!keyTransactionLockTable.containsKey(key)){
            keyTransactionLockTable.put(key, transactionID);
        }
        if (!transactionOriginalValue.get(transactionID).containsKey(key)){
            transactionOriginalValue.get(transactionID).put(key, keyValueTable.get(key));
        }

        keyValueTable.put(key, newValue);

        return true;
    }

    private void rollback(int transactionID){
        HashMap<Integer, Integer> originalValue = transactionOriginalValue.get(transactionID);
        Iterator<Integer> iter = originalValue.keySet().iterator();
        while (iter.hasNext()){
            int currentKey = iter.next();
            keyTransactionLockTable.remove(currentKey);
            keyValueTable.put(currentKey, originalValue.get(currentKey));
            iter.remove();
        }

        transactionOriginalValue.remove(transactionID);
    }

    public boolean commit(int transactionID){
        if (!transactionOriginalValue.containsKey(transactionID)){
            return false;
        }


        HashMap<Integer, Integer> originalValue = transactionOriginalValue.get(transactionID);
        Iterator<Integer> iter = originalValue.keySet().iterator();



        while (iter.hasNext()){
            int currentKey = iter.next();
            keyTransactionLockTable.remove(currentKey);

            iter.remove();
        }

        transactionOriginalValue.remove(transactionID);
        return true;
    }


}
