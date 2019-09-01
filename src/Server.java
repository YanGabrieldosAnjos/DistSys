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
    public void reader(String path,int env) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String line = "";
        while (true) {
            if (line != null) {
                if(env ==0)
                    System.out.println(line);
                if(env == 1)
                    listOfFiles.add(line);
                if(env == 2)
                    existingServers.add(line);
            } else
                break;
            line = buffRead.readLine();
        }
        buffRead.close();
    }

    public static void writer(String path, String msg) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        if(msg.length() == 0) {
            String line = "";
            Scanner in = new Scanner(System.in);
            System.out.println("Escreva algo: ");
            line = in.nextLine();
            buffWrite.append(line + "\n");
        }else {
            buffWrite.append(msg);
        }
        buffWrite.close();
    }
    public void addFileToList(String path){
        try{
            listOfFiles.add(path);
            writer(root+"ExistingFiles.txt",path);
        }catch (Throwable e){
            System.out.println("Não foi possível adcionar a lista\n"+e);
        }
    }
    public  void getSavedFileList(){
        try{
            reader(root+"ExistingFiles.txt",1);
        }catch (Throwable e){
            System.out.println("Não foi possivel carregar arquivos existentes");
        }
    }
    public void addServerToList(String path){
        try{
            existingServers.add(path);
            writer(root+"ExistingServers.txt",path);
        }catch (Throwable e){
            System.out.println("Não foi possível adcionar a lista\n"+e);
        }
    }
    public  void getSavedServerList(){
        try{
            reader(root+"ExistingServers.txt",1);
        }catch (Throwable e){
            System.out.println("Não foi possivel carregar servidores conhecidos");
        }
    }
    public String searchFile(String name){
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
