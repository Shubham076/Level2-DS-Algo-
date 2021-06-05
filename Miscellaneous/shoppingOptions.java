/*
amazon oa question
A customer wants to buy a pair of jeans, a pair of shoes, a skirt, and a top but has a limited budget in dollars. Given different pricing options for each product, determine how many options our customer has to buy 1 of each product. You cannot spend more money than the budgeted amount.

Example
priceOfJeans = [2, 3]
priceOfShoes = [4]
priceOfSkirts = [2, 3]
priceOfTops = [1, 2]
budgeted = 10

The customer must buy shoes for 4 dollars since there is only one option. This leaves 6 dollars to spend on the other 3 items. Combinations of prices paid for jeans, skirts, and tops respectively that add up to 6 dollars or less are [2, 2, 2], [2, 2, 1], [3, 2, 1], [2, 3, 1]. There are 4 ways the customer can purchase all 4 items.

Function Description

Complete the getNumberOfOptions function in the editor below. The function
must return an integer which represents the number of options present to buy
the four items.
*/

import java.util.*;
class shoppingOptions{
    public static int getSingleItemways(List<Integer> item, int budget){
        int count = 0;
        for(int i : item){
            if(i <= budget){
                count++;
            }
        }
        return count;
    }
    public static int getNumberOfOptions(List<List<Integer>> items, int budget){
        if(budget< 0){
            return 0;
        }

        if(items.size() == 1){
            return getSingleItemways(items.get(0), budget);
        }

        int cnt = 0;
        for(int i : items.get(0)){
            if(i <= budget){
                List<Integer> temp = items.get(0);
                items.remove(0);
                cnt += getNumberOfOptions(items, budget - i);
                items.add(0, temp);
            }
        }

        return cnt;
    }
    public static void main(String[] args){
        List<Integer> jeans = new ArrayList<>();
        List<Integer> shoes = new ArrayList<>();
        List<Integer> skirts = new ArrayList<>();
        List<Integer> tops = new ArrayList<>();
        List<List<Integer>> items = new ArrayList<>();
        jeans.add(2);
        jeans.add(3);
        shoes.add(4);
        skirts.add(2);
        skirts.add(3);
        tops.add(1);
        tops.add(2);

        //
        items.add(jeans);
        items.add(shoes);
        items.add(skirts);
        items.add(tops);
        int budget = 10;

        System.out.println(getNumberOfOptions(items, budget));
    }
}