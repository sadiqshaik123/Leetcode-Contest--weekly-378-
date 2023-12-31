class Solution {  
    public int maximumLength(String s) {  
        int ans = 0;  
        List<List<Integer>> freq = new ArrayList<>(26);  
        for (int i = 0; i < 26; i++) {  
            freq.add(new ArrayList<>());  
        }  
        for (int i = 0; i < s.length(); i++) {  
            int j = i;  
            while (j < s.length() && s.charAt(j) == s.charAt(i)) {  
                j++;  
            }  
            freq.get(s.charAt(i) - 'a').add(j - i);  
            i = j - 1;  
        }  
        for (List<Integer> x : freq) {  
            if (x.isEmpty()) continue;  
            x.sort(Integer::compareTo);  
            int sz = x.size();  
            ans = Math.max(ans, x.get(sz - 1) - 2);  
            if (sz > 1) {  
                ans = Math.max(ans, Math.min(x.get(sz - 1) - 1, x.get(sz - 2)));  
            }  
            if (sz > 2) {  
                ans = Math.max(ans, x.get(sz - 3));  
            }  
        }  
  
        if (ans == 0) ans = -1;  
        return ans;  
    }  
}
