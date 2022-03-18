package com.ford.grocery;

import com.ford.grocery.model.dto.CalculateDTO;
import com.ford.grocery.model.product.base.BaseProduct;
import com.ford.grocery.service.CalculateService;

import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Application for ford assignment
 */
public class GroceryApplication {

    public static void main(String[] args) throws ScriptException, NoSuchMethodException {

        Scanner scanner = new Scanner(System.in);
        String offerLine = scanner.nextLine();

        calculate(offerLine);
    }

    public static void calculate(String offerLine) throws ScriptException, NoSuchMethodException {
        String[] productArray = offerLine.split(" ");

        List<BaseProduct> productList = new ArrayList<>();
        List<String> productListText = Arrays.asList(productArray);

        int day = Integer.parseInt(productListText.get(productListText.size() - 1));

        productListText.subList(0, productListText.size() - 1).forEach(g -> productList.add(CalculateDTO.convertStringToProduct(g)));

        String text = CalculateService.calculate(CalculateDTO.generateDTO(productList), productList, day);

        System.out.print(text);
    }
}

