import java.util.Scanner;

public class Baitap {


    public static void main(String[] args) {
        int choice;

        int[] arr = new int[100];
        int size = 0;

        Scanner sc = new Scanner(System.in);
        do {
            menu();
            System.out.print("Nhập lựa chọn: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    size = inputSize();
                    inputArray(arr, size);
                    break;
                case 2:
                    displayArray(arr, size);
                    menu1();
                    break;
                case 3:
                    if (findMaxEven(arr, size) != -1) {
                        System.out.println("Số chẵn to nhất trong mảng là: " + findMaxEven(arr, size));
                    } else
                        System.out.println("Mảng không có số chẵn nào!");
                    menu1();
                    break;
                case 4:
                    displayEvent(arr,size);
                    menu1();
                    break;
                case 5:
                    System.out.println("Tổng các số chẵn trong mảng là: "+sumEvent(arr,size));
                    menu1();
                    break;
                case 6:
                    System.out.println("Nhập vị trí cần thêm");
                    int k = sc.nextInt();
                    System.out.println("Nhập giá trị cần thêm");
                    int x = sc.nextInt();
                    if (k < 0 || k > size) {
                        System.out.println("Vị trí thêm không nằm trong mảng !");
                    } else {
                        size += 1;
                        chenVaoMang(arr, size, k, x);
                    }

                    menu1();
                    break;
                case 7:
                    System.out.println("Nhập phần tử cần xóa: ");
                    int X = sc.nextInt();
                    int [] arr1=searchElement(arr,size,X);
                    if(arr1.length<=0){
                        System.out.println("Không tìm thấy số cần xóa!");
                    }
                    else {
                        deleteElement(arr, size, X);
                        size -= arr1.length;
                    }

                    menu1();
                    break;
                case 8:
                    reverseArr(arr,size);
                    menu1();
                    break;
                case 9:
                    displayPrime(arr,size);
                    menu1();
                    break;
                case 10:
                    sortArr(arr,size);
                    menu1();
                    break;
                case 11:
                    System.exit(0);
                    menu1();
                    break;
            }

        } while (choice >= 1 && choice <= 11);
    }

    static void menu() {
        System.out.println("\n========MENU===========");
        System.out.println("1. Nhập mảng có kích thước N (0<N<100)");
        System.out.println("2. Hiển thị mảng vừa nhập");
        System.out.println("3. Tìm số chẵn lớn nhất trong mảng");
        System.out.println("4. Liệt kê danh sách số chẵn trong mảng");
        System.out.println("5. Tính tổng các số chẵn trong mảng");
        System.out.println("6. Nhập vào giá trị và vị trí cần chèn của giá trị đó trong mảng, chèn giá trị đó vào mảng");
        System.out.println("7. Xoá tất cả các phần tử có giá trị bằng X  khỏi mảng");
        System.out.println("8. Đảo ngược mảng ban đầu");
        System.out.println("9. Hiển thị danh sách các số nguyên tố trong mảng");
        System.out.println("10. Sắp xếp mảng theo thứ tự giảm dần");
        System.out.println("11. Thoát");

    }

    static int inputSize() {
        int N;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Nhap kich thuoc cua mang(0<N<100): ");
            N = sc.nextInt();
        } while (N <= 0 || N >= 100);
        return N;
    }

    static void inputArray(int[] arr, int N) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap mang gom N phan tu: ");
        for (int i = 0; i < N; i++) {
            System.out.print("arr[" + i + "]=");
            arr[i] = sc.nextInt();
        }
    }

    static void displayArray(int[] arr, int N) {
        System.out.println("Mảng là: ");
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

    static int findMaxEven(int[] arr, int N) {
        int max = 0;
        boolean check = false;
        for (int i = 0; i < N; i++) {
            if (arr[i] % 2 == 0) {
                check = true;
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
        }
        if (!check) return -1;

        return max;
    }

    static void findEvent(int[] arr, int N) {
        System.out.print("Các số chẵn trong mảng là: ");
        for (int i = 0; i < N; i++) {
            if (arr[i] % 2 == 0) {
                System.out.print(arr[i] + " ");
            }
        }

    }

    static int sumEvent(int[] arr, int N) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] % 2 == 0) {
                sum += arr[i];
            }
        }
        return sum;

    }

    static void chenVaoMang(int[] arr, int N, int k, int x) {
        for (int i = N; i > k; i--) {
            arr[i] = arr[i - 1];
        }
        arr[k] = x;
    }

    static void displayEvent(int[] arr, int N) {
        System.out.print("Các số chẵn trong mảng là: ");
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    static void deleteElement(int[] arr, int N, int X) {
        int [] arr1=searchElement(arr,N,X);
        for (int i = 0; i < arr1.length; i++) {
            for (int j = arr1[i]-i; j < N; j++) {
                arr[j] = arr[j + 1];
            }
        }
    }

    static int[] searchElement(int[] arr, int n, int a) {
        int  index=0;
        int size=0;
        int[] arr1=new int[n];


        for (int i = 0; i < n; i++) {
            if (arr[i] == a){
                arr1[index]=i;
                index++;
                size++;
            }
        }
        int [] arr2 =new int[size];
        for (int i = 0; i < size; i++) {
            arr2[i]=arr1[i];
        }
        return arr2;

    }
    static void reverseArr(int[] arr, int N) {
        System.out.print("Mảng sau khi đảo: ");
        for (int i = 0, j = N - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
    static void displayPrime(int[] arr, int N){
        System.out.print("Danh sách số nguyên tố trong mảng: ");
        for (int i = 0; i < N; i++) {
            boolean check = true;
            for (int j = 2; j <= Math.sqrt(arr[i]); j++) {
                if (arr[i] % j == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.print(arr[i] + " ");
            }
        }
    }
    static void sortArr(int[] arr, int N) {
        for (int i =0; i<N-1;i++) {
            for (int j = i+1; j<N;j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.print("Mảng sau khi sắp xếp là: ");
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static void menu1(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Bấm phím bất kỳ để ra Menu");
        String str = sc.nextLine();
    }
}
