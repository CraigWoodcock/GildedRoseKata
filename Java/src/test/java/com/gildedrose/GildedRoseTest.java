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
    @DisplayName("Test output for 30 days")
    @Test
    void testDayTwo(){
        for (int i=0; i <= 30; i++){
            System.out.println("Day Number: "+i+1);

        app1.updateQuality();
        for (Item item : app1.items) {
            System.out.println(item);
        }}
    }

    @Test
     void testItem1() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("+5 Dexterity Vest", app1.items[0].name);
    }

}
