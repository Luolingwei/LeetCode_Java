package Interview;

import java.io.*;

public class CalculateStringInFile {

    public int countStr(File file, String target) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bf = new BufferedReader(fileReader);
        int count = 0;
        String line;
        while ((line = bf.readLine()) != null){
            int index = -1;
            while ((index = line.indexOf(target))!=-1){
                count++;
                line = line.substring(index + target.length());
            }
        }
        bf.close();
        return count;
    }
}
