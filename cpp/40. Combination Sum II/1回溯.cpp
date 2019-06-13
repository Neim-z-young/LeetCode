#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
//照搬上一题方法，只需修改部分细节
class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
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
                //从不小于candidates[i]开始递归，避免重复
                vector<vector<int>> tmp = combinationSumWithIndexInc(candidates, target-candidates[i], i+1);
                for(int j=0; j<tmp.size(); j++){
                    tmp[j].push_back(candidates[i]);
                    ans.push_back(tmp[j]);
                }
                while(i<size-1&&candidates[i]==candidates[i+1]){
                    i++;
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
