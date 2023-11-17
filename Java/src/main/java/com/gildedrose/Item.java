package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    void updateItems() {
        boolean isAgedBrie = name.equals("Aged Brie");
        boolean isBackstagePasses = !name.equals("Backstage passes to a TAFKAL80ETC concert");
        boolean isSulfuras = name.equals("Sulfuras, Hand of Ragnaros");
        if (isAgedBrie) {
            if (quality < 50) {
                quality = quality + 1;

            }

            sellIn = sellIn - 1;

            if (sellIn < 0) {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }
        } else if (isBackstagePasses) {
                if (quality > 0) {
                    if (!isSulfuras) {
                        quality -= 1;
                    }
                }

                if (!isSulfuras) {
                    sellIn = sellIn - 1;
                }

                if (sellIn < 0) {
                    if (quality > 0) {
                        if (!isSulfuras) {
                            quality -= 1;
                        }
                    }
                }
            } else {
                if (quality < 50) {
                    quality = quality + 1;

                    if (sellIn < 11) {
                        if (quality < 50) {
                            quality = quality + 1;
                        }
                    }

                    if (sellIn < 6) {
                        if (quality < 50) {
                            quality = quality + 1;
                        }
                    }
                }

            sellIn = sellIn - 1;

            if (sellIn < 0) {
                    quality = 0;
                }
            }
        }


    @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
