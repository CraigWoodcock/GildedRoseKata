package com.gildedrose;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
class GildedRoseTest {

    static GildedRose app1;

    static void resetItems(){
        Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20), //
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6) };

            app1 = new GildedRose(items);

    }

//    @BeforeAll
//    @DisplayName("set All Values")
//    static void setUpAll(){
//        resetItems();
//    }
    @BeforeEach
    @DisplayName("set All Values")
    void setUpAll(){
        resetItems();
    }

    @DisplayName("Test output after 1 day")
    @Test
    void testDayOne(){
        app1.updateQuality();
        for (Item item : app1.items) {
            System.out.println(item);
        }
        System.out.println();
    }
    @DisplayName("Test Sulfuras Quality After 30 Days")
    @Test
    void testSulfurasQualityAfter30Days(){
        for (int i=0; i <= 30-1; i++){
        app1.updateQuality();
        }
        if (app1.items[3].name.equals("Sulfuras, Hand of Ragnaros")){
            Assertions.assertEquals(60,app1.items[3].quality);
            System.out.println(app1.items[3]);
        }
    }

    @Test
     void testItem1_Name() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("+5 Dexterity Vest", app.items[0].name);
    }

    @DisplayName("Test Aged Brie Quality After 30 Days")
    @Test
    void testAgedBrieQualityAfter30Days(){
        for (int i=0; i <= 30; i++){
            app1.updateQuality();
        }
        Assertions.assertEquals(50,app1.items[1].quality);
    }
}
