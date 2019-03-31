#include<iostream>
#include<unordered_map>
using namespace std;
//未解决重复问题
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        int size = nums.size();
        if(size<3) return vector<vector<int>>();
        vector<vector<int>> res;
        //map中存放的是每个元素访问的次数
        unordered_map<int, int> map;
        for(int i=0; i<size; i++){
            map[nums[i]] =0;
        }
        for(int i=0; i<size; i++){
            map[nums[i]] += 1;
            int remain = 0 - nums[i];
            vector<vector<int>> restwo = twoSum(nums, i, remain, nums[i], map);
            res.insert(res.end(), restwo.begin(), restwo.end());
        }
        return res;
    }
private:
    vector<vector<int>> twoSum(vector<int> nums, int end, int sum, int first, unordered_map<int, int>& map){
        vector<vector<int>> res;
        int size = nums.size();
        for(int i=0; i<end; i++){
            int remain = sum - nums[i];
            unordered_map<int, int>::const_iterator got = map.find(remain);
            if(got!=map.end()&&got->second!=0){
                if(nums[i]==remain&&remain==first&&map[first]==3){
                    map[first]+=3;
                    res.push_back(vector<int>({nums[i], remain, first}));
                }
                else if(nums[i]==remain&&remain!=first&&((map[remain]>1&&map[first]==1)||(map[remain]==2&&map[first]>1))){
                    if(map[first]!=1) map[first]+=1;
                    map[remain]+=2;
                    res.push_back(vector<int>({nums[i], remain, first}));
                }
                else if(nums[i]!=remain&&remain==first&&((map[remain]>1&&map[nums[i]]==1)||(map[remain]==2&&map[nums[i]]>1))){
                    if(map[nums[i]]!=1) map[nums[i]]+=1;
                    map[remain]+=2;
                    res.push_back(vector<int>({nums[i], remain, first}));
                }
                else if(nums[i]!=remain&&nums[i]==first&&((map[first]>1&&map[remain]==1)||(map[first]==2&&map[remain]>1))){
                    if(map[remain]!=1) map[remain]+=1;
                    map[first]+=2;
                    res.push_back(vector<int>({nums[i], remain, first}));
                }
                else if(nums[i]!=remain&&remain!=first&&(map[first]==1||map[remain]==1||map[nums[i]]==1)){
                    if(map[nums[i]]!=1) map[nums[i]]+=1;
                    if(map[remain]!=1) map[remain]+=1;
                    if(map[first]!=1) map[first]+=1;
                    res.push_back(vector<int>({nums[i], remain, first}));
                }
                else ;
            }
        }
        return res;
    }
};
int main(int argc, char const *argv[])
{
    Solution ans;
    ans.threeSum(vector<int>({-1, 0, 1, 2, -1, -4}));
    return 0;
}
