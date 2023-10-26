package com.buttonow.simplecrudapp;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.List;

public class SimpleCrudController {
    public ListView<String> itemList;
    public TextField itemInput;

    private static final String DATA_FILE = "data.txt";

    @FXML
    private void addItem() {
        String itemText = itemInput.getText().trim();
        if (!itemText.isEmpty()) {
            itemList.getItems().add(itemText);
            itemInput.clear();
        }
    }

    @FXML
    private void updateItem() {
        String selectedItem = itemList.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            String updatedText = itemInput.getText().trim();
            if (!updatedText.isEmpty()) {
                itemList.getItems().set(itemList.getSelectionModel().getSelectedIndex(), updatedText);
                itemInput.clear();
            }
        }
    }

    @FXML
    private void deleteItem() {
        int selectedIndex = itemList.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            itemList.getItems().remove(selectedIndex);
            itemInput.clear();
        }
    }

    @FXML
    private void saveItems() {
        List<String> items = itemList.getItems();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE))) {
            for (String item : items) {
                writer.write(item);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void loadItems() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                itemList.getItems().add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
