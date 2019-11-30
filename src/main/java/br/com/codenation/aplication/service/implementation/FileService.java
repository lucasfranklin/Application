package br.com.codenation.aplication.service.implementation;

import br.com.codenation.aplication.annotation.ColumnAnnotation;
import br.com.codenation.aplication.annotation.ColumnAnnotation;

import java.awt.geom.Arc2D;
import java.io.*;
import java.math.BigDecimal;
import java.util.Scanner;

public class FileService {

    AplicationService App = new AplicationService();

    @ColumnAnnotation(text = "Metodo que faz leitura do arquivo.")
    public void openFile(String fileName) {

        String line = "";
        String cvsSplitBy = ";";
        Long id = 0L;

        try (BufferedReader br = new BufferedReader(new FileReader(getClass().getClassLoader().getResource(fileName).getFile()))) {

            while ((line = br.readLine()) != null) {
                if (id > 0L) {
                    if (fileName.contentEquals("usuarios.txt")) {
                        String[] data = line.split(cvsSplitBy);
                        App.createUser(id, data[0], data[1], Integer.parseInt(data[2]), data[3], App.cryptoPassword(data[4]), Long.parseLong(data[5]),new BigDecimal(data[6]));
                    } else if (fileName.contentEquals("empresa.txt")) {
                        String[] data = line.split(cvsSplitBy);
                        App.createCompany(id, data[0], data[1], Integer.parseInt(data[2]), data[3]);
                    }
                }
                id = id + 1L;
            }

            App.printAllUsers();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void temp(){
        App.printBiggetsSalaryByCompany();
    }

}
