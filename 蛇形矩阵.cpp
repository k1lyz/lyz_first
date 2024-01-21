#include <iostream>
#include <iomanip>
#define X 10
using namespace std;

void snack(int n){
    int snackarray[X][X];
    int num = n;
    int k = 1;
    int start = 0;
    int end = n - 1;

    while (k <= n * n) {
        // ÏòÓÒÌî³ä
        for (int i = start; i <= end; i++) {
            snackarray[start][i] = k++;
        }
        // ÏòÏÂÌî³ä
        for (int i = start + 1; i <= end; i++) {
            snackarray[i][end] = k++;
        }
        // Ïò×óÌî³ä
        for (int i = end - 1; i >= start; i--) {
            snackarray[end][i] = k++;
        }
        // ÏòÉÏÌî³ä
        for (int i = end - 1; i > start; i--) {
            snackarray[i][start] = k++;
        }

        start++;
        end--;
    }

    // ´òÓ¡¾ØÕó
    for (int i = 0; i < num; i++) {
        for (int j = 0; j < num; j++) {
            cout<<setfill('*')<<setw(4)<<snackarray[i][j];
        }
        cout << endl;
    }
}

int main() {
    int n;
    cin >> n;
    snack(n);
    return 0;
}

