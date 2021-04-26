import java.io.File;
import java.util.Scanner;

public class Computadores {
    public static void main(String[] args) throws Exception {  
        File pasta = new File("testes");
        
        for(File teste : pasta.listFiles()){
            Arvore arvore = new Arvore(); 
            Scanner sc = new Scanner(teste); 
            sc.useDelimiter(","); 
            while(sc.hasNextLine()){ 
                arvore.add(sc.next().trim(),sc.next().trim(),sc.next().trim());
            }
            System.out.println("Teste: " + teste.getName() + " | " + arvore);
            sc.close();
        }

    } 
}