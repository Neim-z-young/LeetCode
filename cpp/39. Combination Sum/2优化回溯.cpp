#include<iostream>
#include<vector>
#include<set>
#include<algorithm>
using namespace std;
//回溯法
//28 ms, 优化效果明显
class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        return (combinationSumWithIndexInc(candidates, target, 0));
    }
private:
    //假设输入是有序的
    vector<vector<int>> combinationSumWithIndexInc(vector<int> candidates, int target, int index){
        vector<vector<int>> ans;
        int size = candidates.size();
        int count=0;
        for(int i=index; i<size; i++){
            if(target>candidates[i]){
                while(i<size-1&&candidates[i]==candidates[i+1]){
                    i++;
                }
                //从不小于candidates[i]开始递归，避免重复
                vector<vector<int>> tmp = combinationSumWithIndexInc(candidates, target-candidates[i], i);   
                set<vector<int>> sets;
                for(int j=0; j<tmp.size(); j++){
                    tmp[j].push_back(candidates[i]);
                    sort(tmp[j].begin(), tmp[j].end());
                    //用集合减少重复
                    sets.insert(tmp[j]);
                }
                for (set<vector<int>>::iterator iter = sets.begin();
                     iter != sets.end(); iter++) {
                    ans.push_back(*iter);
                }
            } else if (target == candidates[i]) {
                count++;
                //减少重复
                if(count==1)
                    ans.push_back({candidates[i]});
            }
        }
        return ans;
    }
};
int main(int argc, char const *argv[])
{
    
    return 0;
}
