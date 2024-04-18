// https://leetcode.com/problems/successful-pairs-of-spells-and-potions

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int maxPotion = 1;
        for (int potion : potions) maxPotion = Math.max(potion, maxPotion);
        
        int[] potionCount = new int[maxPotion + 1];
        for (int potion : potions) potionCount[potion]++;

        for (int i = maxPotion - 1; i >= 0; i--)
            potionCount[i] += potionCount[i + 1];

        for (int i = 0; i < spells.length; i++) {
            int requiredPotion = Math.toIntExact(Math.min((success + spells[i] - 1) / spells[i], 100001));
            spells[i] = requiredPotion > maxPotion ? 0 : potionCount[requiredPotion];
        }
        return spells;
    }
}