

import java.util.Arrays;

public class HashTableDoubleHashing {
    private static final int TABLE_SZ = 7; // a prime number
    Integer[] table;
    int count;  // number of Students in the table

    public HashTableDoubleHashing() {
        table = new Integer[TABLE_SZ];
        count = 0;
    }

    public void insertDoubleHashing (Integer s) throws TableFullException {
        int index = (s.hashCode())%TABLE_SZ;
        if (ContainsKeyDoubleHashing(s)){
            return;
        }
        if (count == TABLE_SZ){
            throw  new  TableFullException();
        }
        if (table[index] == null){
            table[index] = s;
            count++;
            return;
        }else{
            int jump = secondHash(s);
            for (int i = index; true ; i = i + jump) {
                if (i == TABLE_SZ || i > TABLE_SZ){
                    int indexies = i%TABLE_SZ;
                    if (table[indexies] == null){
                        table[indexies] = s;
                        count++;
                        break;
                    }
                    continue;
                }
                if (table[i] == null){
                    table[i] = s;
                    count++;
                    break;
                }
            }
        }
    }
    public boolean ContainsKeyDoubleHashing (Integer s){
        int countie = 0;
        int index = (s.hashCode())%TABLE_SZ;
        if (table[index]!=null){
            if (table[index].equals(s)){
                return true;
            }
        }
        int jump = secondHash(s);
        for (int i = index; true ; i = i + jump) {
            countie++;
            if (countie > TABLE_SZ){
                break;
            }
            if (i == TABLE_SZ || i > TABLE_SZ){
                int indexies = i%TABLE_SZ;
                if (table[indexies] != null){
                   if (table[indexies].equals(s)){
                       return true;
                   }
                }
                continue;
            }
            if (table[i] != null){
                if (table[i].equals(s)){
                    return true;
                }
            }
        }
        return false;
    }
    public int secondHash(Integer s){
        return 5 -((s.hashCode()) % 5);
    }

    @Override
    public String toString() {
        return "HashTableDoubleHashing{" +
                "table=" + Arrays.toString(table) +
                ", count=" + count +
                '}';
    }

    public static void main(String[] args) throws TableFullException {

        HashTableDoubleHashing hash = new HashTableDoubleHashing();
        hash.insertDoubleHashing(2);
        hash.insertDoubleHashing(3);
        hash.insertDoubleHashing(10);
        hash.insertDoubleHashing(16);
        hash.insertDoubleHashing(23);
        hash.insertDoubleHashing(41);
        hash.insertDoubleHashing(44);
        hash.insertDoubleHashing(44);

        System.out.println(hash.toString());


    }
}
