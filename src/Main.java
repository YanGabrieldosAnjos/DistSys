import java.io.IOException;

class Main {
    public static int fib(int n){
        if(n <= 1){
            return n;
        }else{
            return fib(n-1) + fib(n-2);
        }
    }
    public static void main(String[] args) throws IOException {
        Server server = new Server("localhost");
        String path = "file.txt";
        server.addFileToList(path);
        String fileOfServer = server.searchFile("file.txt");

        System.out.println(fileOfServer);
    }
}