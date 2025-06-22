class Solution {
    public static void nextPermutation(int[] num) {
        int n = num.length;
        int ind = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (num[i] < num[i + 1]) {
                ind = i;
                break;
            }
        }

        if (ind == -1) {
            rev(num, 0, n - 1);
            return;
        }

        for (int i = n - 1; i > ind; i--) {
            if (num[i] > num[ind]) {
                swap(num, i, ind);
                break;
            }
        }

        rev(num, ind + 1, n - 1);
        return;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void rev(int[] arr, int a, int b) {
        while (a < b) {
            swap(arr, a, b);
            a++;
            b--;
        }
    }
}