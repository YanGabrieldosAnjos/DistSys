import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Server {
    String ip,clientIp;
    String root  = "C://Users/yanga/Desktop/files/";
    ArrayList<String> existingServers = new ArrayList<>();
    ArrayList<String> listOfFiles = new ArrayList<>();

    public Server(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public ArrayList<String> getExistingServers() {
        return existingServers;
    }

    public void setExistingServers(ArrayList<String> existingServers) {
        this.existingServers = existingServers;
    }

    public ArrayList<String> getListOfFiles() {
        return listOfFiles;
    }

    public void setListOfFiles(ArrayList<String> listOfFiles) {
        this.listOfFiles = listOfFiles;
    }
    public static void reader(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String line = "";
        while (true) {
            if (line != null) {
                System.out.println(line);

            } else
                break;
            line = buffRead.readLine();
        }
        buffRead.close();
    }

    public static void writer(String path) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        String line = "";
        Scanner in = new Scanner(System.in);
        System.out.println("Escreva algo: ");
        line = in.nextLine();
        buffWrite.append(line + "\n");
        buffWrite.close();
    }
    public void addFileToList(String path){
        System.out.println(root+path);
        try{
            listOfFiles.add(root+path);
        }catch (Throwable e){
            System.out.println("Não foi possível adcionar a lista\n"+e);
        }
    }
    public String searchFile(String name){
        name = root+name;
        for (int i = 0; i < listOfFiles.size(); i++) {
            if(listOfFiles.get(i).equals(name)){
                return listOfFiles.get(i);
            }
        }

        return "O arquivo não existe";
    }
    public BufferedReader getFile(String path) throws IOException{
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        return buffRead;
    }
}
