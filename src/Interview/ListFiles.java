package Interview;

import java.io.File;

public class ListFiles {

    public void listFile(File file){
        if (file == null || !file.exists()) return;
        if (!file.isDirectory()){
            System.out.println(file.getName());
        }
        for (File subfile: file.listFiles()){
            listFile(subfile);
        }

    }


}
