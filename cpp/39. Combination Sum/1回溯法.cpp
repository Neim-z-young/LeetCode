#include<iostream>
#include<vector>
#include<set>
#include<algorithm>
using namespace std;
//200 ms
class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> ans;
        int size = candidates.size();
        for(int i=0; i<size; i++){
            if(target>candidates[i]){
                vector<vector<int>> tmp = combinationSum(candidates, target-candidates[i]);   
                for(int j=0; j<tmp.size(); j++){
                    tmp[j].push_back(candidates[i]);
                    sort(tmp[j].begin(), tmp[j].end());
                    ans.push_back(tmp[j]);
                }
            }else if(target==candidates[i]){
                ans.push_back({candidates[i]});
            }
        }
        set<vector<int>> sets;
        for(int j=0; j<ans.size(); j++){
            //用集合减少重复
            sets.insert(ans[j]);
        }
        ans.clear();
        for(set<vector<int>>::iterator iter=sets.begin(); iter!=sets.end(); iter++){
            ans.push_back(*iter);
        }
        return ans;
    }
};
int main(int argc, char const *argv[])
{
    
    return 0;
}
