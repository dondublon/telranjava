package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        String text="lmn va a ab a a lmn lmn ab";
        var varlist = Sorter.split(text);
        Sorter.sort(varlist);
        for (var pair: varlist) {
            System.out.println(pair);
        }

    }
}