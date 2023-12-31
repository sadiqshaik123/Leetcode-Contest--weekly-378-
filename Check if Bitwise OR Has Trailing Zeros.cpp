#include <vector>

class Solution {
public:
    bool hasTrailingZeros(std::vector<int>& nums) {
        int n = nums.size();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if ((nums[i] | nums[j]) % 2 == 0) {
                    return true;
                }
            }
        }
        return false;
    }
};
