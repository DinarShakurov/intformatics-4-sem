package ru.shakurov.state_machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.BitSet;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        if (n == 0) {
            System.out.println();
            return;
        }
        BitSet bitSet = new BitSet();
        BitSet negativeBitSet = new BitSet();
        int current = 0;
        for (int i = 0; i < n; i++) {
            current = Integer.parseInt(reader.readLine());
            if (current >= 0) {
                if (!bitSet.get(current)) {
                    System.out.println(current);
                    bitSet.set(current);
                }
            } else{
                if (!negativeBitSet.get(-current)) {
                    System.out.println(current);
                    negativeBitSet.set(-current);
                }
            }
        }
    }
}