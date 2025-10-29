package org.example;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class codeTestTest {

    @Test
    public void testEnglishBundle() {
        ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", new Locale("en", "US"));
        assertEquals("Enter the number of items to purchase:", rb.getString("numberOfItemsMessage"));
    }

    @Test
    public void testJapaneseBundle() {
        ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", new Locale("ja", "JP"));
        assertEquals("購入する商品の数を入力してください:", rb.getString("numberOfItemsMessage"));
    }
}