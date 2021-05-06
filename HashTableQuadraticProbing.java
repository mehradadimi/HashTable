

import java.util.Arrays;

public class HashTableQuadraticProbing {
    private static final int TABLE_SZ = 7; // a prime number

    Integer[] table;
    int count;  // number of Students in the table

    public HashTableQuadraticProbing() {
        table = new Integer[TABLE_SZ];
        count = 0;
    }

    public void insertQuadraticProbing (Integer s) throws TableFullException {
        int index = (s.hashCode())%TABLE_SZ;
        int countie = 0;
        int countOFiters=0;
        if (ContainsKeyQuadraticProbing(s)){
            System.out.println("Already there");
            return;
        }
        if (count == TABLE_SZ){
            throw new TableFullException();
        }
        if (table[index] == null){
            table[index] = s;
            count++;
            return;
        }else{
            for (int i = index; true ; i = index + (countie*countie)) {
                if (countOFiters > 100){
                    System.out.println("NO NO NO");
                    break;
                }
                if (i == TABLE_SZ || i > TABLE_SZ){
                    int indexies = i % TABLE_SZ;
                    if (table[indexies] == null){
                        table[indexies] = s;
                        count++;
                        break;
                    }
                    countOFiters++;
                    countie++;
                    continue;
                }
                if (table[i] == null){
                    table[i] = s;
                    count++;
                    break;
                }
                countOFiters++;
                countie++;
            }

        }

    }
    public boolean ContainsKeyQuadraticProbing (Integer s){
        int countOfIters = 0;
        int countMe = 0;
        int index = (s.hashCode())%TABLE_SZ;
        if (table[index]!=null){
            if (table[index].equals(s)){
                return true;
            }
        }
        for (int i = index; true ; i = index + (countMe*countMe)) {
            if (countOfIters > TABLE_SZ+10){
                return false;
            }
            if (i == TABLE_SZ || i > TABLE_SZ){
                int indexies = i % TABLE_SZ;
                if (table[indexies] != null){
                    if (table[indexies].equals(s)){
                        return true;
                    }
                }
                countOfIters++;
                countMe++;
                continue;
            }
            if (table[i] != null){
                if (table[i].equals(s)){
                    return true;
                }
            }
            countOfIters++;
            countMe++;
        }
    }

    @Override
    public String toString() {
        return "HashTableQuadraticProbing{" +
                "table=" + Arrays.toString(table) +
                ", count=" + count +
                '}';
    }

    public static void main(String[] args) throws TableFullException {

        HashTableQuadraticProbing hash = new HashTableQuadraticProbing();
        hash.insertQuadraticProbing(2);
        hash.insertQuadraticProbing(3);
        hash.insertQuadraticProbing(10);
        hash.insertQuadraticProbing(16);
        hash.insertQuadraticProbing(22);
        hash.insertQuadraticProbing(24);
        hash.insertQuadraticProbing(25);
        hash.insertQuadraticProbing(25);
        hash.insertQuadraticProbing(24);
        hash.insertQuadraticProbing(22);


        System.out.println(hash.toString());


    }
}
