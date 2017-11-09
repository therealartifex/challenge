#include <iostream>

using namespace std;

int main() {
  int t; cin >> t;
  for(int i=0; i<t; i++){
    int n, m; cin >> n >> m;
    int tree[n];
    for(int i=0; i<n; i++)tree[i] = -1;
    int treeCount = 0;
    bool loop = false;
    for(int i=0; i<m; i++){
      int a, b; cin >> a >> b;
      if(n > m && !loop){
        if(a == b)loop = true;
        else if(tree[a] != -1 && tree[a] == tree[b])loop = true;
        else if(tree[a] != -1){
          int prev = tree[b];
          if(prev != -1){
            for(int i=0; i<n; i++)
              if(tree[i] == prev)tree[i] = tree[a];
          }else{
            tree[b] = tree[a];
          }
        }else if(tree[b] != -1){
          tree[a] = tree[b];
        }else{
          tree[a] = treeCount++;
          tree[b] = tree[a];
        }
      }
    }
    if(m >= n || loop){
      cout << 1 << endl;
    }else{
      cout << 0 << endl;
    }
  }
}