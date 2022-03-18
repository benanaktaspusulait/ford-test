package com.ford.grocery;

import com.ford.grocery.service.CalculateService;

import javax.script.ScriptException;
import java.util.Scanner;

import static com.ford.grocery.service.CalculateService.calculate;

/**
 * Application for ford assignment
 */
public class GroceryApplication {

    public static void main(String[] args) throws ScriptException, NoSuchMethodException {

        Scanner scanner = new Scanner(System.in);
        String basketLine = scanner.nextLine();

        System.out.println(calculate(basketLine));
    }
}

