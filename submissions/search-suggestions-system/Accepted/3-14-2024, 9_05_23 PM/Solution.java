// https://leetcode.com/problems/search-suggestions-system

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List output = new ArrayList<>();
        int index = 1;
        while(index < searchWord.length()+1){
            List prodList = new ArrayList<>();
            String subStr = searchWord.substring(0, index);
            for(String str: products){
                String subProd;
                if(index <= str.length()) subProd = str.substring(0, index);
                else continue;
                
                if(subStr.equals(subProd)) prodList.add(str);
                if(prodList.size() == 3) break;
            }
            index++;
            output.add(prodList);
        }
        return output;
    }
}