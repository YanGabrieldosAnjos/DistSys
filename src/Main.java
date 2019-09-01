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

        //String path = "gg.txt";
        //server.addFileToList(path);
        server.writer(server.root+"ExistingFiles.txt","");
    }
}